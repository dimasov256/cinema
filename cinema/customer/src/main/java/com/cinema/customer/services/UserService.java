package com.cinema.customer.services;


import com.cinema.amqp.RabbitMqMessageProducer;
import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.fraud.FraudClient;
import com.cinema.clients.notification.models.NotificationDto;
import com.cinema.customer.domain.User;
import com.cinema.customer.repositories.UserRepository;
import com.cinema.customer.repositories.criteria.UserSearchDao;
import com.cinema.customer.services.pagenation.UserPageList;
import com.cinema.customer.web.controller.NotFoundException;
import com.cinema.customer.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.domain.PageRequest.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FraudClient fraudClient;
    private final UserMapper userMapper;
    private final RabbitMqMessageProducer rabbitMqMessageProducer;
    private final UserSearchDao userSearchDao;

    public Page<UserDto> getAllUsersPageable(String name, int page, int size) {
        Page<User> userPage = userRepository.findByNameContaining(name, of(page, size));
        return new UserPageList(userPage.stream().map(userMapper::userToUserDto).collect(toList()),
                PageRequest.of(page, size), userPage.getTotalElements());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(toList());
    }

    public UserDto getUserById(Long userId) {
        return userMapper
                .userToUserDto(userRepository
                        .findById(userId).orElseThrow(() -> new NotFoundException("No have User with ID: " + userId)));
    }

    public UserDto createUser(UserDto userDto) {

        User user = userRepository.saveAndFlush(userMapper.userDtoToUser(userDto));

        UserDto userToSave = userMapper.userToUserDto(user);

        //todo check if email valid
        //todo check if email not taken
        //todo check is fraudster
        boolean isUserFraudster = fraudClient.isFraudster(user.getId());

        if (isUserFraudster) {
            throw new IllegalStateException("Alert, user with ID: " + "is Fraudster");
        }

        NotificationDto notificationToSave = NotificationDto.builder()
                .message("User with ID: " + userToSave.getId() + " was registered")
                .sender(userToSave.getName())
                .toUserId(userToSave.getId())
                .toUserEmail(userToSave.getEmail())
                .build();


        rabbitMqMessageProducer.publish(
                notificationToSave,
                "internal.exchange",
                "internal.notification.routing-key"
        );

        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userToSave)));
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        UserDto userToSave = userMapper
                .userToUserDto(userRepository
                        .findById(userId).orElseThrow(() -> new NotFoundException("No have User with ID: " + userId)));

        userToSave.setName(userDto.getName());
        userToSave.setPassword(userDto.getPassword());
        userToSave.setPicByte(userDto.getPicByte());
        userToSave.setAmountAvailable(userDto.getAmountAvailable());
        userToSave.setAmountReserved(userDto.getAmountReserved());

        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }

    public void resetUserPassword(Long userId) {
        User user = userRepository.findById(userId).get();
        user.setPassword("secret");
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDto> getAllUsersByNameOrEmail(String name, String email){
       return userSearchDao.findAllUsersBySimpleQuery(name, email).stream().map(userMapper::userToUserDto).collect(toList());
    }

    public UserDto uploadImage(Long userId, MultipartFile file) throws IOException {

        UserDto user = userMapper.userToUserDto(userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No have User with ID: " + userId)));

        if (user == null) {
            throw new RuntimeException("No found user with ID: " + userId);
        } else if (file.getSize() >= 1000000) {
            throw new RuntimeException("File is exceeds maximum size: " + file.getSize());
        }

        user.setPicByte(compressBytes(file.getBytes()));

        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(user)));
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            System.out.println();
        }
        System.out.println("Compressed image byte size: " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

}

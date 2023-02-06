package com.cinema.customer.services;


import com.cinema.amqp.RabbitMqMessageProducer;
import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.fraud.FraudClient;
import com.cinema.clients.notification.models.NotificationDto;
import com.cinema.customer.domain.User;
import com.cinema.customer.repositories.UserRepository;
import com.cinema.customer.web.controller.NotFoundException;
import com.cinema.customer.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FraudClient fraudClient;
    private final UserMapper userMapper;
    private final RabbitMqMessageProducer rabbitMqMessageProducer;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long userId) {
        return userMapper
                .userToUserDto(userRepository
                        .findById(userId).orElseThrow(() -> new NotFoundException("No have User with ID: " + userId)));
    }

    public UserDto createUser(UserDto userDto) {

        User user = userRepository.saveAndFlush(userMapper.userDtoTouSer(userDto));

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

        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoTouSer(userToSave)));
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        UserDto userToSave = userMapper
                .userToUserDto(userRepository
                        .findById(userId).orElseThrow(() -> new NotFoundException("No have User with ID: " + userId)));

        userToSave.setName(userDto.getName());
        userToSave.setPassword(userDto.getPassword());
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoTouSer(userDto)));
    }

    public void resetUserPassword(Long userId) {
        User user = userRepository.findById(userId).get();
        user.setPassword("secret");
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

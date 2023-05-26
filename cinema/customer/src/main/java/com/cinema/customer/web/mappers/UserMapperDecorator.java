package com.cinema.customer.web.mappers;


import com.cinema.clients.customer.model.UserDto;
import com.cinema.customer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public abstract class UserMapperDecorator implements UserMapper {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public UserDto userToUserDto(User user) {
        user.setPicByte(decompressBytes(user.getPicByte()));
        if (user.getPicByte() == null) {

        } else {
            System.out.println("User: " + user.getPicByte().length);
        }

        return userMapper.userToUserDto(user);
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        return userMapper.userDtoToUser(userDto);
    }

    public static byte[] decompressBytes(byte[] data) {
        if (data == null) {
            return null;
        }
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
            System.out.println(e.toString());
        }
        return outputStream.toByteArray();
    }
}

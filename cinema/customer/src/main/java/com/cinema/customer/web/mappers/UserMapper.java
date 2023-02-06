package com.cinema.customer.web.mappers;


import com.cinema.clients.customer.model.UserDto;
import com.cinema.customer.domain.User;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoTouSer(UserDto userDto);
}

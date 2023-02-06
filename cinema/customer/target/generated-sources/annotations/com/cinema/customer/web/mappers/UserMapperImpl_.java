package com.cinema.customer.web.mappers;

import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.customer.model.UserDto.UserDtoBuilder;
import com.cinema.customer.domain.User;
import com.cinema.customer.domain.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T12:20:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class UserMapperImpl_ implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.lastUpdate( user.getLastUpdate() );
        userDto.name( user.getName() );
        userDto.password( user.getPassword() );
        userDto.email( user.getEmail() );
        userDto.amountAvailable( user.getAmountAvailable() );
        userDto.amountReserved( user.getAmountReserved() );

        return userDto.build();
    }

    @Override
    public User userDtoTouSer(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.lastUpdate( userDto.getLastUpdate() );
        user.name( userDto.getName() );
        user.password( userDto.getPassword() );
        user.email( userDto.getEmail() );
        user.amountAvailable( userDto.getAmountAvailable() );
        user.amountReserved( userDto.getAmountReserved() );

        return user.build();
    }
}

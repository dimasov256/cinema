package com.cinema.customer.web.mappers;

import com.cinema.clients.customer.model.CinemaHallDto;
import com.cinema.clients.customer.model.CinemaHallDto.CinemaHallDtoBuilder;
import com.cinema.clients.customer.model.CityDto;
import com.cinema.clients.customer.model.CityDto.CityDtoBuilder;
import com.cinema.clients.customer.model.FilmDto;
import com.cinema.clients.customer.model.FilmDto.FilmDtoBuilder;
import com.cinema.clients.customer.model.LayoutCapacityDto;
import com.cinema.clients.customer.model.LayoutCapacityDto.LayoutCapacityDtoBuilder;
import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.customer.model.UserDto.UserDtoBuilder;
import com.cinema.customer.domain.CinemaHall;
import com.cinema.customer.domain.CinemaHall.CinemaHallBuilder;
import com.cinema.customer.domain.City;
import com.cinema.customer.domain.City.CityBuilder;
import com.cinema.customer.domain.Film;
import com.cinema.customer.domain.Film.FilmBuilder;
import com.cinema.customer.domain.LayoutCapacity;
import com.cinema.customer.domain.LayoutCapacity.LayoutCapacityBuilder;
import com.cinema.customer.domain.User;
import com.cinema.customer.domain.User.UserBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-02T07:30:57+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class FilmMapperImpl_ implements FilmMapper {

    @Override
    public FilmDto filmToFilmDto(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDtoBuilder filmDto = FilmDto.builder();

        filmDto.id( film.getId() );
        filmDto.lastUpdate( film.getLastUpdate() );
        filmDto.cinemaHall( cinemaHallToCinemaHallDto( film.getCinemaHall() ) );
        filmDto.user( userToUserDto( film.getUser() ) );
        filmDto.layout( film.getLayout() );
        filmDto.title( film.getTitle() );
        filmDto.date( film.getDate() );
        filmDto.startTime( film.getStartTime() );
        filmDto.endTime( film.getEndTime() );
        filmDto.participants( film.getParticipants() );

        return filmDto.build();
    }

    @Override
    public Film filmDtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        FilmBuilder film = Film.builder();

        film.id( filmDto.getId() );
        film.lastUpdate( filmDto.getLastUpdate() );
        film.cinemaHall( cinemaHallDtoToCinemaHall( filmDto.getCinemaHall() ) );
        film.user( userDtoToUser( filmDto.getUser() ) );
        film.layout( filmDto.getLayout() );
        film.title( filmDto.getTitle() );
        film.date( filmDto.getDate() );
        film.startTime( filmDto.getStartTime() );
        film.endTime( filmDto.getEndTime() );
        film.participants( filmDto.getParticipants() );

        return film.build();
    }

    protected LayoutCapacityDto layoutCapacityToLayoutCapacityDto(LayoutCapacity layoutCapacity) {
        if ( layoutCapacity == null ) {
            return null;
        }

        LayoutCapacityDtoBuilder layoutCapacityDto = LayoutCapacityDto.builder();

        layoutCapacityDto.id( layoutCapacity.getId() );
        layoutCapacityDto.lastUpdate( layoutCapacity.getLastUpdate() );
        layoutCapacityDto.layout( layoutCapacity.getLayout() );
        layoutCapacityDto.capacity( layoutCapacity.getCapacity() );

        return layoutCapacityDto.build();
    }

    protected List<LayoutCapacityDto> layoutCapacityListToLayoutCapacityDtoList(List<LayoutCapacity> list) {
        if ( list == null ) {
            return null;
        }

        List<LayoutCapacityDto> list1 = new ArrayList<LayoutCapacityDto>( list.size() );
        for ( LayoutCapacity layoutCapacity : list ) {
            list1.add( layoutCapacityToLayoutCapacityDto( layoutCapacity ) );
        }

        return list1;
    }

    protected CityDto cityToCityDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDtoBuilder cityDto = CityDto.builder();

        cityDto.id( city.getId() );
        cityDto.lastUpdate( city.getLastUpdate() );
        cityDto.cityName( city.getCityName() );

        return cityDto.build();
    }

    protected CinemaHallDto cinemaHallToCinemaHallDto(CinemaHall cinemaHall) {
        if ( cinemaHall == null ) {
            return null;
        }

        CinemaHallDtoBuilder cinemaHallDto = CinemaHallDto.builder();

        cinemaHallDto.id( cinemaHall.getId() );
        cinemaHallDto.lastUpdate( cinemaHall.getLastUpdate() );
        cinemaHallDto.name( cinemaHall.getName() );
        cinemaHallDto.location( cinemaHall.getLocation() );
        cinemaHallDto.capacities( layoutCapacityListToLayoutCapacityDtoList( cinemaHall.getCapacities() ) );
        cinemaHallDto.city( cityToCityDto( cinemaHall.getCity() ) );

        return cinemaHallDto.build();
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.lastUpdate( user.getLastUpdate() );
        userDto.name( user.getName() );
        userDto.password( user.getPassword() );
        userDto.email( user.getEmail() );
        byte[] picByte = user.getPicByte();
        if ( picByte != null ) {
            userDto.picByte( Arrays.copyOf( picByte, picByte.length ) );
        }
        userDto.amountAvailable( user.getAmountAvailable() );
        userDto.amountReserved( user.getAmountReserved() );

        return userDto.build();
    }

    protected LayoutCapacity layoutCapacityDtoToLayoutCapacity(LayoutCapacityDto layoutCapacityDto) {
        if ( layoutCapacityDto == null ) {
            return null;
        }

        LayoutCapacityBuilder layoutCapacity = LayoutCapacity.builder();

        layoutCapacity.id( layoutCapacityDto.getId() );
        layoutCapacity.lastUpdate( layoutCapacityDto.getLastUpdate() );
        layoutCapacity.layout( layoutCapacityDto.getLayout() );
        layoutCapacity.capacity( layoutCapacityDto.getCapacity() );

        return layoutCapacity.build();
    }

    protected List<LayoutCapacity> layoutCapacityDtoListToLayoutCapacityList(List<LayoutCapacityDto> list) {
        if ( list == null ) {
            return null;
        }

        List<LayoutCapacity> list1 = new ArrayList<LayoutCapacity>( list.size() );
        for ( LayoutCapacityDto layoutCapacityDto : list ) {
            list1.add( layoutCapacityDtoToLayoutCapacity( layoutCapacityDto ) );
        }

        return list1;
    }

    protected City cityDtoToCity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        CityBuilder city = City.builder();

        city.id( cityDto.getId() );
        city.lastUpdate( cityDto.getLastUpdate() );
        city.cityName( cityDto.getCityName() );

        return city.build();
    }

    protected CinemaHall cinemaHallDtoToCinemaHall(CinemaHallDto cinemaHallDto) {
        if ( cinemaHallDto == null ) {
            return null;
        }

        CinemaHallBuilder cinemaHall = CinemaHall.builder();

        cinemaHall.id( cinemaHallDto.getId() );
        cinemaHall.lastUpdate( cinemaHallDto.getLastUpdate() );
        cinemaHall.name( cinemaHallDto.getName() );
        cinemaHall.location( cinemaHallDto.getLocation() );
        cinemaHall.capacities( layoutCapacityDtoListToLayoutCapacityList( cinemaHallDto.getCapacities() ) );
        cinemaHall.city( cityDtoToCity( cinemaHallDto.getCity() ) );

        return cinemaHall.build();
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.lastUpdate( userDto.getLastUpdate() );
        user.name( userDto.getName() );
        user.password( userDto.getPassword() );
        user.email( userDto.getEmail() );
        byte[] picByte = userDto.getPicByte();
        if ( picByte != null ) {
            user.picByte( Arrays.copyOf( picByte, picByte.length ) );
        }
        user.amountAvailable( userDto.getAmountAvailable() );
        user.amountReserved( userDto.getAmountReserved() );

        return user.build();
    }
}

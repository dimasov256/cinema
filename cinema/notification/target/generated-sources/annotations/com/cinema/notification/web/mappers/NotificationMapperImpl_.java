package com.cinema.notification.web.mappers;

import com.cinema.clients.notification.models.NotificationDto;
import com.cinema.clients.notification.models.NotificationDto.NotificationDtoBuilder;
import com.cinema.notification.domain.Notification;
import com.cinema.notification.domain.Notification.NotificationBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T15:09:23+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class NotificationMapperImpl_ implements NotificationMapper {

    @Override
    public NotificationDto notificationToNotificationDto(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDtoBuilder notificationDto = NotificationDto.builder();

        notificationDto.id( notification.getId() );
        notificationDto.lastUpdate( notification.getLastUpdate() );
        notificationDto.toUserId( notification.getToUserId() );
        notificationDto.toUserEmail( notification.getToUserEmail() );
        notificationDto.sender( notification.getSender() );
        notificationDto.message( notification.getMessage() );

        return notificationDto.build();
    }

    @Override
    public Notification notificationDtoToNotification(NotificationDto notificationDto) {
        if ( notificationDto == null ) {
            return null;
        }

        NotificationBuilder notification = Notification.builder();

        notification.id( notificationDto.getId() );
        notification.lastUpdate( notificationDto.getLastUpdate() );
        notification.toUserId( notificationDto.getToUserId() );
        notification.toUserEmail( notificationDto.getToUserEmail() );
        notification.sender( notificationDto.getSender() );
        notification.message( notificationDto.getMessage() );

        return notification.build();
    }
}

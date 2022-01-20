package dev.alexengrig.myservices.notification.mapper;

import dev.alexengrig.myservices.notification.entity.NotificationEntity;
import dev.alexengrig.myservices.notification.domain.Notification;
import dev.alexengrig.myservices.notification.payload.NotificationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    Notification requestToDomain(NotificationRequest request);

    NotificationEntity domainToEntity(Notification notification);

}

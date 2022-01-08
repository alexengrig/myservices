package dev.alexengrig.sample.notification.mapper;

import dev.alexengrig.sample.notification.domain.Notification;
import dev.alexengrig.sample.notification.entity.NotificationEntity;
import dev.alexengrig.sample.notification.payload.NotificationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    Notification requestToDomain(NotificationRequest request);

    NotificationEntity domainToEntity(Notification notification);

}

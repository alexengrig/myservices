package dev.alexengrig.myservices.notification.service;

import dev.alexengrig.myservices.notification.entity.NotificationEntity;
import dev.alexengrig.myservices.notification.repository.NotificationRepository;
import dev.alexengrig.myservices.notification.domain.Notification;
import dev.alexengrig.myservices.notification.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SimpleNotificationService implements NotificationService {

    @Value("${application.sender}")
    private final String sender;
    private final NotificationMapper mapper;
    private final NotificationRepository repository;

    @Override
    public void send(Notification notification) {
        NotificationEntity entity = mapper.domainToEntity(notification);
        entity.setSender(sender);
        entity.setSentAt(LocalDateTime.now());
        repository.save(entity);
    }

}

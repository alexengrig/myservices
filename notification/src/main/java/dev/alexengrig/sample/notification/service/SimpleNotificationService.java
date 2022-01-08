package dev.alexengrig.sample.notification.service;

import dev.alexengrig.sample.notification.domain.Notification;
import dev.alexengrig.sample.notification.entity.NotificationEntity;
import dev.alexengrig.sample.notification.mapper.NotificationMapper;
import dev.alexengrig.sample.notification.repository.NotificationRepository;
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

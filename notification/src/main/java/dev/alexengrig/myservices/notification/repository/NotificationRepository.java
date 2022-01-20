package dev.alexengrig.myservices.notification.repository;

import dev.alexengrig.myservices.notification.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}

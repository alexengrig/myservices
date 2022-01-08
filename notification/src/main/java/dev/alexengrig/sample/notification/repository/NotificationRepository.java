package dev.alexengrig.sample.notification.repository;

import dev.alexengrig.sample.notification.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}

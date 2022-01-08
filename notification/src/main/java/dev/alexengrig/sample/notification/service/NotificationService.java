package dev.alexengrig.sample.notification.service;

import dev.alexengrig.sample.notification.domain.Notification;

public interface NotificationService {

    void send(Notification notification);

}

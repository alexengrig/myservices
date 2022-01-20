package dev.alexengrig.myservices.notification.service;

import dev.alexengrig.myservices.notification.domain.Notification;

public interface NotificationService {

    void send(Notification notification);

}

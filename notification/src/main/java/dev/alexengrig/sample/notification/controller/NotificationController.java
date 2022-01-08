package dev.alexengrig.sample.notification.controller;

import dev.alexengrig.sample.notification.domain.Notification;
import dev.alexengrig.sample.notification.mapper.NotificationMapper;
import dev.alexengrig.sample.notification.payload.NotificationRequest;
import dev.alexengrig.sample.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationMapper mapper;
    private final NotificationService service;

    @PostMapping
    public void send(@RequestBody NotificationRequest request) {
        log.info("New notification: {}", request);
        Notification notification = mapper.requestToDomain(request);
        service.send(notification);
    }

}

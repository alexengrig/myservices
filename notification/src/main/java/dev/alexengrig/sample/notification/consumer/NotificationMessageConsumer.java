package dev.alexengrig.sample.notification.consumer;

import dev.alexengrig.sample.notification.domain.Notification;
import dev.alexengrig.sample.notification.mapper.NotificationMapper;
import dev.alexengrig.sample.notification.payload.NotificationRequest;
import dev.alexengrig.sample.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationMessageConsumer {

    private final NotificationMapper mapper;
    private final NotificationService service;

    @RabbitListener(queues = "${application.rabbitmq.queues.notification}")
    public void consume(NotificationRequest request) {
        log.info("Consumed from queue: {}", request);
        Notification notification = mapper.requestToDomain(request);
        service.send(notification);
    }

}

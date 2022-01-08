package dev.alexengrig.sample.notification.client;

import dev.alexengrig.sample.notification.payload.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("/api/v1/notification")
    void send(@RequestBody NotificationRequest request);

}

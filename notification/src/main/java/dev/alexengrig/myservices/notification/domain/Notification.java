package dev.alexengrig.myservices.notification.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {

    private Long customerId;
    private String email;
    private String message;

}

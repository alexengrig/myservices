package dev.alexengrig.myservices.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificatioin")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity {

    @Id
    @SequenceGenerator(name = "notification_id_seq")
    @GeneratedValue(generator = "notification_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long customerId;
    private String email;
    private String message;

    private String sender;
    private LocalDateTime sentAt;

}

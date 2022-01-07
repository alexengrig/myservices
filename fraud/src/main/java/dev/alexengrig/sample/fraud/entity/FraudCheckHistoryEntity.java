package dev.alexengrig.sample.fraud.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_check_history")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckHistoryEntity {

    @Id
    @SequenceGenerator(name = "fraud_check_history_id_seq")
    @GeneratedValue(generator = "fraud_check_history_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}

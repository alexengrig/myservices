package dev.alexengrig.myservices.fraud.entity;

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

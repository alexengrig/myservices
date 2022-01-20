package dev.alexengrig.myservices.fraud.repository;

import dev.alexengrig.myservices.fraud.entity.FraudCheckHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, Long> {
}

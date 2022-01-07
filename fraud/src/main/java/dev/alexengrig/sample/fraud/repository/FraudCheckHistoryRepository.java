package dev.alexengrig.sample.fraud.repository;

import dev.alexengrig.sample.fraud.entity.FraudCheckHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, Long> {
}

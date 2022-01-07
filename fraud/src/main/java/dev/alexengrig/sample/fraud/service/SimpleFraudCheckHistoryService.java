package dev.alexengrig.sample.fraud.service;

import dev.alexengrig.sample.fraud.entity.FraudCheckHistoryEntity;
import dev.alexengrig.sample.fraud.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SimpleFraudCheckHistoryService implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepository repository;

    @Override
    public boolean isFraudulentCustomer(Long customerId) {
        FraudCheckHistoryEntity entity = FraudCheckHistoryEntity.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(entity);
        return false;
    }

}

package dev.alexengrig.sample.fraud.service;

public interface FraudCheckHistoryService {

    boolean isFraudulentCustomer(Long customerId);

}

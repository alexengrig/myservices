package dev.alexengrig.myservices.fraud.service;

public interface FraudCheckHistoryService {

    boolean isFraudulentCustomer(Long customerId);

}

package dev.alexengrig.myservices.customer.service;

import dev.alexengrig.myservices.customer.entity.CustomerEntity;
import dev.alexengrig.myservices.customer.repository.CustomerRepository;
import dev.alexengrig.myservices.amqp.producer.AmqpMessageProducer;
import dev.alexengrig.myservices.customer.domain.Customer;
import dev.alexengrig.myservices.customer.mapper.CustomerMapper;
import dev.alexengrig.myservices.fraud.client.FraudClient;
import dev.alexengrig.myservices.fraud.payload.FraudCheckResponse;
import dev.alexengrig.myservices.notification.payload.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleCustomerService implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final FraudClient fraudClient;
    private final AmqpMessageProducer amqpMessageProducer;

    @Override
    public void create(Customer customer) {
        CustomerEntity entity = mapper.domainToEntity(customer);
        repository.saveAndFlush(entity);
        FraudCheckResponse checkResponse = fraudClient.check(entity.getId());
        if (checkResponse.isFraudster()) {
            throw new IllegalArgumentException("fraudster");
        }
        NotificationRequest notification = NotificationRequest.builder()
                .customerId(entity.getId())
                .email(entity.getEmail())
                .message("Hi " + entity.getFirstName())
                .build();
        amqpMessageProducer.publish(
                "internal.exchange",
                "internal.notification.routing-key",
                notification);
    }

}

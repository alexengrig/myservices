package dev.alexengrig.myservices.customer.repository;

import dev.alexengrig.myservices.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}

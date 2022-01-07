package dev.alexengrig.sample.customer.repository;

import dev.alexengrig.sample.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}

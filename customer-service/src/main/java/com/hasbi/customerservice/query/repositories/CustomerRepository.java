package com.hasbi.customerservice.query.repositories;

import com.hasbi.customerservice.query.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}

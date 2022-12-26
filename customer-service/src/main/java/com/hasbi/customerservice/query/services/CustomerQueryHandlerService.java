package com.hasbi.customerservice.query.services;

import com.hasbi.customerservice.query.entities.Customer;
import com.hasbi.customerservice.query.repositories.CustomerRepository;
import com.hasbi.exceptions.CustomerNotFoundException;
import com.hasbi.queries.customerQueries.GetAllCustomersQuery;
import com.hasbi.queries.customerQueries.GetCustomerByIdQuery;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerQueryHandlerService {
    private CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> handle(GetAllCustomersQuery query){
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer handle(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId()).orElseThrow(()-> new CustomerNotFoundException("Customer not found"));
    }
}

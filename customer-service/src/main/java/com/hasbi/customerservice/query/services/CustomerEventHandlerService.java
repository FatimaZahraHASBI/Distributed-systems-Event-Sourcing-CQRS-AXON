package com.hasbi.customerservice.query.services;

import com.hasbi.customerservice.query.entities.Customer;
import com.hasbi.customerservice.query.repositories.CustomerRepository;
import com.hasbi.events.customerEvents.CreateCustomerEvent;
import com.hasbi.events.customerEvents.DeleteCustomerEvent;
import com.hasbi.events.customerEvents.UpdateCustomerEvent;
import com.hasbi.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerEventHandlerService {
    private CustomerRepository customerRepository;

    @EventHandler
    public void on(CreateCustomerEvent event){
        Customer owner = Customer.builder()
                .customerId(event.getId())
                .nom(event.getNom())
                .adresse(event.getAdresse())
                .email(event.getEmail())
                .phone(event.getPhone())
                .build();
        customerRepository.save(owner);
    }

    @EventHandler
    public void on(UpdateCustomerEvent event){
        Customer customer = customerRepository.findById(event.getId()).orElseThrow(()-> new CustomerNotFoundException("Customer not found"));
        customer.setCustomerId(event.getId());
        customer.setNom(event.getNom());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }


    @EventHandler
    public void on(DeleteCustomerEvent event){

        Customer customer = customerRepository.findById(event.getId()).orElseThrow(()-> new CustomerNotFoundException("Customer not found"));

        customerRepository.delete(customer);
    }
}

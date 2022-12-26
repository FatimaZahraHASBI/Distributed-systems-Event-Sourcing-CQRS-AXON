package com.hasbi.customerservice.query.controlles;

import com.hasbi.customerservice.query.entities.Customer;
import com.hasbi.queries.customerQueries.GetAllCustomersQuery;
import com.hasbi.queries.customerQueries.GetCustomerByIdQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/query/customers")
public class CustomerQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        List<Customer> customers = queryGateway.query(new GetAllCustomersQuery(), ResponseTypes.multipleInstancesOf(Customer.class)).join();
        return  customers;
    }

    @GetMapping("/{id}")
    public Customer getOwnerById(@PathVariable String id){
        Customer customer = queryGateway.query(new GetCustomerByIdQuery(id), ResponseTypes.instanceOf(Customer.class)).join();
        return  customer;
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
        return responseEntity;
    }
}

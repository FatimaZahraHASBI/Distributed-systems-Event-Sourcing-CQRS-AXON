package com.hasbi.customerservice.command.controllers;

import com.hasbi.commands.customerCommands.CreateCustomerCommand;
import com.hasbi.commands.customerCommands.DeleteCustomerCommand;
import com.hasbi.commands.customerCommands.UpdateCustomerCommand;
import com.hasbi.dtos.customerDTO.CreateCustomerRequestDTO;
import com.hasbi.dtos.customerDTO.UpdateCustomerRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("commands/customers")
public class CustomerCommandController {
    @Autowired
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO){
        log.info(createCustomerRequestDTO.toString());
        CompletableFuture<String> response = commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                createCustomerRequestDTO.getNom(),
                createCustomerRequestDTO.getAdresse(),
                createCustomerRequestDTO.getEmail(),
                createCustomerRequestDTO.getPhone()
        ));
        return  response;
    }

    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateCustomer(@RequestBody UpdateCustomerRequestDTO updateCustomerRequestDTO, @PathVariable String id){
        log.error(id);
        log.error(updateCustomerRequestDTO.toString());
        CompletableFuture<String> response = commandGateway.send(new UpdateCustomerCommand(
                id,
                updateCustomerRequestDTO.getNom(),
                updateCustomerRequestDTO.getAdresse(),
                updateCustomerRequestDTO.getEmail(),
                updateCustomerRequestDTO.getPhone()
        ));
        return  response;
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteCustomer(@PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new DeleteCustomerCommand(id));
        return  response;
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );

        return responseEntity;
    }

    @GetMapping("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }

}

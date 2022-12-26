package com.hasbi.inventoryservice.command.controllers;


import com.hasbi.commands.inventoryCommands.CreateProductCommand;
import com.hasbi.commands.inventoryCommands.DeleteProductCommand;
import com.hasbi.commands.inventoryCommands.UpdateProductCommand;
import com.hasbi.dtos.inventoryDTO.CreateProductRequestDTO;
import com.hasbi.dtos.inventoryDTO.UpdateProductRequestDTO;
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
@RequestMapping("commands/products")
public class InventoryCommandController {
    @Autowired
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        log.info(createProductRequestDTO.toString());
        CompletableFuture<String> response = commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                createProductRequestDTO.getNom(),
                createProductRequestDTO.getPrix(),
                createProductRequestDTO.getQuantite(),
                createProductRequestDTO.getEtat(),
                createProductRequestDTO.getIdCategorie()
        ));
        return  response;
    }

    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateProduct(@RequestBody UpdateProductRequestDTO updateProductRequestDTO, @PathVariable String id){
        log.error(id);
        log.error(updateProductRequestDTO.toString());
        CompletableFuture<String> response = commandGateway.send(new UpdateProductCommand(
                id,
                updateProductRequestDTO.getNom(),
                updateProductRequestDTO.getPrix(),
                updateProductRequestDTO.getQuantite(),
                updateProductRequestDTO.getEtat(),
                updateProductRequestDTO.getIdCategorie()
        ));
        return  response;
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteProduct(@PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new DeleteProductCommand(id));
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

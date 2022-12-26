package com.hasbi.inventoryservice.command.controllers;


import com.hasbi.commands.categorieCommands.CreateCategorieCommand;
import com.hasbi.commands.categorieCommands.DeleteCategorieCommand;
import com.hasbi.commands.categorieCommands.UpdateCategorieCommand;
import com.hasbi.dtos.categorieDTO.CreateCategorieRequestDTO;
import com.hasbi.dtos.categorieDTO.UpdateCategorieRequestDTO;
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
@RequestMapping("commands/categories")
public class CategorieCommandController {
    @Autowired
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCategorie(@RequestBody CreateCategorieRequestDTO createCategorieRequestDTO){
        log.info(createCategorieRequestDTO.toString());
        CompletableFuture<String> response = commandGateway.send(new CreateCategorieCommand(
                UUID.randomUUID().toString(),
                createCategorieRequestDTO.getNom(),
                createCategorieRequestDTO.getDesciption()
        ));
        return  response;
    }

    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateCategorie(@RequestBody UpdateCategorieRequestDTO updateCategorieRequestDTO, @PathVariable String id){
        log.error(id);
        log.error(updateCategorieRequestDTO.toString());
        CompletableFuture<String> response = commandGateway.send(new UpdateCategorieCommand(
                id,
                updateCategorieRequestDTO.getNom(),
                updateCategorieRequestDTO.getDesciption()
        ));
        return  response;
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteCategorie(@PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new DeleteCategorieCommand(id));
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

package com.hasbi.inventoryservice.command.aggregates;

import com.hasbi.commands.inventoryCommands.CreateProductCommand;
import com.hasbi.commands.inventoryCommands.DeleteProductCommand;
import com.hasbi.commands.inventoryCommands.UpdateProductCommand;
import com.hasbi.enums.ProductState;
import com.hasbi.events.customerEvents.DeleteCustomerEvent;
import com.hasbi.events.inventoryEvents.CreateProductEvent;
import com.hasbi.events.inventoryEvents.DeleteProductEvent;
import com.hasbi.events.inventoryEvents.UpdateProductEvent;
import com.hasbi.exceptions.InvalidObjectId;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class InventoryAggregate {
    @Getter
    @AggregateIdentifier
    private String productId;
    @Getter private String nom;
    @Getter private double prix;
    @Getter private int quantite;
    @Getter private ProductState etat;
    @Getter private String idCategorie;

    public InventoryAggregate() {
    }

    // Create product
    @CommandHandler
    public InventoryAggregate(CreateProductCommand command) {
        if(command.getCommandId() == null || command.getCommandId().isBlank()) throw new InvalidObjectId("Id can not be null.");
        AggregateLifecycle.apply(new CreateProductEvent(
                command.getCommandId(),
                command.getNom(),
                command.getPrix(),
                command.getQuantite(),
                command.getEtat(),
                command.getIdCategorie()
        ));
    }

    @EventSourcingHandler
    public void on(CreateProductEvent event){
        this.productId = event.getId();
        this.nom = event.getNom();
        this.prix = event.getPrix();
        this.quantite = event.getQuantite();
        this.etat = event.getEtat();
        this.idCategorie = event.getIdCategorie();
    }

    // Update product
    @CommandHandler
    public void handle(UpdateProductCommand command){
        log.error(command.getCommandId());
        if(command.getCommandId() == null || command.getCommandId().isBlank()) throw new InvalidObjectId("Id can not be null.");
        // validations
        AggregateLifecycle.apply(new UpdateProductEvent(
                command.getCommandId(),
                command.getNom(),
                command.getPrix(),
                command.getQuantite(),
                command.getEtat(),
                command.getIdCategorie()
        ));
    }

    @EventSourcingHandler
    public void on(UpdateProductEvent event){
        this.nom = event.getNom();
        this.prix = event.getPrix();
        this.quantite = event.getQuantite();
        this.etat = event.getEtat();
        this.idCategorie = event.getIdCategorie();
    }

    // Delete product
    @CommandHandler
    public void handle(DeleteProductCommand command){
        // validations
        AggregateLifecycle.apply(new DeleteCustomerEvent(
                command.getCommandId()
        ));
    }

    @EventSourcingHandler
    public void on(DeleteProductEvent event){
        log.warn("Deleting Product: "+ event.getId());
    }

}

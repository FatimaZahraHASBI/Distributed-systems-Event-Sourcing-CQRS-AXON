package com.hasbi.inventoryservice.command.aggregates;

import com.hasbi.commands.categorieCommands.CreateCategorieCommand;
import com.hasbi.commands.categorieCommands.DeleteCategorieCommand;
import com.hasbi.commands.categorieCommands.UpdateCategorieCommand;
import com.hasbi.commands.inventoryCommands.CreateProductCommand;
import com.hasbi.commands.inventoryCommands.DeleteProductCommand;
import com.hasbi.commands.inventoryCommands.UpdateProductCommand;
import com.hasbi.enums.ProductState;
import com.hasbi.events.categorieEvents.CreateCategorieEvent;
import com.hasbi.events.categorieEvents.DeleteCategorieEvent;
import com.hasbi.events.categorieEvents.UpdateCategorieEvent;
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
public class CategorieAggregate {
    @Getter
    @AggregateIdentifier
    private String categorieId;
    @Getter private String nom;
    @Getter private String description;

    public CategorieAggregate() {
    }

    // Create Categorie
    @CommandHandler
    public CategorieAggregate(CreateCategorieCommand command) {
        if(command.getCommandId() == null || command.getCommandId().isBlank()) throw new InvalidObjectId("Id can not be null.");
        AggregateLifecycle.apply(new CreateCategorieEvent(
                command.getCommandId(),
                command.getNom(),
                command.getDesciption()
        ));
    }

    @EventSourcingHandler
    public void on(CreateCategorieEvent event){
        this.categorieId = event.getId();
        this.nom = event.getNom();
        this.description = event.getDesciption();
    }

    // Update Categorie
    @CommandHandler
    public void handle(UpdateCategorieCommand command){
        log.error(command.getCommandId());
        if(command.getCommandId() == null || command.getCommandId().isBlank()) throw new InvalidObjectId("Id can not be null.");
        // validations
        AggregateLifecycle.apply(new UpdateCategorieEvent(
                command.getCommandId(),
                command.getNom(),
                command.getDesciption()
        ));
    }

    @EventSourcingHandler
    public void on(UpdateCategorieEvent event){
        this.nom = event.getNom();
        this.description = event.getDesciption();
    }

    // Delete Categorie
    @CommandHandler
    public void handle(DeleteCategorieCommand command){
        AggregateLifecycle.apply(new DeleteCategorieEvent(
                command.getCommandId()
        ));
    }

    @EventSourcingHandler
    public void on(DeleteCategorieEvent event){
        log.warn("Deleting Categorie: "+ event.getId());
    }

}

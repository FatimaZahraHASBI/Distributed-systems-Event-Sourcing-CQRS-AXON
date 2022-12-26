package com.hasbi.customerservice.command.aggregates;

import com.hasbi.commands.customerCommands.CreateCustomerCommand;
import com.hasbi.commands.customerCommands.DeleteCustomerCommand;
import com.hasbi.commands.customerCommands.UpdateCustomerCommand;
import com.hasbi.events.customerEvents.CreateCustomerEvent;
import com.hasbi.events.customerEvents.DeleteCustomerEvent;
import com.hasbi.events.customerEvents.UpdateCustomerEvent;
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
public class CustomerAggregate {
    @Getter
    @AggregateIdentifier
    private String customerId;
    @Getter private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private String phone;

    public CustomerAggregate() {
    }

    // Create customer
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        if(command.getCommandId() == null || command.getCommandId().isBlank()) throw new InvalidObjectId("Id can not be null.");
        AggregateLifecycle.apply(new CreateCustomerEvent(
                command.getCommandId(),
                command.getNom(),
                command.getAdresse(),
                command.getEmail(),
                command.getPhone()
        ));
    }

    @EventSourcingHandler
    public void on(CreateCustomerEvent event){
        this.customerId = event.getId();
        this.nom = event.getNom();
        this.adresse = event.getAdresse();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }

    // Update customer
    @CommandHandler
    public void handle(UpdateCustomerCommand command){
        log.error(command.getCommandId());
        if(command.getCommandId() == null || command.getCommandId().isBlank()) throw new InvalidObjectId("Id can not be null.");
        // validations
        AggregateLifecycle.apply(new UpdateCustomerEvent(
                command.getCommandId(),
                command.getNom(),
                command.getAdresse(),
                command.getEmail(),
                command.getPhone()
        ));
    }

    @EventSourcingHandler
    public void on(UpdateCustomerEvent event){
        this.nom = event.getNom();
        this.adresse = event.getAdresse();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }

    // Delete customer
    @CommandHandler
    public void handle(DeleteCustomerCommand command){
        // validations
        AggregateLifecycle.apply(new DeleteCustomerEvent(
                command.getCommandId()
        ));
    }

    @EventSourcingHandler
    public void on(DeleteCustomerEvent event){
        log.warn("Deleting Customer: "+ event.getId());
    }

}

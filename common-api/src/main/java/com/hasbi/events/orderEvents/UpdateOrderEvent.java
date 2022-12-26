package com.hasbi.events.orderEvents;

import com.hasbi.enums.CommandStatus;
import com.hasbi.events.BaseEvent;
import lombok.Getter;

import java.util.Date;

public class UpdateOrderEvent extends BaseEvent<String> {
    @Getter private Date dateCommande;
    @Getter private Date dateLivraison;
    @Getter private String adresseLivraison;
    @Getter private CommandStatus status;
    @Getter private String customerId;

    public UpdateOrderEvent(String commandId, Date dateCommande, Date dateLivraison, String adresseLivraison, CommandStatus status, String customerId) {
        super(commandId);
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.adresseLivraison = adresseLivraison;
        this.status = status;
        this.customerId = customerId;
    }
}

package com.hasbi.commands.orderCommands;

import com.hasbi.commands.BaseCommand;
import com.hasbi.enums.CommandStatus;
import lombok.Getter;

import java.util.Date;

public class UpdateOrderCommand extends BaseCommand<String> {
    @Getter private Date dateCommande;
    @Getter private Date dateLivraison;
    @Getter private String adresseLivraison;
    @Getter private CommandStatus status;
    @Getter private String customerId;

    public UpdateOrderCommand(String commandId, Date dateCommande, Date dateLivraison, String adresseLivraison, CommandStatus status, String customerId) {
        super(commandId);
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.adresseLivraison = adresseLivraison;
        this.status = status;
        this.customerId = customerId;
    }
}

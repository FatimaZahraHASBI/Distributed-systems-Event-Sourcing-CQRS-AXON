package com.hasbi.commands.customerCommands;

import com.hasbi.commands.BaseCommand;
import lombok.Getter;

public class CreateCustomerCommand extends BaseCommand<String> {
    @Getter private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private String phone;

    public CreateCustomerCommand(String commandId, String nom, String adresse, String email, String phone) {
        super(commandId);
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
    }
}

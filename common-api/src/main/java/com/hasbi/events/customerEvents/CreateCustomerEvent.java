package com.hasbi.events.customerEvents;

import com.hasbi.events.BaseEvent;
import lombok.Getter;

public class CreateCustomerEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private String phone;

    public CreateCustomerEvent(String commandId, String nom, String adresse, String email, String phone) {
        super(commandId);
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
    }
}

package com.hasbi.events.categorieEvents;

import com.hasbi.events.BaseEvent;
import lombok.Getter;

public class CreateCategorieEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private String desciption;

    public CreateCategorieEvent(String commandId, String nom, String desciption) {
        super(commandId);
        this.nom = nom;
        this.desciption = desciption;
    }
}

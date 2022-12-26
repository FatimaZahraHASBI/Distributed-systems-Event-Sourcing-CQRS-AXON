package com.hasbi.events.categorieEvents;

import com.hasbi.events.BaseEvent;
import lombok.Getter;

public class UpdateCategorieEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private String desciption;

    public UpdateCategorieEvent(String commandId, String nom, String desciption) {
        super(commandId);
        this.nom = nom;
        this.desciption = desciption;
    }
}

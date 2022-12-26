package com.hasbi.commands.categorieCommands;

import com.hasbi.commands.BaseCommand;
import lombok.Getter;

public class UpdateCategorieCommand extends BaseCommand<String> {
    @Getter private String nom;
    @Getter private String desciption;

    public UpdateCategorieCommand(String commandId, String nom, String desciption) {
        super(commandId);
        this.nom = nom;
        this.desciption = desciption;
    }
}

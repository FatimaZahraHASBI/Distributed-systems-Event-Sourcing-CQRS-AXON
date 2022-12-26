package com.hasbi.commands.inventoryCommands;

import com.hasbi.commands.BaseCommand;
import com.hasbi.enums.ProductState;
import lombok.Getter;

public class UpdateProductCommand extends BaseCommand<String> {
    @Getter private String nom;
    @Getter private double prix;
    @Getter private int quantite;
    @Getter private ProductState etat;
    @Getter private String idCategorie;

    public UpdateProductCommand(String commandId, String nom, double prix, int quantite, ProductState etat, String idCategorie) {
        super(commandId);
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.etat = etat;
        this.idCategorie = idCategorie;
    }
}

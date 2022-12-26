package com.hasbi.events.inventoryEvents;

import com.hasbi.enums.ProductState;
import com.hasbi.events.BaseEvent;
import lombok.Getter;

public class UpdateProductEvent extends BaseEvent<String> {
    @Getter private String nom;
    @Getter private double prix;
    @Getter private int quantite;
    @Getter private ProductState etat;
    @Getter private String idCategorie;

    public UpdateProductEvent(String commandId, String nom, double prix, int quantite, ProductState etat, String idCategorie) {
        super(commandId);
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.etat = etat;
        this.idCategorie = idCategorie;
    }
}

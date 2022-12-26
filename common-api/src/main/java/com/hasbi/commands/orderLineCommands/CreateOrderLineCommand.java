package com.hasbi.commands.orderLineCommands;

import com.hasbi.commands.BaseCommand;
import lombok.Getter;

public class CreateOrderLineCommand extends BaseCommand<String> {
    @Getter private int quantité;
    @Getter private double Prix_unitaire;
    @Getter private double remise;
    @Getter private String idOrder;
    @Getter private String idProduct;

    public CreateOrderLineCommand(String commandId, int quantité, double prix_unitaire, double remise, String idOrder, String idProduct) {
        super(commandId);
        this.quantité = quantité;
        Prix_unitaire = prix_unitaire;
        this.remise = remise;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
    }
}

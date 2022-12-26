package com.hasbi.events.orderLineEvents;

import com.hasbi.events.BaseEvent;
import lombok.Getter;

public class CreateOrderLineEvent extends BaseEvent<String> {
    @Getter private int quantité;
    @Getter private double Prix_unitaire;
    @Getter private double remise;
    @Getter private String idOrder;
    @Getter private String idProduct;

    public CreateOrderLineEvent(String commandId, int quantité, double prix_unitaire, double remise, String idOrder, String idProduct) {
        super(commandId);
        this.quantité = quantité;
        Prix_unitaire = prix_unitaire;
        this.remise = remise;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
    }
}

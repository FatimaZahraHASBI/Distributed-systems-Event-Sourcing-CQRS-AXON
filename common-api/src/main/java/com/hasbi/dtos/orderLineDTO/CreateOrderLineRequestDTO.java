package com.hasbi.dtos.orderLineDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderLineRequestDTO {
    private int quantité;
    private double Prix_unitaire;
    private double remise;
    private String idOrder;
    private String idProduct;
}

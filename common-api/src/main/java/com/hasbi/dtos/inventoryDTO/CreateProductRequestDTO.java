package com.hasbi.dtos.inventoryDTO;

import com.hasbi.enums.ProductState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDTO {
    private String nom;
    private double prix;
    private int quantite;
    private ProductState etat;
    private String idCategorie;
}

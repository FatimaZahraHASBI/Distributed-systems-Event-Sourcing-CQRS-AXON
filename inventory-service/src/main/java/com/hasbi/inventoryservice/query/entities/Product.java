package com.hasbi.inventoryservice.query.entities;

import com.hasbi.enums.ProductState;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Product {
    @Id
    private String productId;
    private String nom;
    private double prix;
    private int quantite;
    private ProductState etat;
    @ManyToOne
    private Categorie categorie;

}

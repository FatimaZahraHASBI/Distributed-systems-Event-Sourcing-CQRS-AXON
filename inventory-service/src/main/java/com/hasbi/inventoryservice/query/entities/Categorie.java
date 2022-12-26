package com.hasbi.inventoryservice.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Categorie {
    @Id
    private String categorieId;
    private String nom;
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Product> products;
}

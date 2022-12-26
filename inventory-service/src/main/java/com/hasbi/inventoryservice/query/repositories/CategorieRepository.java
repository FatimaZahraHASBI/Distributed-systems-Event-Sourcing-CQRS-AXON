package com.hasbi.inventoryservice.query.repositories;

import com.hasbi.inventoryservice.query.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, String> {
}

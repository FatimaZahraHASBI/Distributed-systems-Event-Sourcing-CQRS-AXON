package com.hasbi.inventoryservice.query.repositories;

import com.hasbi.inventoryservice.query.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

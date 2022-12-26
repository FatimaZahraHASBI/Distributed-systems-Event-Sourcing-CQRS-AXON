package com.hasbi.inventoryservice.query.services;

import com.hasbi.exceptions.ProductNotFoundException;
import com.hasbi.inventoryservice.query.entities.Product;
import com.hasbi.inventoryservice.query.repositories.ProductRepository;
import com.hasbi.queries.inventoryQueries.GetAllProductsQuery;
import com.hasbi.queries.inventoryQueries.GetProductByIdQuery;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryQueryHandlerService {
    private ProductRepository productRepository;

    @QueryHandler
    public List<Product> handle(GetAllProductsQuery query){
        return productRepository.findAll();
    }

    @QueryHandler
    public Product handle(GetProductByIdQuery query){
        return productRepository.findById(query.getId()).orElseThrow(()-> new ProductNotFoundException("Product not found"));
    }
}

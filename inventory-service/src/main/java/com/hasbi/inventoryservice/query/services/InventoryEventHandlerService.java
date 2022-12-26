package com.hasbi.inventoryservice.query.services;


import com.hasbi.events.inventoryEvents.CreateProductEvent;
import com.hasbi.events.inventoryEvents.DeleteProductEvent;
import com.hasbi.events.inventoryEvents.UpdateProductEvent;
import com.hasbi.exceptions.ProductNotFoundException;
import com.hasbi.inventoryservice.query.entities.Product;
import com.hasbi.inventoryservice.query.repositories.CategorieRepository;
import com.hasbi.inventoryservice.query.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryEventHandlerService {
    private ProductRepository productRepository;
    private CategorieRepository categorieRepository;

    @EventHandler
    public void on(CreateProductEvent event){
        Product product = Product.builder()
                .productId(event.getId())
                .nom(event.getNom())
                .prix(event.getPrix())
                .quantite(event.getQuantite())
                .etat(event.getEtat())
                .build();
        productRepository.save(product);
    }

    @EventHandler
    public void on(UpdateProductEvent event){
        Product product = productRepository.findById(event.getId()).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        product.setProductId(event.getId());
        product.setNom(event.getNom());
        product.setPrix(event.getPrix());
        product.setQuantite(event.getQuantite());
        productRepository.save(product);
    }


    @EventHandler
    public void on(DeleteProductEvent event){

        Product product = productRepository.findById(event.getId()).orElseThrow(()-> new ProductNotFoundException("Product not found"));

        productRepository.delete(product);
    }
}

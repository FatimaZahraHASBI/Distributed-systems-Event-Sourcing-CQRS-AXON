package com.hasbi.inventoryservice.query.services;


import com.hasbi.events.categorieEvents.CreateCategorieEvent;
import com.hasbi.events.categorieEvents.DeleteCategorieEvent;
import com.hasbi.events.categorieEvents.UpdateCategorieEvent;
import com.hasbi.exceptions.CategorieNotFoundException;
import com.hasbi.inventoryservice.query.entities.Categorie;
import com.hasbi.inventoryservice.query.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategorieEventHandlerService {
    private CategorieRepository categorieRepository;

    @EventHandler
    public void on(CreateCategorieEvent event){
        Categorie categorie = Categorie.builder()
                .categorieId(event.getId())
                .nom(event.getNom())
                .description(event.getDesciption())
                .build();
        categorieRepository.save(categorie);
    }

    @EventHandler
    public void on(UpdateCategorieEvent event){
        Categorie categorie = categorieRepository.findById(event.getId()).orElseThrow(()-> new CategorieNotFoundException("Categorie not found"));
        categorie.setCategorieId(event.getId());
        categorie.setNom(event.getNom());
        categorie.setDescription(event.getDesciption());
        categorieRepository.save(categorie);
    }


    @EventHandler
    public void on(DeleteCategorieEvent event){

        Categorie categorie = categorieRepository.findById(event.getId()).orElseThrow(()-> new CategorieNotFoundException("Categorie not found"));

        categorieRepository.delete(categorie);
    }
}

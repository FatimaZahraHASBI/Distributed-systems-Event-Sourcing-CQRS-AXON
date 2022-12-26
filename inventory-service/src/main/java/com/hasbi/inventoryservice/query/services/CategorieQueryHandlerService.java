package com.hasbi.inventoryservice.query.services;

import com.hasbi.exceptions.CategorieNotFoundException;
import com.hasbi.inventoryservice.query.entities.Categorie;
import com.hasbi.inventoryservice.query.repositories.CategorieRepository;
import com.hasbi.queries.categorieQueries.GetAllCategoriesQuery;
import com.hasbi.queries.categorieQueries.GetCategorieByIdQuery;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieQueryHandlerService {
    private CategorieRepository categorieRepository;

    @QueryHandler
    public List<Categorie> handle(GetAllCategoriesQuery query){
        return categorieRepository.findAll();
    }

    @QueryHandler
    public Categorie handle(GetCategorieByIdQuery query){
        return categorieRepository.findById(query.getId()).orElseThrow(()-> new CategorieNotFoundException("Categorie not found"));
    }
}

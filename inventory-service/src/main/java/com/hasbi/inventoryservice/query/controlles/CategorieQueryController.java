package com.hasbi.inventoryservice.query.controlles;

import com.hasbi.inventoryservice.query.entities.Categorie;
import com.hasbi.inventoryservice.query.entities.Product;
import com.hasbi.queries.categorieQueries.GetAllCategoriesQuery;
import com.hasbi.queries.categorieQueries.GetCategorieByIdQuery;
import com.hasbi.queries.inventoryQueries.GetProductsByCategorieIdQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/query/categories")
public class CategorieQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Categorie> getAllCategories(){
        List<Categorie> categories = queryGateway.query(new GetAllCategoriesQuery(), ResponseTypes.multipleInstancesOf(Categorie.class)).join();
        return  categories;
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable String id){
        Categorie categorie = queryGateway.query(new GetCategorieByIdQuery(id), ResponseTypes.instanceOf(Categorie.class)).join();
        return  categorie;
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategorieId(@PathVariable String id){
        List<Product> products = (List<Product>) queryGateway.query(new GetProductsByCategorieIdQuery(id), ResponseTypes.instanceOf(Product.class)).join();
        return products;
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
        return responseEntity;
    }
}

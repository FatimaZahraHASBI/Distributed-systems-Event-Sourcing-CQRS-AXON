package com.hasbi.inventoryservice.query.controlles;

import com.hasbi.inventoryservice.query.entities.Categorie;
import com.hasbi.inventoryservice.query.entities.Product;
import com.hasbi.queries.inventoryQueries.GetAllProductsQuery;
import com.hasbi.queries.inventoryQueries.GetCategorieByProductIdQuery;
import com.hasbi.queries.inventoryQueries.GetProductByIdQuery;
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
@RequestMapping("/query/products")
public class InventoryQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Product> getAllProducts(){
        List<Product> products = queryGateway.query(new GetAllProductsQuery(), ResponseTypes.multipleInstancesOf(Product.class)).join();
        return  products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        Product product = queryGateway.query(new GetProductByIdQuery(id), ResponseTypes.instanceOf(Product.class)).join();
        return  product;
    }

    @GetMapping("/{id}/categorie")
    public Categorie getCategorieByProductId(@PathVariable String id){
        Categorie categorie = queryGateway.query(new GetCategorieByProductIdQuery(id), ResponseTypes.instanceOf(Categorie.class)).join();
        return categorie;
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
        return responseEntity;
    }
}

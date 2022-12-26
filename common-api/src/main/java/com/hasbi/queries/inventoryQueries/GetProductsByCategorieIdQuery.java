package com.hasbi.queries.inventoryQueries;

import lombok.Getter;

public class GetProductsByCategorieIdQuery {
    @Getter
    private String id;

    public GetProductsByCategorieIdQuery(String id) {
        this.id = id;
    }
}

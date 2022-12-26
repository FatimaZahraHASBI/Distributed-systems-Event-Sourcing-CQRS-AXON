package com.hasbi.queries.inventoryQueries;

import lombok.Getter;

public class GetCategorieByProductIdQuery {
    @Getter
    private String id;

    public GetCategorieByProductIdQuery(String id) {
        this.id = id;
    }
}

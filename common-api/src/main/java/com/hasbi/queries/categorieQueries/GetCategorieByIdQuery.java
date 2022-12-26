package com.hasbi.queries.categorieQueries;

import lombok.Getter;

public class GetCategorieByIdQuery {
    @Getter
    private String id;

    public GetCategorieByIdQuery(String id) {
        this.id = id;
    }
}

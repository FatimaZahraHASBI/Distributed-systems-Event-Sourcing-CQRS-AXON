package com.hasbi.queries.orderLineQueries;

import lombok.Getter;

public class GetProductByOrderLineIdQuery {
    @Getter
    private String id;

    public GetProductByOrderLineIdQuery(String id) {
        this.id = id;
    }
}

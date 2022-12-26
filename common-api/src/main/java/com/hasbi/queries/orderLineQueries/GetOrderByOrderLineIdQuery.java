package com.hasbi.queries.orderLineQueries;

import lombok.Getter;

public class GetOrderByOrderLineIdQuery {
    @Getter
    private String id;

    public GetOrderByOrderLineIdQuery(String id) {
        this.id = id;
    }
}

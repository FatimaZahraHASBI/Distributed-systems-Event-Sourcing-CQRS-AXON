package com.hasbi.queries.orderLineQueries;

import lombok.Getter;

public class GetOrderLineByIdQuery {
    @Getter
    private String id;

    public GetOrderLineByIdQuery(String id) {
        this.id = id;
    }
}

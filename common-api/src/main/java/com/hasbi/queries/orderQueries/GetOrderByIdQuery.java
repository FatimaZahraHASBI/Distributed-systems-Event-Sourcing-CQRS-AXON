package com.hasbi.queries.orderQueries;

import lombok.Getter;

public class GetOrderByIdQuery {
    @Getter
    private String id;

    public GetOrderByIdQuery(String id) {
        this.id = id;
    }
}

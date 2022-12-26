package com.hasbi.queries.orderQueries;

import lombok.Getter;

public class GetCustomerByOrderIdQuery {
    @Getter
    private String id;

    public GetCustomerByOrderIdQuery(String id) {
        this.id = id;
    }
}

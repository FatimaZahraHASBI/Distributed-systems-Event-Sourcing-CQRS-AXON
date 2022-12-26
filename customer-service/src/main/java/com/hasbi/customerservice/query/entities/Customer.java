package com.hasbi.customerservice.query.entities;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Customer {
    @Id
    private String customerId;
    private String nom;
    private String adresse;
    private String email;
    private String phone;

}

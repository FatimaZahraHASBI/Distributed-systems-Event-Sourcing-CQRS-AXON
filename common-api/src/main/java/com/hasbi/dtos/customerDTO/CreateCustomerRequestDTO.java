package com.hasbi.dtos.customerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequestDTO {
    private String nom;
    private String adresse;
    private String email;
    private String phone;
}

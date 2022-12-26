package com.hasbi.dtos.categorieDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategorieRequestDTO {
    private String nom;
    private String desciption;
}

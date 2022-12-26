package com.hasbi.dtos.categorieDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategorieRequestDTO {
    private String nom;
    private String desciption;
}

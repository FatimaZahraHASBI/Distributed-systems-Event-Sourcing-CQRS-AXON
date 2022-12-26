package com.hasbi.dtos.orderDTO;

import com.hasbi.enums.CommandStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequestDTO {
    private Date dateCommande;
    private Date dateLivraison;
    private String adresseLivraison;
    private CommandStatus status;
    private String customerId;
}

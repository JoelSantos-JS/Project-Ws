package com.br.joel.Project.Ws.DTO.wsRaspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardDTO {


    private Long cvv;

    private String documentNumber;

    private Long installments;

    private Long month;

    private String number;

    private Long year;

}

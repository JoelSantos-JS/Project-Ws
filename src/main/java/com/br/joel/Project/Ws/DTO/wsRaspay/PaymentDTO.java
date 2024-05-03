package com.br.joel.Project.Ws.DTO.wsRaspay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {


    private CreditCardDTO creditCard;

    private String customerId;

    private String orderId;
}

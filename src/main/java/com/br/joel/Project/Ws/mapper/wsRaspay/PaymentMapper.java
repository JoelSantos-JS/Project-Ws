package com.br.joel.Project.Ws.mapper.wsRaspay;

import com.br.joel.Project.Ws.DTO.wsRaspay.CreditCardDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.PaymentDTO;

public class PaymentMapper {


    public static PaymentDTO build(String customerId, String orderID, CreditCardDTO dto) {



        return  PaymentDTO.builder()
                .orderId(orderID)
                .customerId(customerId)
                .creditCard(dto)
                .build();
    }
}

package com.br.joel.Project.Ws.mapper.wsRaspay;

import com.br.joel.Project.Ws.DTO.PaymentProcessDto;
import com.br.joel.Project.Ws.DTO.wsRaspay.OrderDTO;

public class OrderMapper {




    public  static OrderDTO build(String customerId , PaymentProcessDto info   ) {


        return OrderDTO.builder()
                .customerId(customerId)
                .discount(info.getDiscount())
                .productAcronym(info.getProductKey())
                .build();

        }
}

package com.br.joel.Project.Ws.mapper.wsRaspay;


import com.br.joel.Project.Ws.DTO.UserPaymentInfoDto;
import com.br.joel.Project.Ws.DTO.wsRaspay.CreditCardDTO;

public class CredidCardMapper {




    public  static CreditCardDTO build(UserPaymentInfoDto dto, String documentNunber) {


        return  CreditCardDTO.builder()
                .cvv(Long.parseLong(dto.getCardSecurityCode()))
                .month(dto.getCardExpirationMonth())
                .year(dto.getCardExpirationYear())
                .installments(dto.getInstallments())
                .number(dto.getCardNumber())
                .documentNumber(documentNunber)
                .build();
    }
}

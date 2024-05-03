package com.br.joel.Project.Ws.mapper;


import com.br.joel.Project.Ws.DTO.UserPaymentInfoDto;
import com.br.joel.Project.Ws.model.User;
import com.br.joel.Project.Ws.model.UserPaymentInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor

public class UserPaymentInfoMapper {




    public static UserPaymentInfo fromDtoToEntity(UserPaymentInfoDto dto, User user){
        return UserPaymentInfo.builder()
                .id(dto.getId())
                .cardNumber(dto.getCardNumber())
                .cardExpirationMonth(dto.getCardExpirationMonth())
                .cardExpirationYear(dto.getCardExpirationYear())
                .cardSecurityCode(Long.parseLong(dto.getCardSecurityCode()))
                .price(dto.getPrice())
                .dtPayment(dto.getDtPayment())
                .installments(dto.getInstallments())
                .userId(user)
                .build();

    }

}

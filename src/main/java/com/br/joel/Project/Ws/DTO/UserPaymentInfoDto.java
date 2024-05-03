package com.br.joel.Project.Ws.DTO;


import com.br.joel.Project.Ws.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPaymentInfoDto {



    private Long id;
    private String cardNumber;
    private Long cardExpirationMonth;
    private Long cardExpirationYear;
    private String cardSecurityCode;
    private BigDecimal price;

    private  Long installments;
    private Instant dtPayment = Instant.now();

    private Long userId;


}

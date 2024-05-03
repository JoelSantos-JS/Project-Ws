package com.br.joel.Project.Ws.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentProcessDto {


    private String productKey;

    private BigDecimal discount;
    @JsonProperty("userPaymentInfo")
    private UserPaymentInfoDto userPaymentDTO;



}

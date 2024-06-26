package com.br.joel.Project.Ws.DTO.wsRaspay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {


    private String id;

    private String customerId;


    private BigDecimal discount;


    private String productAcronym;
}

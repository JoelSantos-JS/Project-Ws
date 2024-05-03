package com.br.joel.Project.Ws.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubsCriptionTypeDto {



    private String name;
    private Integer access_months;

    private BigDecimal price;
    private String productKey;

}

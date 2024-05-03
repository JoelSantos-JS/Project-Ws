package com.br.joel.Project.Ws.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptions_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;

    @NotBlank(message = "Esse campo e obrigatorio")
    @Size(max = 120)
    private String name;
    @Column(name = "access_months")
    private Integer access_months;

    private BigDecimal price;
    @Column(name = "product_key")
    private String productKey;

}

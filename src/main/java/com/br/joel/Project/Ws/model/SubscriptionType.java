package com.br.joel.Project.Ws.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_type_id")
    private Long id;


    private String name;
    @Column(name = "access_months")
    private int accessMonths;

    private BigDecimal price;
    @Column(name = "product_key")
    private String productKey;

}

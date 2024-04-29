package com.br.joel.Project.Ws.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;


@Enabled
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_info_id")
    private Long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_expiration_month")
    private int cardExpirationMonth;
    @Column(name = "card_expiration_year")
    private int cardExpirationYear;
    @Column(name = "card_security_code")
    private int cardSecurityCode;

    private BigDecimal price;

    private  int instalments;
    @Column(name = "dt_payment")
    private Instant dtPayment;
    @Column(name = "user_id")
    private User userId;



}

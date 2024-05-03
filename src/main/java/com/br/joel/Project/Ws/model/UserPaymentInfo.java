package com.br.joel.Project.Ws.model;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_info_id")
    private Long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_expiration_month")
    private Long cardExpirationMonth;
    @Column(name = "card_expiration_year")
    private Long cardExpirationYear;
    @Column(name = "card_security_code")
    private Long cardSecurityCode;

    private BigDecimal price;

    private  Long installments;
    @Column(name = "dt_payment")
    private Instant dtPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;



}

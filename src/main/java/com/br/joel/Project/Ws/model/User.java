package com.br.joel.Project.Ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    private String name;

    private  String email;

    private String phone;

    private String cpf;

    private Instant dt_subscription = Instant.now();

    private Instant dt_expiration;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id")
    private  UserType userType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriptions_type_id")
    private SubscriptionType subscriptionType ;



}

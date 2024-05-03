package com.br.joel.Project.Ws.DTO;

import com.br.joel.Project.Ws.model.SubscriptionType;
import com.br.joel.Project.Ws.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private String name;

    private  String email;

    private String phone;

    private String cpf;

    private Instant dt_subscription = Instant.now();

    private Instant dt_expiration;


    private Long userTypeId;

    private Long subscriptionTypeId ;
}

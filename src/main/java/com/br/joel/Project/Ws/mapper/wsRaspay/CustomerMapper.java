package com.br.joel.Project.Ws.mapper.wsRaspay;


import com.br.joel.Project.Ws.DTO.wsRaspay.CustomerModelDTO;
import com.br.joel.Project.Ws.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


public class CustomerMapper {


   public static CustomerModelDTO build(User user) {
       var fullName = user.getName().split(" ");
       var firstName = fullName[0];
       var lastName = fullName.length > 1 ? fullName[fullName.length -1] : "";


       return CustomerModelDTO.builder()
               .cpf(user.getCpf())
               .email(user.getEmail())
               .firstName(firstName)
               .lastName(lastName)
               .build();
   }






}

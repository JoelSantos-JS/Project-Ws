package com.br.joel.Project.Ws.DTO.wsRaspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerModelDTO {


    private String id;
    private String firstName;
    private String lastName;

    private String email;

    private String cpf;

}

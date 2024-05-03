package com.br.joel.Project.Ws.mapper;

import com.br.joel.Project.Ws.DTO.UserDTO;
import com.br.joel.Project.Ws.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    private  final ObjectMapper mapper;

    public UserMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    public User toEntity(UserDTO  dto){
        return mapper.convertValue(dto, User.class);
    }

}

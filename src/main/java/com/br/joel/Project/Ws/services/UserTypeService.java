package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.model.UserType;
import com.br.joel.Project.Ws.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {


    private final UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }



    public List<UserType> listAllListType() {
        return userTypeRepository.findAll();
    }
}

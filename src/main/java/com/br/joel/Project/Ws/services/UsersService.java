package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.DTO.SubsCriptionTypeDto;
import com.br.joel.Project.Ws.DTO.UserDTO;
import com.br.joel.Project.Ws.model.SubscriptionType;
import com.br.joel.Project.Ws.model.User;
import com.br.joel.Project.Ws.model.UserType;
import com.br.joel.Project.Ws.repository.SubscriptionTypeRepository;
import com.br.joel.Project.Ws.repository.UserRepository;
import com.br.joel.Project.Ws.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {


    private final UserRepository userRepository;

    private  final UserTypeRepository userTypeRepository;

    private  final SubscriptionTypeRepository subscriptionType;
    public UsersService(UserRepository userRepository, UserTypeRepository userTypeRepository, SubscriptionTypeRepository subscriptionType) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.subscriptionType = subscriptionType;
    }



    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {

        return  userRepository.findById(id).orElseThrow();

    }


    public User save(UserDTO type) {
        User user = new User();

     UserType UserTypeId = userTypeRepository.findById(type.getUserTypeId()).orElseThrow();
     SubscriptionType subId=   subscriptionType.findById(type.getSubscriptionTypeId()).orElseThrow();

     copyUser(user, type);
     user.setUserType(UserTypeId);
     user.setSubscriptionType(subId);

        return  userRepository.save(user);
    }



    public  User update(Long id , UserDTO type) {
        User UserId = findById(id);

            if(UserId != null) {
                copyUser(UserId , type);
            return  userRepository.save(UserId);
        }


        return  null;

    }


    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    public void  copyUser(User user, UserDTO dto) {
       user.setCpf(dto.getCpf());
       user.setEmail(dto.getEmail());
       user.setName(dto.getName());
       user.setPhone(dto.getPhone());
       user.setDt_expiration(dto.getDt_expiration());
       user.setDt_subscription(dto.getDt_subscription());
       user.setUserType(user.getUserType());
       user.setSubscriptionType(user.getSubscriptionType());
    }
}

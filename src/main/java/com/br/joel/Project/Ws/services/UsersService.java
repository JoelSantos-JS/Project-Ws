package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.DTO.UserDTO;
import com.br.joel.Project.Ws.exceptions.NotFoundException;
import com.br.joel.Project.Ws.mapper.UserMapper;
import com.br.joel.Project.Ws.model.SubscriptionType;
import com.br.joel.Project.Ws.model.User;
import com.br.joel.Project.Ws.model.UserType;
import com.br.joel.Project.Ws.repository.SubscriptionTypeRepository;
import com.br.joel.Project.Ws.repository.UserRepository;
import com.br.joel.Project.Ws.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsersService {


    private final  static  Long aluno= 3L;

    private final UserRepository userRepository;

    private  final UserTypeRepository userTypeRepository;

    private final UserMapper mapper;

    private  final SubscriptionTypeRepository subscriptionType;
    public UsersService(UserRepository userRepository, UserTypeRepository userTypeRepository, UserMapper mapper, SubscriptionTypeRepository subscriptionType) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.mapper = mapper;
        this.subscriptionType = subscriptionType;
    }



    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {

        return  userRepository.findById(id).orElseThrow();

    }


    public User save(UserDTO dto) {
        User user = new User();

     UserType UserTypeId = userTypeRepository.findById(aluno).orElseThrow(()  -> new RuntimeException("UserType invalid"));
     SubscriptionType subId=   subscriptionType.findById(dto.getSubscriptionsTypeId()).get();


        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setCpf(dto.getCpf());
        user.setDt_subscription(dto.getDt_subscription());
        user.setDt_expiration(dto.getDt_expiration());
        user.setSubscriptionType(subId);
        user.setUserType(UserTypeId);


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

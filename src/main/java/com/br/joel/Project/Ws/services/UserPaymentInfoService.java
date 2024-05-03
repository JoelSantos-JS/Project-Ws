package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.model.UserPaymentInfo;
import com.br.joel.Project.Ws.repository.UserPaymentInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaymentInfoService {


    private  final UserPaymentInfoRepository userPaymentInfoRepository;

    public UserPaymentInfoService( UserPaymentInfoRepository userPaymentInfoRepository) {
        this.userPaymentInfoRepository = userPaymentInfoRepository;
    }


    public List<UserPaymentInfo> listAllPaymentInfo(){
        return  userPaymentInfoRepository.findAll();
    }

 }

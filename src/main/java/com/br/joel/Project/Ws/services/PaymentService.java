package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.DTO.PaymentProcessDto;
import com.br.joel.Project.Ws.DTO.wsRaspay.CustomerModelDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.OrderDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.PaymentDTO;
import com.br.joel.Project.Ws.exceptions.BusinessException;
import com.br.joel.Project.Ws.exceptions.NotFoundException;
import com.br.joel.Project.Ws.integration.Impl.MailIntregationImpl;
import com.br.joel.Project.Ws.integration.MailIntregation;
import com.br.joel.Project.Ws.integration.WsRaspayIntegration;
import com.br.joel.Project.Ws.mapper.UserPaymentInfoMapper;
import com.br.joel.Project.Ws.mapper.wsRaspay.CredidCardMapper;
import com.br.joel.Project.Ws.mapper.wsRaspay.CustomerMapper;
import com.br.joel.Project.Ws.mapper.wsRaspay.OrderMapper;
import com.br.joel.Project.Ws.mapper.wsRaspay.PaymentMapper;
import com.br.joel.Project.Ws.model.User;
import com.br.joel.Project.Ws.model.UserPaymentInfo;
import com.br.joel.Project.Ws.repository.UserPaymentInfoRepository;
import com.br.joel.Project.Ws.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class PaymentService {


    private final UserRepository userRepository;
    private  final UserPaymentInfoRepository userPaymentInfoRepository;
    private final WsRaspayIntegration wsRaspayIntegration;
    private  final MailIntregationImpl mailIntregation;

    public PaymentService(UserRepository userRepository, UserPaymentInfoRepository userPaymentInfoRepository, WsRaspayIntegration wsRaspayIntegration, MailIntregationImpl mailIntregation) {
        this.userRepository = userRepository;
        this.userPaymentInfoRepository = userPaymentInfoRepository;
        this.wsRaspayIntegration = wsRaspayIntegration;
        this.mailIntregation = mailIntregation;
    }

    public Boolean process(PaymentProcessDto dto) {
        var user = userRepository.findById(dto.getUserPaymentDTO().getUserId());

        if(user.isEmpty()) {
            throw  new NotFoundException("user not found");
        }

        User user1 = user.get();


        if(Objects.nonNull(user1.getSubscriptionType())) {
            throw  new BusinessException("Payment not processed because the user already have the inscription");
        }

        CustomerModelDTO customerModelDTO = wsRaspayIntegration.createCustomerModelDto(CustomerMapper.build(user1));
        OrderDTO orderDTO = wsRaspayIntegration.createOrder(OrderMapper.build(customerModelDTO.getId(), dto));
        PaymentDTO paymentDTO = PaymentMapper.build(customerModelDTO.getId(), orderDTO.getId(), CredidCardMapper.build(dto.getUserPaymentDTO(), user1.getCpf()));

        Boolean sucessPayment = wsRaspayIntegration.createPayment(paymentDTO);

        if(sucessPayment) {

            UserPaymentInfo userPaymentInfo =UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentDTO(), user1);
            userPaymentInfoRepository.save(userPaymentInfo);
            mailIntregation.send(user1.getEmail(), "Acesse Liberado");
            return  true;
        }


        return  false;
    }
}

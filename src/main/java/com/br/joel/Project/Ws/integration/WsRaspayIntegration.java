package com.br.joel.Project.Ws.integration;

import com.br.joel.Project.Ws.DTO.wsRaspay.CustomerModelDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.OrderDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.PaymentDTO;

public interface WsRaspayIntegration {



    CustomerModelDTO createCustomerModelDto(CustomerModelDTO dto);

    OrderDTO createOrder(OrderDTO orderDTO);



    Boolean createPayment(PaymentDTO paymentDTO);
}

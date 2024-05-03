package com.br.joel.Project.Ws.integration.Impl;

import com.br.joel.Project.Ws.DTO.wsRaspay.CreditCardDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.CustomerModelDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.OrderDTO;
import com.br.joel.Project.Ws.DTO.wsRaspay.PaymentDTO;
import com.br.joel.Project.Ws.integration.WsRaspayIntegration;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void  createCustomerWhenPassedData() {
        CustomerModelDTO customerModelDTO = new CustomerModelDTO(null, "JOle","Joese","joeltere8@gmail.com","01191269582");
        wsRaspayIntegration.createCustomerModelDto(customerModelDTO);

    }


    @Test
    void  createOrder() {
        OrderDTO orderDTO = new OrderDTO(null, "66352a92614655313365f1d1", BigDecimal.ZERO,"PROUTO11" );
        wsRaspayIntegration.createOrder(orderDTO);
    }


    @Test
    void createPayment() {
        CreditCardDTO credicard = new CreditCardDTO(123l, "2016315641", 19998L, 12l,"25",25L);


        PaymentDTO paymentDTO = new PaymentDTO(credicard, "66352a92614655313365f1d1", "66353a0e614655313365f1d2");

        wsRaspayIntegration.createPayment(paymentDTO);
    }

}
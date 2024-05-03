package com.br.joel.Project.Ws.controller;

import com.br.joel.Project.Ws.DTO.PaymentProcessDto;
import com.br.joel.Project.Ws.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentInfoController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/process-payment")
    public ResponseEntity<Boolean> payment(@RequestBody PaymentProcessDto dto) {

        return  ResponseEntity.status(HttpStatus.OK).body(paymentService.process(dto));
    }
}

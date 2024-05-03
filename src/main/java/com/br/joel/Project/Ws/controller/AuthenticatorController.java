package com.br.joel.Project.Ws.controller;

import com.br.joel.Project.Ws.DTO.LoginDTO;
import com.br.joel.Project.Ws.DTO.TokenDTO;
import com.br.joel.Project.Ws.services.TokenService;
import com.br.joel.Project.Ws.services.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticatorController {



    @Autowired
    private AuthenticationService authenticationManager;
    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody LoginDTO loginDTO) {

        return ResponseEntity.status(HttpStatus.OK).body(authenticationManager.auth(loginDTO));


    }

}

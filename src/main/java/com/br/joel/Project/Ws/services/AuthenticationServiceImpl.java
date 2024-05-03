package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.DTO.LoginDTO;
import com.br.joel.Project.Ws.DTO.TokenDTO;
import com.br.joel.Project.Ws.services.interfaces.AuthenticationService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Value("${webservices.jj.jwt.secret}")
    private String signWi;

    @Override
    public TokenDTO auth(LoginDTO dto) {
        UsernamePasswordAuthenticationToken userP = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        Authentication authentication = authenticationManager.authenticate(userP);

        String token = tokenService.getToken(authentication);
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);
        tokenDTO.setType("Bearer ");
        return tokenDTO;
    }


}

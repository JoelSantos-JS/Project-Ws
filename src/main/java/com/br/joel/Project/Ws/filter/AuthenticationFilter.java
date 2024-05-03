package com.br.joel.Project.Ws.filter;

import com.br.joel.Project.Ws.exceptions.NotFoundException;
import com.br.joel.Project.Ws.model.UserCredentials;
import com.br.joel.Project.Ws.repository.UserCredentialsRepository;
import com.br.joel.Project.Ws.services.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class AuthenticationFilter extends OncePerRequestFilter {


    private TokenService tokenService;
    private final UserCredentialsRepository userCredentialsRepository;

    public AuthenticationFilter(TokenService tokenService, UserCredentialsRepository userCredentialsRepository) {
        this.tokenService = tokenService;


        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenBearer(request);

        if(tokenService.isValid(token)) {
            authByToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authByToken(String token) {

        Long userId = tokenService.getUserID(token);
        var userOpt = userCredentialsRepository.findById(userId);

        if(userOpt.isEmpty()) {
            throw  new NotFoundException("User Not found");
        }

        UserCredentials userCredentials = userOpt.get();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userCredentials , null, userCredentials.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    private String getTokenBearer(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if(Objects.isNull(token) || !token.startsWith("Bearer")) {
            return   null;
        }


        return token.substring(7, token.length());

    }
}

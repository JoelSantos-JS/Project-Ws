package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.model.UserCredentials;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class TokenService{


    @Value("${webservices.jj.jwt.secret}")
    private String signWi;





    public String getToken(Authentication auth) {
        UserCredentials credentials = (UserCredentials) auth.getPrincipal();


        Date date = new Date();
        Date expiration = new Date(date.getTime() + 3600000);

        return Jwts.builder()
                .setIssuer("API PLUS")
                .setSubject(credentials.getId().toString())
                .setIssuedAt(date)
                .setExpiration(expiration)
                .signWith( SignatureAlgorithm.HS256, signWi)
                .compact();
    }

    public Boolean isValid(String token) {

        try {
            Jwts.parser().setSigningKey(signWi).parseClaimsJws(token);

            return  true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Long getUserID(String token) {
     Jws<Claims>  claimsJws = Jwts.parser().setSigningKey(signWi).parseClaimsJws(token);


     return Long.parseLong( claimsJws.getBody().getSubject());

    }
}

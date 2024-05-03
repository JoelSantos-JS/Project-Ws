package com.br.joel.Project.Ws.services;

import com.br.joel.Project.Ws.exceptions.NotFoundException;
import com.br.joel.Project.Ws.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsImpl implements UserDetailsService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       var user =  userCredentialsRepository.findByUsername(username);

       if(user.isPresent()) {
           return user.get();
       }

       throw  new NotFoundException("User not found");
    }
}

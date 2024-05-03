package com.br.joel.Project.Ws.services.interfaces;

import com.br.joel.Project.Ws.DTO.LoginDTO;
import com.br.joel.Project.Ws.DTO.TokenDTO;

public interface AuthenticationService {


    TokenDTO auth(LoginDTO dto);


}

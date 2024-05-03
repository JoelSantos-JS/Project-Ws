package com.br.joel.Project.Ws.repository;

import com.br.joel.Project.Ws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

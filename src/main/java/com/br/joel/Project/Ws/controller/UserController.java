package com.br.joel.Project.Ws.controller;

import com.br.joel.Project.Ws.DTO.UserDTO;
import com.br.joel.Project.Ws.model.SubscriptionType;
import com.br.joel.Project.Ws.model.User;
import com.br.joel.Project.Ws.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> listUsers() {

        return ResponseEntity.ok().body(usersService.listAllUsers());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return  ResponseEntity.ok().body(usersService.findById(id));
    }


    @PostMapping
    public ResponseEntity<User> createSubs(@RequestBody UserDTO type) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(type));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateSubs(@PathVariable Long id,  @RequestBody UserDTO type) {


        return ResponseEntity.status(201).body(usersService.update(id, type));


    }


    @DeleteMapping(value = "/{id}")

    public ResponseEntity<Void> deleteSubs(@PathVariable Long id) {
        usersService.deleteUser(id);

        return  ResponseEntity.noContent().build();
    }

}

package com.br.joel.Project.Ws.controller;

import com.br.joel.Project.Ws.DTO.SubsCriptionTypeDto;
import com.br.joel.Project.Ws.model.SubscriptionType;
import com.br.joel.Project.Ws.services.SubscriptionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subs")
public class SubsCriptionController {



    private  final SubscriptionTypeService subscriptionTypeService;

    public SubsCriptionController(SubscriptionTypeService subscriptionTypeService) {
        this.subscriptionTypeService = subscriptionTypeService;
    }


    @GetMapping
    public ResponseEntity<List<SubscriptionType>> listResponseEntity() {

        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.listAllSubscriptionTypes());
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id) {
        SubscriptionType subscriptionType = subscriptionTypeService.findById(id);

        return  ResponseEntity.ok().body(subscriptionType);
    }


    @PostMapping
    public ResponseEntity<SubscriptionType> createSubs(@RequestBody SubsCriptionTypeDto type) {

        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.save(type));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<SubscriptionType> updateSubs(@PathVariable Long id,  @RequestBody SubsCriptionTypeDto type) {


        return ResponseEntity.status(201).body(subscriptionTypeService.update(id, type));


    }


    @DeleteMapping(value = "/{id}")

    public ResponseEntity<Void> deleteSubs(@PathVariable Long id) {
        subscriptionTypeService.deleteSubs(id);

        return  ResponseEntity.noContent().build();
    }
}

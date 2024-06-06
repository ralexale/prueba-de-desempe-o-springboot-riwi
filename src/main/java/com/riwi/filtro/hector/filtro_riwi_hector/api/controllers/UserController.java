package com.riwi.filtro.hector.filtro_riwi_hector.api.controllers;


import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.UserRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.UserResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {


    @Autowired
    private IUserService userService;


    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Validated @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.create(userRequest));
    }


    @GetMapping("/class")
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);
        return  ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<UserResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Validated @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.update(userRequest, id));
    }



}

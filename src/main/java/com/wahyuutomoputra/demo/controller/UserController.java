package com.wahyuutomoputra.demo.controller;

import com.wahyuutomoputra.demo.dto.SaveUser;
import com.wahyuutomoputra.demo.useCase.UserUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserUseCaseImpl userUseCase;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody SaveUser saveUser){
        return new ResponseEntity<>(userUseCase.createUser(saveUser), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody SaveUser saveUser){
        return new ResponseEntity<>(userUseCase.login(saveUser), HttpStatus.OK);
    }
}

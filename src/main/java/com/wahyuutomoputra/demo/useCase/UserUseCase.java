package com.wahyuutomoputra.demo.useCase;

import com.wahyuutomoputra.demo.dto.SaveUser;

import java.util.Map;

public interface UserUseCase {
    Map<String, Object> createUser(SaveUser saveUser);
    Map<String, Object> login(SaveUser saveUser);
}

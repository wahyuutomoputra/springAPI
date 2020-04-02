package com.wahyuutomoputra.demo.useCase;

import com.wahyuutomoputra.demo.config.JwtToken;
import com.wahyuutomoputra.demo.dto.SaveUser;
import com.wahyuutomoputra.demo.model.User;
import com.wahyuutomoputra.demo.repository.UserRepo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserUseCaseImpl implements UserUseCase {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    public Map<String, Object> createUser(SaveUser saveUser) {
        Map<String, Object> newMap = new HashMap<>();

        User user = new User();
        String hash = DigestUtils.md5Hex(saveUser.getPassword());

        user.setEmail(saveUser.getEmail());
        user.setNama(saveUser.getNama());
        user.setPassword(hash);
        userRepo.save(user);
        newMap.put("Sukses", user);

        return newMap;
    }

    @Override
    public Map<String, Object> login(SaveUser saveUser) {
        Map<String, Object> newMap = new HashMap<>();
        Optional<User> user = userRepo.findById(saveUser.getEmail());

        if (user.isPresent()){
            String hashPwd = DigestUtils.md5Hex(saveUser.getPassword());

            if (user.get().getPassword().equals(hashPwd)){
                final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(saveUser.getEmail());
                final String token = jwtToken.generateToken(userDetails);

                newMap.put("data", user.get());
                newMap.put("token", token);
                newMap.put("login", true);
            }else {
                newMap.put("data", null);
                newMap.put("login", false);
            }
        }else {
            newMap.put("data", "User not found");
            newMap.put("login", false);
        }

        return newMap;
    }
}

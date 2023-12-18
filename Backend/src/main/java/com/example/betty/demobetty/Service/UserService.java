package com.example.betty.demobetty.Service;


import com.example.betty.demobetty.Dto.UserDto;
import com.example.betty.demobetty.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    UserDto findUserById(String id);

    String addUser(UserDto user);

    void deleteUser(String id);

    UserDto updateUser(UserDto user);

    Optional<User> log_in(String details);
}

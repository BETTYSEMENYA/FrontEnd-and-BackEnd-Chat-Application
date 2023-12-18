package com.example.betty.demobetty.Controller;

import com.example.betty.demobetty.Dto.UserDto;
import com.example.betty.demobetty.Entity.User;
import com.example.betty.demobetty.Repository.UserRepository;
import com.example.betty.demobetty.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
    @RequestMapping("api/v1/user")
    @CrossOrigin(origins = "http://localhost:4200/")
    public class UserController {

       private final UserService userService;



       @Autowired
        private final UserRepository repo;

        public UserController(UserService userService, UserRepository repo) {
            this.userService = userService;
            this.repo = repo;
        }

        @CrossOrigin(origins = "http://localhost:4200/")
        @GetMapping("/{details}")
        public Optional<User> login(@PathVariable String details) {
            return userService.log_in(details);
        }


        @CrossOrigin(origins = "http://localhost:4200/")
        @PostMapping("/register")
        public String saveUser(@RequestBody UserDto userDto) {
            Optional<User> existingUser = repo.findByEmailAddress(userDto.getEmailAddress());

            if (existingUser.isPresent()) {
                return "Email already exists";
            } else {
                return userService.addUser(userDto);
            }
        }

        @PutMapping()
        public UserDto updateUser(@RequestBody UserDto user) {
            return userService.updateUser(user);
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable String id) {
            userService.deleteUser(id);
        }
    }


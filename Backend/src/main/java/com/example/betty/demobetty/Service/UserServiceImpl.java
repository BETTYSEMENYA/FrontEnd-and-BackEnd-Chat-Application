package com.example.betty.demobetty.Service;

import com.example.betty.demobetty.Dto.UserDto;
import com.example.betty.demobetty.Entity.User;
import com.example.betty.demobetty.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {

        @Autowired
        private  UserRepository userRepository;




    @Override
        public UserDto findUserById(String id) {
            User user = userRepository.findById(id).orElse(new User());
            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUserName());
            userDto.setContact(user.getContact());
            userDto.setEmailAddress(user.getEmailAddress());


            return userDto;
        }

        @Override
        public String addUser(UserDto userDto) {
            User user = new User();
            user.setContact(userDto.getContact());
            user.setUserName(userDto.getUserName());
            user.setEmailAddress(userDto.getEmailAddress());
            return userRepository.save(user).getId();
        }

        @Override
        public void deleteUser(String id) {
            userRepository.deleteById(id);
        }

        @Override
        public UserDto updateUser(UserDto userDto) {
            UserDto existingUser = findUserById(userDto.getId());
            if (existingUser == null) {
                return userDto;
            }
            User user = new User();
            user.setContact(userDto.getContact());
            user.setUserName(userDto.getUserName());
            user.setEmailAddress(userDto.getEmailAddress());
            userRepository.save(user);
            return userDto;
        }

    @Override
        public Optional<User> log_in(String details) {
            Optional<User> userOptional = userRepository.findByContactOrEmailAddress(details,details);

            if (userOptional.isPresent()) {
                return userOptional;
            } else {
                return Optional.empty();
            }
        }

    }




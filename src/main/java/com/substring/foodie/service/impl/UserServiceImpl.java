package com.substring.foodie.service.impl;

import com.substring.foodie.dto.UserDto;
import com.substring.foodie.repository.UserRepository;
import com.substring.foodie.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDto getUser(String userId) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return List.of();
    }

    @Override
    public List<UserDto> searchUserName(String keyword) {
        return List.of();
    }
}

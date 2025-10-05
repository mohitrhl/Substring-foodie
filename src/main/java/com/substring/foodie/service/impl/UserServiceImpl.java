package com.substring.foodie.service.impl;

import com.substring.foodie.config.AppConstants;
import com.substring.foodie.dto.UserDto;
import com.substring.foodie.entity.RoleEntity;
import com.substring.foodie.entity.User;
import com.substring.foodie.exception.ResourceNotFoundException;
import com.substring.foodie.repository.RoleRepo;
import com.substring.foodie.repository.UserRepo;
import com.substring.foodie.service.UserService;
import com.substring.foodie.util.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final ResourcePatternResolver resourcePatternResolver;

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    private RoleRepo roleRepo;

    private ModelMapper modelMapper;


    public UserServiceImpl(UserRepo userRepo, ResourcePatternResolver resourcePatternResolver, PasswordEncoder passwordEncoder, RoleRepo roleRepo, ModelMapper modelMapper) {
        this.resourcePatternResolver = resourcePatternResolver;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        //generate new id for user
        userDto.setId(Helper.generateRandomId());
        User user = convertUserDtoToUser(userDto);
        //we are encoding password :
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // guest : role
        RoleEntity roleGuest = roleRepo.findByName(AppConstants.getRoleGuest());
        user.getRoleEntities().add(roleGuest);
        //save the user to database
        User savedUser = userRepo.save(user);
        return convertUserDtoToUserDto(savedUser);
    }

    //TODO:
    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public List<UserDto> getUserByName(String userName) {
        return userRepo.findByName(userName).stream().map(
                (user) -> convertUserDtoToUserDto(user)
        ).toList();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User not found !!")
        );
        return convertUserDtoToUserDto(user);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found !!")
        );
        return convertUserDtoToUserDto(user);
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found !!")
        );
        userRepo.delete(user);
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> userPage = userRepo.findAll(pageable);
        //return after converting to Page<UserDto>
        return userPage.map(user -> convertUserDtoToUserDto(user));
    }
    @Override
    public List<UserDto> searchUser(String keyword) {
        return List.of();
    }

    private User convertUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto convertUserDtoToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);

    }


}

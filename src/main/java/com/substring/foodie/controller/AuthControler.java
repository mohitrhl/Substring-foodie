package com.substring.foodie.controller;

import com.substring.foodie.dto.JwtResponse;
import com.substring.foodie.dto.LoginRequest;
import com.substring.foodie.dto.UserDto;
import com.substring.foodie.repository.UserRepo;
import com.substring.foodie.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthControler {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    private UserRepo userRepo;
    private ModelMapper modelMapper;

    public AuthControler(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtService jwtService,UserRepo userRepo, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {


        //created authentication
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        //authenticating
        authenticationManager.authenticate(authentication);

        //getting userdetail
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email());

        UserDto userDto = modelMapper.map(userRepo.findByEmail(userDetails.getUsername()).get(), UserDto.class);
        //getting token
        String jwtToken = jwtService.generateToken(userDto.getEmail(), true);
        String refreshToken = jwtService.generateToken(userDto.getEmail(), false);
        JwtResponse build = JwtResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).user(userDto).build();
        return ResponseEntity.ok(build);

    }
}

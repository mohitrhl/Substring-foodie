package com.substring.foodie.controller.example;

import com.substring.foodie.payload.example.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RequestMapping("/auth")
public class AuthController {

    //login

    //logger declear
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> data){
        logger.info("login request: {}", data);
        return data;
    }

    //sign up
    @PostMapping("/signup")
    public String signup(@RequestBody UserDto userDto){
        //System.out.println(userData.getName());

        logger.info("user name : {}", userDto.getName());
        logger.info("user age : {}", Optional.of(userDto.getAge()));
        logger.info("password : {}", userDto.getPassword());
        logger.info("email : {}", userDto.getEmail());
        return "we got the data";

    }
}

package com.substring.foodie.controller.example;


import com.substring.foodie.dto.UserDto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RequestMapping("/auth")
public class AuthController {

    //logger declear
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    //login
    @GetMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> data) {

        String test=null;
        test.length();//null pointer exception ko generate kiya hai

        logger.info("login request: {}", data);
        return data;
    }

    //sign up
    @PostMapping("/signup")
    public String signup(@Valid @RequestBody UserDto userDTO,
                         @RequestHeader("User-Agent") String agent,
                         @RequestHeader("Authorization") String token){
        //System.out.println(userData.getName());

        logger.info("user name : {}", userDTO.getName());
        logger.info("password : {} ", userDTO.getPassword());
        logger.info("email : {} ", userDTO.getEmail());
        logger.info("age : {} ", userDTO.getAge());
        logger.info("user agent : {}", agent);
        logger.info("token : {}", token);
        return "we got data";


    }
}

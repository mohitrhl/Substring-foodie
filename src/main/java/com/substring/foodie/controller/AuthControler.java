package com.substring.foodie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public class AuthControler {
    //login
    // logger declare::
    private Logger logger = LoggerFactory.getLogger(AuthControler.class);

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> data) {

        String test=null;
        test.length();//null pointer exception ko generate kiya hai

        logger.info("login request: {}", data);
        return data;
    }
}

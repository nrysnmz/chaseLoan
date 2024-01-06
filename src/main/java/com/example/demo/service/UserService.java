package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Component with @Autowired for constructor injection

@Component
public class UserService {
    private final Logger logger;

    // @Autowired on the constructor indicates that Logger should be injected
    @Autowired
    public UserService(Logger logger) {
        this.logger = logger;
    }

//    public void performAction() {
//        // Using the injected Logger
//        logger.log("User action performed");
//        // Other logic...
//    }
}

class A{
    @Autowired
   static UserService userService;

    public static void main(String[] args) {
        userService.toString();
    }
}

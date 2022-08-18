package com.wircodeteam.ecommercedemo.controller;

import com.wircodeteam.ecommercedemo.DTO.UserDTO;
import com.wircodeteam.ecommercedemo.error.UserNotFoundException;
import com.wircodeteam.ecommercedemo.requests.AuthRequest;
import com.wircodeteam.ecommercedemo.service.AccountService;
import com.wircodeteam.ecommercedemo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public UserDTO Login(@RequestBody AuthRequest authRequest) throws UserNotFoundException {
        //validation the username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        String token = jwtUtil.generateToken(authRequest.getUsername());
        UserDTO userDTO=new UserDTO();
        userDTO.setToken(token);
        return userDTO;
    }
}

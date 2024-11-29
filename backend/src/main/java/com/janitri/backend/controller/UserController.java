package com.janitri.backend.controller;

import com.janitri.backend.DTO.LoginDTO;
import com.janitri.backend.model.User;
import com.janitri.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDTO loginDTO){
        return userService.userLogin(loginDTO);
    }

    @PostMapping("signup")
    public ResponseEntity<?> userSignUp(@RequestBody User user){
        return userService.userSignUp(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        return userService.getUserDetails(id);
    }
}

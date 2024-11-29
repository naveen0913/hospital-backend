package com.janitri.backend.service;

import com.janitri.backend.DTO.LoginDTO;
import com.janitri.backend.model.User;
import com.janitri.backend.repository.UserRepository;
import com.janitri.backend.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> userLogin(@NonNull LoginDTO loginDTO){
        Optional<User> existedUser = userRepository.findByEmail(loginDTO.getEmail());
        if (existedUser.isEmpty() ){
            return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND.value(), "User not found"), HttpStatus.NOT_FOUND) ;
        }else if (!loginDTO.getPassword().equals(existedUser.get().getPassword())){
            return new ResponseEntity(new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Incorrect password"), HttpStatus.BAD_REQUEST) ;
        }
        return new ResponseEntity(new ApiResponse(HttpStatus.OK.value(), "Login Successful",existedUser), HttpStatus.OK);

    }

    public ResponseEntity<?> userSignUp(@NonNull User user){
        Optional<User> existedUser = userRepository.findByEmail(user.getEmail());
        if (existedUser.isPresent()){
            return new ResponseEntity(new ApiResponse(HttpStatus.CONFLICT.value(), "User already exists"), HttpStatus.CONFLICT) ;
        } else if (user.getEmail().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return new ResponseEntity(new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Invalid SignUp Data"), HttpStatus.BAD_REQUEST) ;

        }
        userRepository.save(user);
        return new ResponseEntity(new ApiResponse(HttpStatus.CREATED.value(), "User Signup Successful"), HttpStatus.CREATED) ;
    }

    public ResponseEntity<?> getUserDetails(String id){
        Optional<User> existedUser=userRepository.findById(id);
        if (existedUser.isEmpty()){
            return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND.value(), "User not found"), HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(new ApiResponse(HttpStatus.OK.value(), "user fetched successfully",existedUser), HttpStatus.OK);
    }
}

package com.example.Login.controller;

import com.example.Login.dto.UserDto;
import com.example.Login.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(registrationService.registerUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping("/userDetails")
    public ResponseEntity<List<UserDto>> getUsers(){
        return new ResponseEntity<>(registrationService.getAllRegisterUsers(), HttpStatus.OK);
    }
    @GetMapping("/login")
    public ResponseEntity<UserDto> loginUser(){
        return new ResponseEntity<>(registrationService.getUserDetails(), HttpStatus.OK);
    }
    @PutMapping("/activate-account")
    public  ResponseEntity<String> activateAccount(Integer otp,String userName){
        return new ResponseEntity<>(registrationService.activateAccount(otp,userName),HttpStatus.OK);
    }
    @PostMapping("/forget-password")
    public ResponseEntity<String> forgetPassword(String userName){
        return new ResponseEntity<>(registrationService.forgetPassword(userName),HttpStatus.OK);
    }
    @PutMapping("/user-details")
    public ResponseEntity<UserDto> updateUserDetails(UserDto userDto){
        return  new ResponseEntity<>(registrationService.updateUserDetails(userDto),HttpStatus.OK);
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(Integer otp,String userName,String password){
        return new ResponseEntity<>(registrationService.resetPassword(otp,userName,password),HttpStatus.OK);
    }

}

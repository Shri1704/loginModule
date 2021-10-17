package com.example.Login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserDto {
    private  UserDto userDetails;
    private String userName;
    private String password;
}

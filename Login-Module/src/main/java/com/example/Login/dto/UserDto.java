package com.example.Login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDto {
    private UUID userId;
    private String name;
    private Integer age;
    private String email;
    private AddressDto address;
    private Integer phoneNumber;
    private String userName;
    private String password;
}

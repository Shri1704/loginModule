package com.example.Login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private  String address;
    private String street;
    private String city;
    private String state;
    private String country;
    private String  postalCode;

}

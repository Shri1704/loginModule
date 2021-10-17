package com.example.Login.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailSenderDto {
    private String emailTo;
    private String emailSubject;
    private String emailBody;
    private  String emailName;
}

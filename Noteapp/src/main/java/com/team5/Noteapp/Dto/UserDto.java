package com.team5.Noteapp.Dto;

import com.team5.Noteapp.Validator.Email;
import com.team5.Noteapp.Validator.PhoneNumber;
import lombok.Data;

@Data
public class UserDto {

    private String name;

    private String surname;

    @PhoneNumber
    private String phoneNumber;

    @Email
    private String mail;

    private String username;

    private String password;


}
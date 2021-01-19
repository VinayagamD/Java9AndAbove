package com.vinaylogics.springboot.springsecurity.dtos;

import com.vinaylogics.springboot.springsecurity.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private UserType type = UserType.USER;
}

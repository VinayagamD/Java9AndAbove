package com.vinaylogics.springboot.springsecurity.dtos;

import com.vinaylogics.springboot.springsecurity.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {

    private Long id;
    private String username;
    @Builder.Default
    private UserType type = UserType.USER;
}

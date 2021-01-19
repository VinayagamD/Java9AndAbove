package com.vinaylogics.springboot.springsecurity.services;

import com.vinaylogics.springboot.springsecurity.dtos.*;
import com.vinaylogics.springboot.springsecurity.models.User;

public interface AuthService {

    AuthenticationResponse login(LoginRequest request);

    User getCurrentUser();

    AuthenticationResponse refreshToken(RefreshTokenRequest request);

    RegisterResponse registerUser(RegisterRequest request);
}

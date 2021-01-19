package com.vinaylogics.springboot.springemail.utils;

import java.util.Base64;

public interface Constant {

    interface Email{
        String USER_NAME = "dmluYXlhZ2FtLm1lZXR1cEBnbWFpbC5jb20=";
        String PASSWORD = "RHJhZ29zQDE=";
        Base64.Decoder decoder  = Base64.getDecoder();
    }
}

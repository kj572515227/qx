package com.xingqing.model;

import lombok.Data;

@Data
public class UserLogin {
    private String username;
    private String password;
    private String verification;
    private int rememberMe;
}

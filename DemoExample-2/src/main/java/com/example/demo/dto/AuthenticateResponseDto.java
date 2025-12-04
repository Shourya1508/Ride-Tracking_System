package com.example.demo.dto;

import java.io.Serializable;

public class AuthenticateResponseDto implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    public AuthenticateResponseDto(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

}
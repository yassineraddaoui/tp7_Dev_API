package com.example.tp7.payload.response;

public class LoginResponse extends StandardResponse {
    private String token; //still not implemented
    public LoginResponse(String message,String token) {
        super(message);
        this.token=token;
    }
}

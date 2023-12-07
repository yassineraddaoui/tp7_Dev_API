package com.example.tp7.payload.response;


import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class StandardResponse {
    public String message;

    public StandardResponse(String message) {
        this.message = message;
    }
}

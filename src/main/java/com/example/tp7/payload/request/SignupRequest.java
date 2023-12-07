package com.example.tp7.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class SignupRequest {
    private String password;
    private String name;
    private String contactInformation;
}

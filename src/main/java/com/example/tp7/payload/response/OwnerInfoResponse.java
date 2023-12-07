package com.example.tp7.payload.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerInfoResponse {
    private String message;
    private String name;
    private String contactInfo;
}

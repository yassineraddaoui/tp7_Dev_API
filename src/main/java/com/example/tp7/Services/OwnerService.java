package com.example.tp7.Services;


import com.example.tp7.payload.request.LoginRequest;
import com.example.tp7.payload.request.SignupRequest;
import com.example.tp7.payload.request.UpdateOwnerRequest;
import com.example.tp7.payload.response.OwnerInfoResponse;
import com.example.tp7.payload.response.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface OwnerService {
    ResponseEntity<? extends StandardResponse> login(LoginRequest loginRequest);

    ResponseEntity<? extends StandardResponse> signup(SignupRequest signupRequest);


    ResponseEntity<StandardResponse> deleteOwner(String ownerName);

    ResponseEntity<StandardResponse> updateOwner(String ownerName, UpdateOwnerRequest updateRequest);

    ResponseEntity<OwnerInfoResponse> getOwner(String ownerName);
}

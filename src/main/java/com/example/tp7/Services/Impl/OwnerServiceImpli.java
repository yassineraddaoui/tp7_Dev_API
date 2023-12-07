package com.example.tp7.Services.Impl;

import com.example.tp7.Models.Owner;
import com.example.tp7.Repositories.OwnerRepo;
import com.example.tp7.Services.OwnerService;
import com.example.tp7.payload.request.LoginRequest;
import com.example.tp7.payload.request.SignupRequest;
import com.example.tp7.payload.request.UpdateOwnerRequest;
import com.example.tp7.payload.response.LoginResponse;
import com.example.tp7.payload.response.OwnerInfoResponse;
import com.example.tp7.payload.response.SignupResponse;
import com.example.tp7.payload.response.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpli implements OwnerService {

    private final OwnerRepo ownerRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<? extends StandardResponse> login(LoginRequest loginRequest) {
        var ownerOptional = ownerRepo.findByName(loginRequest.getName());
        StandardResponse response ;
        if (ownerOptional.isPresent()) {
            var owner = ownerOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), owner.getPassword())) {
                response = new LoginResponse("connexion succeed","still not implemented");
                return new ResponseEntity<>(response, HttpStatus.OK);

            } else {  //bad password
                throw new BadCredentialsException("Bad Password");
            }
        }
        // if user doesn't exist ==> OptionalOwner is empty
        response = new StandardResponse("User doesn't exist !");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<? extends StandardResponse> signup(SignupRequest signupRequest) {

        Optional<Owner> optionalOwner = ownerRepo.findByName(signupRequest.getName());
        StandardResponse signupResponse;
        if (optionalOwner.isPresent()) {
            signupResponse = new StandardResponse("User already exist , please Login !");
        } else {
            var ownerCreated = Owner.builder()
                    .name(signupRequest.getName())
                    .password(passwordEncoder.encode(signupRequest.getPassword()))
                    .contactInformation(signupRequest.getContactInformation())
                    .build();
            ownerRepo.save(ownerCreated);

            signupResponse = new SignupResponse("Useer Created !");
        }
        return new ResponseEntity<>(signupResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse> deleteOwner(String ownerName) {
        StandardResponse response;

        Optional<Owner> OptionalOwner = ownerRepo.findByName(ownerName);

        if (OptionalOwner.isPresent()) {
            ownerRepo.deleteByName(ownerName);
            response= new StandardResponse("Owner Deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response = new StandardResponse("User doesnt exist , please sign up");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse> updateOwner(String ownerName, UpdateOwnerRequest updateRequest) {
        StandardResponse response;

        Optional<Owner> optionalOwner = ownerRepo.findByName(ownerName);

        if (optionalOwner.isPresent()) {
            var updatedUser = optionalOwner.get();
            updatedUser.setName(updatedUser.getName());
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword())); //This is only for test
            updatedUser.setContactInformation(updateRequest.getContactInformation());
            response = new StandardResponse("Owner Deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response = new StandardResponse("Owner doesnt exist , please sign up");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OwnerInfoResponse> getOwner(String ownerName) {
        OwnerInfoResponse response;

        Optional<Owner> optionalOwner = ownerRepo.findByName(ownerName);

        if (optionalOwner.isPresent()) {
            var owner = optionalOwner.get();
            response = OwnerInfoResponse.builder()
                    .contactInfo(owner.getContactInformation())
                    .name(owner.getName())
                    .message("this is owner :" + owner.getId())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response = OwnerInfoResponse.builder()
                .message("Owner doesnt exist , please sign up")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

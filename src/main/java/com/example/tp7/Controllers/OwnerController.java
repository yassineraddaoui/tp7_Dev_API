package com.example.tp7.Controllers;


import com.example.tp7.Services.OwnerService;
import com.example.tp7.payload.request.LoginRequest;
import com.example.tp7.payload.request.SignupRequest;
import com.example.tp7.payload.request.UpdateOwnerRequest;
import com.example.tp7.payload.response.LoginResponse;
import com.example.tp7.payload.response.OwnerInfoResponse;
import com.example.tp7.payload.response.SignupResponse;
import com.example.tp7.payload.response.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/owner")
public class OwnerController {

    private final OwnerService ownerService;

    //Security part still not implemented this is only for test.
    @PostMapping("/signup")
    public ResponseEntity<? extends StandardResponse> signup(@RequestBody SignupRequest signupBody){
        return ownerService.signup(signupBody);
    }
    @PostMapping("/login")
    public ResponseEntity<? extends StandardResponse> login(@RequestBody LoginRequest loginRequest){
        return  ownerService.login(loginRequest);
    }

    @GetMapping("/{ownerName}")
    public ResponseEntity<OwnerInfoResponse> getOwner(@PathVariable String ownerName) {
        return ownerService.getOwner(ownerName);
    }

    @PutMapping("/{ownerName}")
    public ResponseEntity<StandardResponse> updateOwner(@PathVariable String ownerName, @RequestBody UpdateOwnerRequest updateRequest) {
        return ownerService.updateOwner(ownerName, updateRequest);
    }

    @DeleteMapping("/{ownerName}")
    public ResponseEntity<StandardResponse> deleteOwner(@PathVariable String ownerName) {
        return ownerService.deleteOwner(ownerName);
    }

}


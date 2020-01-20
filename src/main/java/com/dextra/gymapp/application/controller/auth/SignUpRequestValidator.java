package com.dextra.gymapp.application.controller.auth;

import com.dextra.gymapp.domain.repository.UserRepository;
import com.dextra.gymapp.infrastructure.configuration.payload.ApiResponse;
import com.dextra.gymapp.infrastructure.configuration.payload.SignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SignUpRequestValidator implements RequestValidator{

    private static final String USERNAME_ALREADY_REGISTERED = "Username is already taken!";

    private static final String EMAIL_ALREADY_REGISTERED = "Email Address already in use!";

    private SignUpRequest signUpRequest;

    private UserRepository userRepository;

    private ResponseEntity responseError;

    public SignUpRequestValidator(SignUpRequest signUpRequest, UserRepository userRepository) {
        this.signUpRequest = signUpRequest;
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid() {
        if(this.checkUsernameAlreadyTaken(signUpRequest)) {
            this.responseError = new ResponseEntity<>(new ApiResponse(false, USERNAME_ALREADY_REGISTERED), HttpStatus.BAD_REQUEST);
            return false;
        }

        if(this.checkEmailAlreadyTaken(signUpRequest)) {
            this.responseError = new ResponseEntity<>(new ApiResponse(false, EMAIL_ALREADY_REGISTERED), HttpStatus.BAD_REQUEST);
            return false;
        }
        return true;
    }

    public ResponseEntity getResponseError() {
        return responseError;
    }

    public void setResponseError(ResponseEntity responseError) {
        this.responseError = responseError;
    }

    private boolean checkUsernameAlreadyTaken(final SignUpRequest signUpRequest) {
        return userRepository.existsByUsername(signUpRequest.getUsername());
    }

    private boolean checkEmailAlreadyTaken(final SignUpRequest signUpRequest) {
        return userRepository.existsByEmail(signUpRequest.getEmail());
    }
}

package com.dextra.gymapp.application.controller.auth;

import com.dextra.gymapp.domain.enums.EntityName;
import com.dextra.gymapp.domain.enums.RoleName;
import com.dextra.gymapp.domain.model.access.Entity;
import com.dextra.gymapp.domain.model.access.Role;
import com.dextra.gymapp.domain.model.User;
import com.dextra.gymapp.domain.repository.EntityRepository;
import com.dextra.gymapp.domain.repository.RoleRepository;
import com.dextra.gymapp.domain.repository.UserRepository;
import com.dextra.gymapp.infrastructure.configuration.exception.AppException;
import com.dextra.gymapp.infrastructure.configuration.payload.ApiResponse;
import com.dextra.gymapp.infrastructure.configuration.payload.JwtAuthenticationResponse;
import com.dextra.gymapp.infrastructure.configuration.payload.LoginRequest;
import com.dextra.gymapp.infrastructure.configuration.payload.SignUpRequest;
import com.dextra.gymapp.infrastructure.configuration.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EntityRepository entityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    private static final String SUCCESSFUL_REGISTERED = "User registered successfully";

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        SignUpRequestValidator signUpRequestValidator = new SignUpRequestValidator(signUpRequest, userRepository);
        if(signUpRequestValidator.isValid()) {
            User result = this.createUser(signUpRequest);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/api/users/{username}")
                    .buildAndExpand(result.getUsername()).toUri();

            return ResponseEntity.created(location).body(new ApiResponse(true, SUCCESSFUL_REGISTERED));
        }

        return signUpRequestValidator.getResponseError();
    }

    private User createUser(final SignUpRequest signUpRequest) {
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getAddress());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                .orElseThrow(() -> new AppException("User Role not set."));

        Entity userEntity = entityRepository.findByName(EntityName.GYM)
                .orElseThrow(() -> new AppException("User Entity not set."));

        Set<Entity> entities = new HashSet<>();
        entities.add(userEntity);

        user.setEntities(entities);
        user.setRole(userRole);

        return userRepository.save(user);
    }
}

package com.encatch.controller;

import com.encatch.exception.AppException;
import com.encatch.model.Role;
import com.encatch.model.RoleName;
import com.encatch.model.User;
import com.encatch.payload.ApiResponse;
import com.encatch.payload.JwtAuthenticationResponse;
import com.encatch.payload.LoginRequest;
import com.encatch.payload.SignUpRequest;
import com.encatch.repository.RoleRepository;
import com.encatch.repository.UserRepository;
import com.encatch.security.JwtTokenProvider;
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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

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
        if(userRepository.existsByMobileNumber(signUpRequest.getPhoneNumber())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmailId())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getPhoneNumber(),
                signUpRequest.getEmailId(), signUpRequest.getPassword(), signUpRequest.getAddress(),signUpRequest.getAddress());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

      /*  Role userRole = roleRepository.findByName(signUpRequest.getRoles())
                .orElseThrow(() -> new AppException("User Role not set."));*/
        
        Set<Role> roles = new HashSet<>();
        if(null!=signUpRequest.getRoles() && !signUpRequest.getRoles().isEmpty()){
        	for(Role role:signUpRequest.getRoles()){
        		Role userRole = roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new AppException("User Role not set."));
        		roles.add(userRole);
        	}
        	
        }else{
        	Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new AppException("User Role not set."));
        	roles.add(userRole);
        }

        user.setRoles(roles);

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getMobileNumber()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}

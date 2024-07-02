package com.alurachallenges.forohub.forumengineapi.ControllerAPI;

import com.alurachallenges.forohub.forumengineapi.Infrastructure.Security.AuthService;
import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.AuthUsersDTO;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.Security.DTOJWTToken;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.Security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authenticationService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthUsersDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );
        var authUser = authenticationManager.authenticate(authToken);
        var token = tokenService.generateToken(User).authUser.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(new DTOJWTToken(token));
    }
}
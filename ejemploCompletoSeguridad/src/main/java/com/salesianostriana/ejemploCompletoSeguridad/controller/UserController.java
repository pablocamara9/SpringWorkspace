package com.salesianostriana.ejemploCompletoSeguridad.controller;

import com.salesianostriana.ejemploCompletoSeguridad.dto.CreateUserRequest;
import com.salesianostriana.ejemploCompletoSeguridad.dto.LoginRequest;
import com.salesianostriana.ejemploCompletoSeguridad.dto.UserResponse;
import com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.JwtService;
import com.salesianostriana.ejemploCompletoSeguridad.model.User;
import com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.refresh.RefreshToken;
import com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.refresh.RefreshTokenService;
import com.salesianostriana.ejemploCompletoSeguridad.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> register(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        // Generar el token de acceso
        String accessToken = jwtService.generateAccessToken(user);

        // Generar el token de refresco
        String refreshToken = refreshTokenService.create(user).getToken();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user, accessToken, refreshToken));
    }

    @GetMapping("/me")
    public UserResponse me(@AuthenticationPrincipal User user) {
        return UserResponse.of(user);
    }

    @GetMapping("/me/admin")
    public User adminMe(@AuthenticationPrincipal User user) {
        return user;
    }

}

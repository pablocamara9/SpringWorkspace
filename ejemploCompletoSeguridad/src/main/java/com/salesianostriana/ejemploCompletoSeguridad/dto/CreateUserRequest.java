package com.salesianostriana.ejemploCompletoSeguridad.dto;

public record CreateUserRequest(
        String username,
        String password,
        String verifyPassword
) {
}

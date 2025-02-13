package com.salesianostriana.ejemploCompletoSeguridad.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianostriana.ejemploCompletoSeguridad.model.User;

import java.util.UUID;

//@JsonIgnore
public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String accessToken,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String RefreshAccessToken

) {

    public static UserResponse of(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                null,
                null
        );
    }

    public static UserResponse of(User user, String accessToken, String RefreshAccessToken) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                accessToken,
                RefreshAccessToken
        );
    }
}

package com.salesianostriana.segundoEjemploSeguridad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.segundoEjemploSeguridad.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserResponse {

    protected String id;
    protected String username, avatar, fullName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    protected LocalDateTime createdAt;

    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .fullName(user.getFullName())
                .createdAt(user.getCreatedAt())
                .build();
    }

}

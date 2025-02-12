package com.salesianostriana.ejemploCompletoSeguridad.service;

import com.salesianostriana.ejemploCompletoSeguridad.dto.CreateUserRequest;
import com.salesianostriana.ejemploCompletoSeguridad.model.User;
import com.salesianostriana.ejemploCompletoSeguridad.model.UserRole;
import com.salesianostriana.ejemploCompletoSeguridad.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest createUserRequest) {
            User user = User.builder()
                    .username(createUserRequest.username())
                    .password(passwordEncoder.encode(createUserRequest.password()))
                    .roles(Set.of(UserRole.USER))
                    .build();

            return userRepository.save(user);
    }



}

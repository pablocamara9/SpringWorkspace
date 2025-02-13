package com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.refresh;

import com.salesianostriana.ejemploCompletoSeguridad.model.User;
import com.salesianostriana.ejemploCompletoSeguridad.repos.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Value("${jwt.refresh.duration}")
    private int durationInMinutes;

    @Transactional
    public RefreshToken create(User user) {
        User u = userRepository.findById(user.getId()).orElse(null);
        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .user(u)
                        .token(UUID.randomUUID().toString())
                        .expireAt(Instant.now().plusSeconds(durationInMinutes * 60))
                        .build()
        );
    }

}

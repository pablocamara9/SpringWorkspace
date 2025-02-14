package com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.refresh;

import com.salesianostriana.ejemploCompletoSeguridad.dto.UserResponse;
import com.salesianostriana.ejemploCompletoSeguridad.model.User;
import com.salesianostriana.ejemploCompletoSeguridad.repos.UserRepository;
import com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.JwtService;
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
    private final JwtService jwtService;

    @Value("${jwt.refresh.duration}")
    private int durationInMinutes;

    //@Transactional
    public RefreshToken create(User user) {
        refreshTokenRepository.deleteByUser(user);

        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .user(user)
                        //.token(UUID.randomUUID().toString())
                        .expireAt(Instant.now().plusSeconds(durationInMinutes * 60))
                        .build()
        );
    }

    public RefreshToken verify(RefreshToken refreshToken) {
        if(refreshToken.getExpireAt().compareTo(Instant.now()) < 0) {
            // Token de refresco caducado
            // Borrar el token
            refreshTokenRepository.delete(refreshToken);
            throw new RefreshTokenException("Token de refresco caducado. Por favor, vuelva a loguearse");
        }

        return refreshToken;
    }

    //@Transactional
    public UserResponse refreshToken(String token) {
        return refreshTokenRepository.findById(UUID.fromString(token))
                .map(this::verify)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String accessToken = jwtService.generateAccessToken(user);
                    //refreshTokenRepository.deleteByUser(user);
                    //refreshTokenRepository.deleteById(UUID.fromString(token));

                    RefreshToken refreshedToken = this.create(user);
                    return UserResponse.of(user, accessToken, refreshedToken.getToken());
                })
                .orElseThrow(() -> new RefreshTokenException("No se ha podido refrescar el token."));

    }

}

package com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.refresh;

import com.salesianostriana.ejemploCompletoSeguridad.model.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshToken {

    @Id
    private UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", columnDefinition = "uuid")
    private User user;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String token;

    @Builder.Default
    private Instant createdAt = Instant.now();

    @Column(nullable = false)
    private Instant expireAt;



}

package com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access.refresh;

import com.salesianostriana.ejemploCompletoSeguridad.security.exceptionhandling.JwtException;

public class RefreshTokenException extends JwtException {

    public RefreshTokenException(String message) {
        super(message);
    }

}

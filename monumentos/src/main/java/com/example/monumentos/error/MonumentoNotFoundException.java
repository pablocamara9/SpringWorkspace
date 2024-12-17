package com.example.monumentos.error;

public class MonumentoNotFoundException extends RuntimeException {
    public MonumentoNotFoundException(Long id) {
        super("No hay monumento con ID " + id);
    }

    public MonumentoNotFoundException(String mensaje) {
        super(mensaje);
    }

    public MonumentoNotFoundException() {
        super("No hay monumentos con esos parámetros de búsqueda");
    }
}

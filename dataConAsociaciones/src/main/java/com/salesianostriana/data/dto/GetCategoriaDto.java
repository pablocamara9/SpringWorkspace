package com.salesianostriana.data.dto;

public record GetCategoriaDto(
        Long id,
        String nombre
) {
    public static GetCategoriaDto fromCategoria(Long id, String nombre) {
        return new GetCategoriaDto(id, nombre);
    }
}

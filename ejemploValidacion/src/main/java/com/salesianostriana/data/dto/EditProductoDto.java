package com.salesianostriana.data.dto;

public record EditProductoDto(
        String nombre,
        String descripcion,
        double precio,
        Long categoriaId
) {

}

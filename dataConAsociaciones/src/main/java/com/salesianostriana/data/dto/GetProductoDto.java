package com.salesianostriana.data.dto;

import com.salesianostriana.data.model.Producto;

public record GetProductoDto(
        Long id,
        String nombre,
        String descripcion,
        GetCategoriaDto categoriaId
) {
    public static GetProductoDto of(Producto p) {
        return new GetProductoDto(
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                GetCategoriaDto.fromCategoria(p.getCategoria().getId(), p.getNombre())
        );
    }
}

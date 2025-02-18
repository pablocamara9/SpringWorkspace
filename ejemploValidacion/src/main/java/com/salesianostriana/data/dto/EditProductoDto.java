package com.salesianostriana.data.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record EditProductoDto(

        @NotBlank
        String nombre,

        @NotBlank
        String descripcion,

        @DecimalMin("0.01")
        @DecimalMax("99.99")
        double precio
) {

}

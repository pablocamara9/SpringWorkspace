package com.example.monumentos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    private Long id;
    private String codPais;
    private String nombre;
    private String ciudad;
    private double longitud;
    private double latitud;
    private String descripcion;
    private String urlImagen;

}

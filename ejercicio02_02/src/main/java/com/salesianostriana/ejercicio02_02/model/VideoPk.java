package com.salesianostriana.ejercicio02_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoPk implements Serializable {

    private Long id;
    private CursoOnline cursoOnline;

}

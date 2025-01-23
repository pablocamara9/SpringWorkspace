package com.salesianostriana.herencia.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
public class Alumno extends Persona {

    private double notaMedia;

}

package com.salesianostriana.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    @Builder.Default
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    private Set<Producto> productos = new HashSet<>();

    


}

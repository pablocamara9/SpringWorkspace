package com.salesianostriana.onetomany.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {

    @Id
    @GeneratedValue
    @Column(name = "biblioteca_id")
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    @JsonManagedReference
    private List<Libro> libros = new ArrayList<>();

    // Métodos helper
    public void addLibro(Libro libro) {
        libro.setBiblioteca(this);
        this.libros.add(libro);
    }

    public void removeLibro(Libro libro) {
        this.libros.remove(libro);
        libro.setBiblioteca(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Biblioteca that = (Biblioteca) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}

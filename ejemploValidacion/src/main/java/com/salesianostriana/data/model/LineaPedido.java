package com.salesianostriana.data.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@IdClass(LineaPedidoId.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    private Pedido pedido;

    private int cantidad;
    private double precioVenta;
}

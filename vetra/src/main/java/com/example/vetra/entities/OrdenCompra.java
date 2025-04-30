package com.example.vetra.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenCompra extends Base {

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(name = "fecha_orden", nullable = false)
    private LocalDateTime fechaOrden;

    @Column(name = "monto_total", nullable = false)
    private double montoTotal;

    @Column(name = "medio_pago")
    private String medioPago;
}
package com.example.vetra.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "descuentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Descuento extends BaseEntity {

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_cierre", nullable = false)
    private Date fechaCierre;

    @Column(name = "porcentaje", nullable = false)
    private double descuento;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "descuento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;
}
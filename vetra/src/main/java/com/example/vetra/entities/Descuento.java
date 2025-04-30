package com.example.vetra.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

public class Descuento extends Base{

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_cierre")
    private Date fechaCierre;

    @Column(name = "descuento")
    private double descuento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Producto> productos;
}

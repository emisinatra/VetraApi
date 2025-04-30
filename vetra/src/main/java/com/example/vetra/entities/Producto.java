package com.example.vetra.entities;

import com.example.vetra.entities.enums.Categoria;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Producto extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "stock")
    private int stock;

    @Column(name = "categoria")
    private List<Categoria> categorias;

    @Column(name = "color")
    private String color;

    @Column(name = "marca")
    private String marca;

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    @ManyToMany
    @JoinTable()
    private List<Talle> talles;
}

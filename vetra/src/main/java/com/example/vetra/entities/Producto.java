package com.example.vetra.entities;

import com.example.vetra.entities.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends Base {

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @ElementCollection(targetClass = Categoria.class)
    @CollectionTable(name = "producto_categorias", joinColumns = @JoinColumn(name = "producto_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private List<Categoria> categorias;

    private String color;

    private String marca;

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    @ManyToMany
    @JoinTable(
            name = "producto_talle",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "talle_id")
    )
    private List<Talle> talles;
}
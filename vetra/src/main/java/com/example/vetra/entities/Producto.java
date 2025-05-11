package com.example.vetra.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Esta es la entidad que representa un producto en la tienda
@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends Base {

    // Nombre del producto (obligatorio)
    @Column(nullable = false)
    private String nombre;

    // Descripción detallada del producto
    private String descripcion;

    // Precio del producto (obligatorio)
    @Column(nullable = false)
    private double precio;

    // Cantidad disponible en stock (obligatorio)
    @Column(nullable = false)
    private int stock;

    // Categorías a las que pertenece el producto (ej: remeras, pantalones)
    @ManyToMany
    @JoinTable(
            name = "producto_categorias",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    // Color del producto
    private String color;

    // Marca del producto
    private String marca;

    // URL de la imagen del producto
    private String imagen;

    // Descuento aplicado al producto (si tiene)
    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    // Talles disponibles para este producto
    @ManyToMany
    @JoinTable(
            name = "producto_talle",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "talle_id")
    )
    private List<Talle> talles;
}
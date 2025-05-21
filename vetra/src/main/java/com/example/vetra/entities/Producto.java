package com.example.vetra.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

// Esta es la entidad que representa un producto en la tienda
@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Producto extends BaseEntity {

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

    // Acá van las categorías del producto, viste, si es remera, pantalón, etc.
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
package com.example.vetra.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "domicilios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Direccion extends BaseEntity {
    private String calle;
    private int codpost;

    @ManyToMany(mappedBy = "direcciones", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
}

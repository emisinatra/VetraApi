package com.example.vetra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "direcciones", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Usuario> usuarios;
}

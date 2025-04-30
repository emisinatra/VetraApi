package com.example.vetra.entities;

import com.example.vetra.entities.enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends Base{

    protected String nombre;
    protected String email;
    protected String contraseña;
    protected Rol rol;

}

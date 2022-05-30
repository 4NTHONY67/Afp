package com.example.afp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Schema(description = "Información de cliente")
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre de la persona")
    @Size(min=10, message = "Nombres debe tener como mínimo 10 digitos.")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Size(min=10, message = "Apellidos debe tener como mínimo 10 digitos.")
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Pattern(regexp = "^[0-9]*$", message = "DNI no cumple con la expresión ^[0-9]*$")
    @Size(min=8, max=8, message = "DNI debe tener 8 digitos.")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;


    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "afp", nullable = false, length = 20)
    private String afp;

    @Column(name = "telefono", nullable = false)
    private int telefono;


}

package com.example.afp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Información de la solicitud de retiro del cliente")
@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "^[0-9]*$", message = "DNI no cumple con la expresión ^[0-9]*$")
    @Size(min=8, max=8, message = "DNI debe tener 8 digitos.")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Schema(description = "Monto de retiro que desea realizar el cliente")
    @Column(name = "monto", nullable = false)
    private float monto;

    @Column(name = "afp", nullable = false, length = 20)
    private String afp;
}

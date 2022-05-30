package com.example.afp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Información de afp")
@Data
@Entity
@Table(name = "afp")
public class Afp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "afp", nullable = false, length = 20)
    private String afp;

    @Pattern(regexp = "^[0-9]*$", message = "DNI no cumple con la expresión ^[0-9]*$")
    @Size(min=8, max=8, message = "DNI debe tener 8 digitos.")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Schema(description = "Monto disponible del cliente")
    @Column(name = "monto", nullable = false)
    private float monto;

    @Schema(description = "Fecha de retiro de fondos del cliente")
    @Column(name = "fecha", nullable = false)
    private long fecha;

    @Schema(description = "Numero de cuenta")
    @Column(name = "nrocuenta", nullable = false, length = 20)
    private String nrocuenta;

}

package com.example.PokemonAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

    @NotNull(message = "El nivel es requerido")
    @Min(value = 1 , message = "El nivel minimo es 1")
    @Max(value = 100 , message = "El nivel maximo es 100")
    private Integer nivel;

    @Min(value = 1 , message = "El ataque minimo es 1")
    private Integer ataque;

    @Min(value = 0 , message = "La defensa no puede ser negativa")
    private Integer defensa;

    @Size(max = 255, message= "La longitud de la descripción no puede exceder de los 255")
    private String descripcion;

    @URL(message = "La imagen debe ser una URL")
    private String imagenUrl;

    @Email(message = "El correo debe tener un formato válido")
    private String correoEntrenador;

    @NotBlank(message= "El nombre no puede estar vacío")
    @Size(min = 2 , max = 50 , message = "El nombre debe de tener entre 2 y 50 caracteres")
    private String nombre;

    @PastOrPresent(message = "La fecha de nacimiento no puede ser mayor a la actual")
    private LocalDate fechaNacimiento;

    @Positive(message = "El peso del pokemon debe ser mayot a 0" )
    private Double peso;

    @Pattern(regexp= "^\\d{10}$", message = "El formato del telefono debe ser válido")
    private String telefonoEntrenador;

    @AssertTrue(message = "El pokemon debe estar sanito")
    private boolean estaSano;
}

package com.examen.vacaciones.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_vacacion")
@Getter
@Setter
public class Vacacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 150)
    @Column(nullable = false)
    private String empleado;

    @NotNull
    @Column(name = "inicio_vacaciones", nullable = false)
    private LocalDate inicioVacaciones;

    @NotNull
    @Column(name = "fin_vacaciones", nullable = false)
    private LocalDate finVacaciones;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoVacacion estado;

    // Enum interno para el estado
    public enum EstadoVacacion {
        PENDIENTE,
        APROBADA,
        RECHAZADA
    }
}

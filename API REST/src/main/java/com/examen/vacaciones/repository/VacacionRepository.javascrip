package com.examen.vacaciones.repository;

import com.examen.vacaciones.entity.Vacacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VacacionRepository extends JpaRepository<Vacacion, Long> {

    // Buscar vacaciones por nombre de empleado
    List<Vacacion> findByNombreEmpleado(String nombreEmpleado);

    // Buscar vacaciones activas en una fecha específica
    @Query("SELECT v FROM Vacacion v WHERE :fecha BETWEEN v.fechaInicio AND v.fechaFin")
    List<Vacacion> buscarVacacionesActivas(@Param("fecha") LocalDate fecha);

    // Buscar por rango de fechas
    List<Vacacion> findByFechaInicioBetween(LocalDate inicio, LocalDate fin);

    // Buscar por ID pero devolviendo Optional explícito
    Optional<Vacacion> findById(Long id);
}

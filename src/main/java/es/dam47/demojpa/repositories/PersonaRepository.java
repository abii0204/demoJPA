package es.dam47.demojpa.repositories;

import es.dam47.demojpa.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByNombre(String nombre);

    Persona findByEmail(String email);

    List<Persona> findByNombreContainingIgnoreCase(String nombre);

    //    List<Persona> findByFechaNacimientoBetween(LocalDate fechaInicio, LocalDate fechaFin);
    Optional<List<Persona>> findAllBy();

}

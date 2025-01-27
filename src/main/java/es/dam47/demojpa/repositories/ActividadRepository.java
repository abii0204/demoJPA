package es.dam47.demojpa.repositories;

import es.dam47.demojpa.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//todo lo relacionado con las consultas con la columna actividad
//declaramos los metodos que queremos que nos devuelvanueremos que implemennte esta interfaz

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    Optional<List<Actividad>> findByPersona_Id(Long id);
}

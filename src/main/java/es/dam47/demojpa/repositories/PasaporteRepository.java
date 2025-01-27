package es.dam47.demojpa.repositories;

import es.dam47.demojpa.models.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasaporteRepository extends JpaRepository<Pasaporte, Long> {
}

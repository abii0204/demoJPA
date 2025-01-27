package es.dam47.demojpa.repositories;

import es.dam47.demojpa.models.Pasaporte;
import es.dam47.demojpa.models.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
}

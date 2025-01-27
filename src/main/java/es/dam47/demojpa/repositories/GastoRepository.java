package es.dam47.demojpa.repositories;

import es.dam47.demojpa.models.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}

package es.dam47.demojpa.services;

import es.dam47.demojpa.models.Pasaporte;
import es.dam47.demojpa.models.Persona;
import es.dam47.demojpa.models.Telefono;
import es.dam47.demojpa.repositories.PasaporteRepository;
import es.dam47.demojpa.repositories.PersonaRepository;
import es.dam47.demojpa.repositories.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired //No hace falta constructor, esto lo autoinstancia
    private PersonaRepository personaRepository;

    @Autowired
    private PasaporteRepository pasaporteRepository;

    public boolean savePassport(Pasaporte pasaporte) {
        try {
            pasaporteRepository.save(pasaporte);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Autowired
    private TelefonoRepository telefonoRepository;

    public Telefono saveTelefono(Telefono telefono) {
        return telefonoRepository.save(telefono);
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    public Optional<Persona> save(Persona persona) {
        if (persona.getPasaporte() != null) {
            persona.getPasaporte().setPersona(persona);
        }
        if (persona.getTelefono() != null) {
            persona.getTelefono().setPersona(persona);
        }
        try {
            Optional<Persona> p = Optional.of(personaRepository.save(persona));
            return p;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    public Persona findByEmail(String email) {
        return personaRepository.findByEmail(email);
    }

    public List<Persona> findByNombreContaining(String nombre) {
        return personaRepository.findByNombreContainingIgnoreCase(nombre);
    }

//    public List<Persona> findByFechaNacimientoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
//        return personaRepository.findByFechaNacimientoBetween(fechaInicio, fechaFin);
//    }

    public Optional<List<Persona>> findPersonas() {
        return personaRepository.findAllBy();
    }

}


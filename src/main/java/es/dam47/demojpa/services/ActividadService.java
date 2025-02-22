package es.dam47.demojpa.services;


import es.dam47.demojpa.models.Actividad;
import es.dam47.demojpa.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> buscarPorIdPersona(Long idPersona){
        Optional<List<Actividad>> listaActividadesOptional =
                actividadRepository.findByPersona_Id(idPersona);

        if(listaActividadesOptional.isPresent()){
            return listaActividadesOptional.get();
        }

        return null;
    }

    public boolean crearActividad(Actividad actividad) {

        try {
            actividadRepository.save(actividad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

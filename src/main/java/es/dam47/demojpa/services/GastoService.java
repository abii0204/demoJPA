package es.dam47.demojpa.services;

import es.dam47.demojpa.models.Gasto;
import es.dam47.demojpa.repositories.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public boolean crearGasto(Gasto gasto){
        try{
            gastoRepository.save(gasto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

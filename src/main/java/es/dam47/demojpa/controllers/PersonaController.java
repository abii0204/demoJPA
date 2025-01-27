package es.dam47.demojpa.controllers;

import es.dam47.demojpa.models.Pasaporte;
import es.dam47.demojpa.models.Persona;
import es.dam47.demojpa.models.ResponseModel;
import es.dam47.demojpa.models.Telefono;
import es.dam47.demojpa.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

//        @GetMapping("/obtener_todas")
//        public String obtenerPersona() { //devolver datos
//            return "Hola mundo";
//        }

    @DeleteMapping("/borrar/{id}")
        public ResponseEntity<String> borra(@PathVariable Long id) {
        personaService.delete(id);
        return ResponseEntity.ok("Persona borrada con éxito");
    }

    @PostMapping("/crearPasaporte") // END POINT PARA CREAR PASAPORTES
    public ResponseEntity<String> crearPasaporte(@RequestBody Pasaporte pasaporte) {
        if(personaService.savePassport(pasaporte)){
            return ResponseEntity.ok("Pasaporte creado");
        }
        return ResponseEntity.ok("El pasaporte ya existe");
    }

    @PostMapping("/crearTelefono")
    public ResponseEntity<Telefono> crearTelefono(@RequestBody Telefono telefono) {
        return ResponseEntity.ok(personaService.saveTelefono(telefono));
    }

    @PostMapping("/crear") // END POINT PARA CREAR Y ACTUALIZAR PERSONAS (para actualizar hay qie psar ID)
    public ResponseEntity<ResponseModel> crearPersona(@RequestBody Persona persona) {
        ResponseModel response = new ResponseModel();
        try{
            Optional<Persona> p = personaService.save(persona);
            if(p.isPresent()){
                response.setSuccess(0);
                response.setMessage("Persona creada con éxito");
                response.setData(persona.getId());
                return ResponseEntity.ok(response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setSuccess(1); //1 quiere decir que falló
        response.setMessage("Error al crear la persona");
        response.setData(null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nombre/{nombre}") //NOMBRE EXACTO
    public ResponseEntity<Persona> obtenerPersona(@PathVariable String nombre) {
        return ResponseEntity.ok(personaService.findByNombre(nombre));
    }

    @GetMapping("/{nombre}") //PARTE DEL NOMBRE
    public ResponseEntity<List<Persona>> obtenerPersonaByNameContaining(@PathVariable String nombre) {
        return ResponseEntity.ok(personaService.findByNombreContaining(nombre));
    }

//    @GetMapping("/fechas/{fechaInicio}/{fechaFin}") // END POINT ENTRE FECHAS
//    public ResponseEntity<List<Persona>> findByFechaNacimientoBetween(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin) {
//        return ResponseEntity.ok(personaService.findByFechaNacimientoBetween(fechaInicio, fechaFin));
//    }

    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerPersonas() {
        ResponseModel response = new ResponseModel();

        Optional<List<Persona>> listaPersonasOptional =
                personaService.findPersonas();

        if (listaPersonasOptional.isPresent()) {
            response.setSuccess(0);
            response.setMessage("Personas encontradas");
            response.setData(listaPersonasOptional.get());
            return ResponseEntity.ok(response);
        }
        response.setSuccess(1);
        response.setMessage("No se encontro personas");
        response.setData(null);
        return ResponseEntity.ok(response);
    }
}



package es.dam47.demojpa.controllers;

import es.dam47.demojpa.models.Gasto;
import es.dam47.demojpa.models.ResponseModel;
import es.dam47.demojpa.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearGasto(@RequestBody Gasto gasto) {

        ResponseModel responseModel = new ResponseModel();

        if (gastoService.crearGasto(gasto)) {
            responseModel.setMessage("Gasto creado");
            responseModel.setSuccess(0);
            responseModel.setData(null);
            return ResponseEntity.ok(responseModel);
        }
        responseModel.setMessage("Error al crear el gasto");
        responseModel.setSuccess(1);
        responseModel.setData(null);
        return ResponseEntity.ok(responseModel);
    }
}

package com.example.afp.api;

import com.example.afp.exception.ModeloNotFoundException;
import com.example.afp.model.Solicitud;
import com.example.afp.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "solicitudes")
public class SolicitudApi {

    @Autowired
     SolicitudService solicitudService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> findAll() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @PostMapping
    public ResponseEntity<Solicitud> create(@Valid @RequestBody Solicitud solicitud){
        Solicitud response = solicitudService.create(solicitud);
        return new ResponseEntity<Solicitud>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Solicitud> update(@Valid @RequestBody Solicitud solicitud){
        Solicitud response = solicitudService.update(solicitud);
        return  ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Solicitud solicitud = solicitudService.findById(id);
        if(solicitud.getId() == 0){
            throw new ModeloNotFoundException("ID no encontrado");
        }
        solicitudService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

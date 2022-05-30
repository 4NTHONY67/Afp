package com.example.afp.api;

import com.example.afp.exception.ModeloNotFoundException;
import com.example.afp.model.Cliente;
import com.example.afp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class ClienteApi {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente){
        Cliente response = clienteService.create(cliente);
        return new ResponseEntity<Cliente>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente){
        Cliente response = clienteService.update(cliente);
        return  ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Cliente cliente = clienteService.findById(id);
        if(cliente.getId() == 0){
            throw new ModeloNotFoundException("ID no encontrado");
        }
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

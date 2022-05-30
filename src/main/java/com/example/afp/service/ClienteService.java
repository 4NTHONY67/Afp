package com.example.afp.service;

import com.example.afp.model.Cliente;
import com.example.afp.model.Solicitud;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente create(Cliente cliente);

    Cliente update(Cliente cliente);

    Cliente findById(long id);

    void delete(long id);
}

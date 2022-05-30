package com.example.afp.service.impl;

import com.example.afp.model.Cliente;
import com.example.afp.repository.ClienteRepository;
import com.example.afp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(long id) {
        Optional<Cliente> op = clienteRepository.findById(id);
        return op.isPresent() ? op.get() : new Cliente() ;
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }

}

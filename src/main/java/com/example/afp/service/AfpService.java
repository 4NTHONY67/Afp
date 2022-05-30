package com.example.afp.service;

import com.example.afp.model.Afp;
import com.example.afp.model.Solicitud;

import java.util.List;

public interface AfpService {

    List<Afp> findAll();

    Afp create(Afp afp);

    Afp update(Afp afp);

    Afp findById(long id);

    void delete(long id);
}

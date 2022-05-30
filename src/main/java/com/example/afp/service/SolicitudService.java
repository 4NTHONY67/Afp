package com.example.afp.service;

import com.example.afp.model.Solicitud;

import java.util.List;

public interface SolicitudService {

    List<Solicitud> findAll();

    Solicitud create(Solicitud solicitud);

    Solicitud update(Solicitud solicitud);

    Solicitud findById(long id);

    void delete(long id);
}

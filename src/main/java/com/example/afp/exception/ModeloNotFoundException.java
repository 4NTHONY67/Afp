package com.example.afp.exception;

public class ModeloNotFoundException extends RuntimeException{

    public ModeloNotFoundException(String mensaje){
        super(mensaje);
    }

}
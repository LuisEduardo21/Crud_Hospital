package com.crud.hospital.crud.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -7915253746748523406L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}

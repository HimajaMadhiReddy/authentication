package com.ucm.authentication.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateRecordException extends Exception {

    public DuplicateRecordException(String message){
        super(message);
    }
}

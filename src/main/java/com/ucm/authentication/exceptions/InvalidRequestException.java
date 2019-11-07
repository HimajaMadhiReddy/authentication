package com.ucm.authentication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class InvalidRequestException extends Exception{

    public InvalidRequestException(String message){
        super(message);

    }

}
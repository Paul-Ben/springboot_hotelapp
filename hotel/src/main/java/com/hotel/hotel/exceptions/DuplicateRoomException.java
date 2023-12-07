package com.hotel.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateRoomException extends RuntimeException{

    public DuplicateRoomException(String message){
        super(message);
    }

}

package com.aitor.springwebapplication.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityNotExistsException extends ServiceException {
    public EntityNotExistsException() {
        super("Entity with current ID not exists");
        this.statusCode = HttpStatus.NOT_FOUND;
    }
}

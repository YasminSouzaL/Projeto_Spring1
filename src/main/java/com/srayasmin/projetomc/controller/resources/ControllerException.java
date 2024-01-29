package com.srayasmin.projetomc.controller.resources;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.srayasmin.projetomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerException {
    public ControllerEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}

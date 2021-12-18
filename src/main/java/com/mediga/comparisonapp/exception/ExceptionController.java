package com.mediga.comparisonapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> notFoudException(CarNotFoundException carNotFoundException) {
        return new ResponseEntity<>(carNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ComparisonException.class)
    public ResponseEntity<Object> tooManyCarIdsException(ComparisonException comparisonException) {
        return new ResponseEntity<>(comparisonException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.vixsys.dscommerce.controllers.handlers;

import com.vixsys.dscommerce.dtos.CustomError;
import com.vixsys.dscommerce.services.exceptions.DatabaseException;
import com.vixsys.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler
{
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request)
   {
      HttpStatus status = HttpStatus.NOT_FOUND;
      CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
      return ResponseEntity.status(status).body(error);
   }

   @ExceptionHandler(DatabaseException.class)
   public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request)
   {
      HttpStatus status = HttpStatus.BAD_REQUEST;
      CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
      return ResponseEntity.status(status).body(error);
   }
}

package com.germano.os.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.germano.os.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	// Trata Exceção de objeto não encontrado
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
		StandardError error = new StandardError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	// Manipula a integridade dos dados
	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StandardError> objectNotFoundException(DataIntegratyViolationException e){
		StandardError error = new StandardError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	// Manipulador de exceções de Error
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> objectNotFoundException(MethodArgumentNotValidException e){
		ValidationError error = new ValidationError(System.currentTimeMillis(),HttpStatus.
				BAD_REQUEST.value(),"Erro na validação dos campos!");
	
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}

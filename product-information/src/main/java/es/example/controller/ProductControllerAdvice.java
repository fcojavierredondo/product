package es.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.example.dto.ErrorDto;

/**
 * Create exceptions to handle them.
 * 
 * @project product-information
 * @package es.example.service
 * @date 20123-03-17
 * @author Fco Javier Redondo Martín
 * @version 1.1
 */
@RestControllerAdvice
public class ProductControllerAdvice {
	
	/**
	 * Using a builder, the error object is created to throw the exception when needed.
	 * 
	 * @return A ResponseEntity the error object and a bad request http status.
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {
		
		ErrorDto error = ErrorDto.builder().code("E-500").message(ex.getMessage()).build();
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

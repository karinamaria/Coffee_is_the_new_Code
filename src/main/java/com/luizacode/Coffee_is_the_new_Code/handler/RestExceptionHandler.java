package com.luizacode.Coffee_is_the_new_Code.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.luizacode.Coffee_is_the_new_Code.error.ErrorDetail;
import com.luizacode.Coffee_is_the_new_Code.error.ResourceNotFoundException;
import com.luizacode.Coffee_is_the_new_Code.error.NegocioException;
import com.sun.org.apache.xpath.internal.operations.Neg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luizacode.Coffee_is_the_new_Code.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rnfException){
		ErrorDetail rnfDetails = ErrorDetail.ErrorDetailBuilder
				.newBuilder()
				.timestamp(new Date().getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.title("Resource not found")
				.detail(rnfException.getMessage())
				.developerMessage(rnfException.getClass().getName())
				.build();
		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handlerNegocioException(NegocioException rnfException){
		ErrorDetail rnfDetails = ErrorDetail.ErrorDetailBuilder
				.newBuilder()
				.timestamp(new Date().getTime())
				.status(HttpStatus.CONFLICT.value())
				.title("Business rule error")
				.detail(rnfException.getMessage())
				.developerMessage(rnfException.getClass().getName())
				.build();
		return new ResponseEntity<>(rnfDetails, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException manveException){
		List<FieldError> fieldErrors = manveException.getBindingResult().getFieldErrors();
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		ValidationErrorDetails rnfDetais = ValidationErrorDetails.Builder
				.newBuilder()
				.timestamp(new Date().getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.title("Field Validation Error")
				.detail("Field Validation Error")
				.developerMessage(manveException.getClass().getName())
				.field(fields)
				.fieldMessage(fieldMessages)
				.build();
		return new ResponseEntity<>(rnfDetais, HttpStatus.NOT_FOUND);
	}
}

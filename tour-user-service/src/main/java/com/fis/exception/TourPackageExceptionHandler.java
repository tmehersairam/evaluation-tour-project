package com.fis.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class TourPackageExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> globalExceptionHandler(Exception exception, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setException(exception.getMessage());
		exceptionResponse.setPath(request.getDescription(false));
		exceptionResponse.setTimeStamp(new Date().toString());
		exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}

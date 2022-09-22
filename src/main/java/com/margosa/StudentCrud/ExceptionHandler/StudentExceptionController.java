package com.margosa.StudentCrud.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionController {

	
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<Object> exception(UserNotFoundException exception) {
	      return new ResponseEntity<>("student not found  with this id in the database", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = UserFoundException.class)
	   public ResponseEntity<Object> exception(UserFoundException exception) {
	      return new ResponseEntity<>("student is with this id is already exists please try another", HttpStatus.FOUND);
	   }
}

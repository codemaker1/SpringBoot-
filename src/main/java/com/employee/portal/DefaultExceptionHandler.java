package com.employee.portal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class DefaultExceptionHandler {
	
	
//	@ExceptionHandler({RuntimeException.class})
//	public ResponseEntity<String> handleExceptionRuntime(Exception ex)
//	{
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//	}
	
	@ExceptionHandler({Exception.class})
	public String   handleException( )
	{
		return "error";
	}

}

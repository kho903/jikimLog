package com.jikim.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jikim.blog.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse invalidExceptionHandler(MethodArgumentNotValidException e) {
		// if (e.hasErrors()) {
			/*FieldError fieldError = e.getFieldError();
			String field = fieldError.getField();
			String message = fieldError.getDefaultMessage();*/
		// }
		return new ErrorResponse("400", "잘못된 요청입니다.");
	}
}

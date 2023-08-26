package com.jikim.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jikim.blog.request.PostCreate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PostController {

	@GetMapping("/posts")
	public String get() {
		return "Hello World";
	}

	@PostMapping("/posts")
	public Map<String, String>  post(
			// @RequestParam String title, @RequestParam String content
			// @RequestParam Map<String, String> params
			// JSON으로 입력 시 RequestBody
			@RequestBody @Valid PostCreate params,
			BindingResult result
	) throws Exception {
		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			FieldError firstFieldError = fieldErrors.get(0);
			String fieldName = firstFieldError.getField();
			String errorMessage = firstFieldError.getDefaultMessage();

			Map<String, String> error = new HashMap<>();
			error.put(fieldName, errorMessage);
			return error;
		}
		return Map.of();
	}
}

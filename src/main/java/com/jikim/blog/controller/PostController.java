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
			@RequestBody @Valid PostCreate params
	) throws Exception {
		/**
		 * 문제점.
		 *  1. 매번 메서드마다 값을 검증해야 함.
		 * 		- 까먹을 수 있음. 버그 발생 가능성 높음.
		 * 	2. 응답값에 HashMap -> 응답 클래스를 만들어 주는 것이 좋음.
		 * 	3. 여러 개의 에러처리 힘듦.
		 * 	4. 세 번 이상의 반복적인 작업은 피해야 함.
		 */
		/*if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			FieldError firstFieldError = fieldErrors.get(0);
			String fieldName = firstFieldError.getField();
			String errorMessage = firstFieldError.getDefaultMessage();

			Map<String, String> error = new HashMap<>();
			error.put(fieldName, errorMessage);
			return error;
		}*/
		return Map.of();
	}
}

package com.jikim.blog.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * {
 *     "code" : "400",
 *     "message" : "잘못된 요청입니다."
 * }
 */
@Getter
@RequiredArgsConstructor
public class ErrorResponse {

	private final String code;
	private final String message;

	private Map<String, String> validation = new HashMap<>();

	public void addValidation(String fieldName, String errorMessage) {
		this.validation.put(fieldName, errorMessage);
	}
}

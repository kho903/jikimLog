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
import com.jikim.blog.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping("/posts")
	public Map<String, String>  post(
			@RequestBody @Valid PostCreate request) {

		postService.write(request);
		return Map.of();
	}
}

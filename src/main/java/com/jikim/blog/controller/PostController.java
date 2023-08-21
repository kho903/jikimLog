package com.jikim.blog.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String post(
			// @RequestParam String title, @RequestParam String content
			// @RequestParam Map<String, String> params
			// JSON으로 입력 시 RequestBody
			@RequestBody PostCreate params
	) {
		// log.info("title={}, content={}", title, content);
		log.info("params={}", params);
		return "Hello World";
	}
}

package com.jikim.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class PostControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("/posts 요청시 Hello World를 출력함.")
	void test() throws Exception {
		// expected
		mockMvc.perform(get("/posts"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello World"));
	}
}
package com.jikim.blog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class PostControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("GET /posts 요청시 Hello World를 출력함.")
	void getTest() throws Exception {
		// expected
		mockMvc.perform(get("/posts"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello World"));
	}

	@Test
	@DisplayName("POST /posts 요청시 Hello World를 출력함.")
	void postTest() throws Exception {
		// expected
		mockMvc.perform(post("/posts")
				/*.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.param("title", "글 제목입니다.")
				.param("content", "글 내용입니다. 하하")*/
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\": \"제목입니다.\", \"content\":\"내용입니다.\"}")
			)
			.andExpect(status().isOk())
			.andExpect(content().string("{}"));
	}

	@Test
	@DisplayName("POST /posts 요청시 Hello World를 출력함.")
	void postTest2() throws Exception {
		// expected
		mockMvc.perform(post("/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\": \"\", \"content\":\"내용입니다.\"}")
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value("타이틀을 입력해주세요."))
			.andDo(print());
	}
}
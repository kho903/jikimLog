package com.jikim.blog.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jikim.blog.domain.Post;
import com.jikim.blog.repository.PostRepository;
import com.jikim.blog.request.PostCreate;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PostRepository postRepository;

	@BeforeEach
	void clean() {
		postRepository.deleteAll();
	}

	@Test
	@DisplayName("POST /posts 요청시 Hello World를 출력함.")
	void postTest() throws Exception {
		PostCreate request = PostCreate.builder()
			.title("제목입니다.")
			.content("내용입니다.")
			.build();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(request);
		System.out.println("json = " + json);
		// expected
		mockMvc.perform(post("/posts")
				.contentType(APPLICATION_JSON)
				.content(json)
			)
			.andExpect(status().isOk())
			.andExpect(content().string("{}"));
	}

	@Test
	@DisplayName("POST /posts 요청시 title 값은 필수다.")
	void postTest2() throws Exception {
		// given
		PostCreate request = PostCreate.builder()
			.title("")
			.content("내용입니다.")
			.build();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(request);
		System.out.println("json = " + json);
		// expected
		mockMvc.perform(post("/posts")
				.contentType(APPLICATION_JSON)
				.content(json)
			)
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.code").value("400"))
			.andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
			.andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
			.andDo(print());
	}

	@Test
	@DisplayName("/posts 요청시 DB에 값이 저장된다.")
	void dbSaveTest() throws Exception {
		PostCreate request = PostCreate.builder()
			.title("제목입니다.")
			.content("내용입니다.")
			.build();		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(request);
		System.out.println("json = " + json);
	    // when
		mockMvc.perform(post("/posts")
			.contentType(APPLICATION_JSON)
			.content(json)
		)
			.andExpect(status().isOk())
			.andDo(print());

	    // then
		assertEquals(1L, postRepository.count());

		Post post = postRepository.findAll().get(0);
		assertEquals("제목입니다.", post.getTitle());
		assertEquals("내용입니다.", post.getContent());
	}
}
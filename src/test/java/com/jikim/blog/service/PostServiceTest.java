package com.jikim.blog.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jikim.blog.domain.Post;
import com.jikim.blog.repository.PostRepository;
import com.jikim.blog.request.PostCreate;
import com.jikim.blog.response.PostResponse;

@SpringBootTest
class PostServiceTest {

	@Autowired
	private PostService postService;

	@Autowired
	private PostRepository postRepository;

	@BeforeEach
	void clean() {
		postRepository.deleteAll();
	}

	@Test
	@DisplayName("글 작성")
	void postWrite() throws Exception {
	    // given
		PostCreate postCreate = PostCreate.builder()
			.title("제목입니다.")
			.content("내용입니다.")
			.build();

		// when
		postService.write(postCreate);

	    // then
		assertEquals(1L, postRepository.count());

		Post post = postRepository.findAll().get(0);
		assertEquals("제목입니다.", post.getTitle());
		assertEquals("내용입니다.", post.getContent());
	}

	@Test
	@DisplayName("글 1개 조회")
	void getPost() throws Exception {
		// given
		Post requestPost = Post.builder()
			.title("1234567890123")
			.content("bar")
			.build();
		postRepository.save(requestPost);

		// when
		PostResponse response = postService.get(requestPost.getId());

		// then
		assertNotNull(response);
		assertEquals(1L, postRepository.count());
		assertEquals("1234567890", response.getTitle());
		assertEquals("bar", response.getContent());
	}

	@Test
	@DisplayName("글 여러 개 조회")
	void getPosts() throws Exception {
		// given
		postRepository.saveAll(List.of(
			Post.builder()
				.title("foo1")
				.content("bar1")
				.build(),
			Post.builder()
				.title("foo2")
				.content("bar2")
				.build()
		));

		// when
		List<PostResponse> posts = postService.getList();

		// then
		assertEquals(2L, posts.size());
	}

}

package com.jikim.blog.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jikim.blog.domain.Post;
import com.jikim.blog.repository.PostRepository;
import com.jikim.blog.request.PostCreate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public void write(PostCreate postCreate) {
		Post post = Post.builder()
				.title(postCreate.getTitle())
				.content(postCreate.getContent())
				.build();
		postRepository.save(post);
	}

	public Post get(Long id) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

		return post;
	}
}

package com.jikim.blog.service;

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
		Post post = new Post(postCreate.getTitle(), postCreate.getContent());
		postRepository.save(post);
	}
}

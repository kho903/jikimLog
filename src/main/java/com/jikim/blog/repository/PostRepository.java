package com.jikim.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jikim.blog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

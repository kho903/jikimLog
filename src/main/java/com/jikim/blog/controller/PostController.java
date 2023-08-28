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

import com.jikim.blog.domain.Post;
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
	public void post(
			@RequestBody @Valid PostCreate request) {

		// Case 1. 저장한 데이터 Entity -> response 로 응답하기
		// Case 2. 저장한 데이터의 primary_id -> response 로 응답하기
		//		   Client 에서는 수신한 id를 글 조회 API를 통해서 데이터를 수신받음.
		// Case 3. 응답 필요 없음 -> 클라이언트에서 모든 POST (글) 데이터 context 를 잘 관리함
		// Bad Case : 서버에서 -> 반드시 이렇게 하자 fix.
		//			-> 서버에서 차라리 유연하게 대응하는 것이 좋음.
		//			-> 한 번에 일괄적으로 잘 처리되는 케이스는 없음. -> 잘 관리하는 형태가 중요.
		postService.write(request);
	}
}

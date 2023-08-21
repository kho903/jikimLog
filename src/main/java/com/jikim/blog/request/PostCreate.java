package com.jikim.blog.request;

public class PostCreate {

	public String title;
	public String content;

	public PostCreate(String title, String content) {
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostCreate{" +
			"title='" + title + '\'' +
			", content='" + content + '\'' +
			'}';
	}
}

package com.internousdev.whisker.dto;

import java.sql.Date;

import com.internousdev.whisker.util.InputChecker;

public class TweetDTO {

	private int id;					// ID
	private int userId;				// ユーザーID
	private String content;			// 内容
	private int likeCount;			// いいねの数
	private Date createdAt;			// 作成日
	private Date updatedAt;			// 更新日

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public String getEscapeContent() {
		return InputChecker.htmlEscape(content);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

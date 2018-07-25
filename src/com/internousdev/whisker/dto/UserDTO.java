package com.internousdev.whisker.dto;

import java.sql.Date;

public class UserDTO {

	private int id;						// ID
	private String loginId;				// ログインID
	private String password;			// パスワード
	private String name;				// 表示名
	private String introductions;		// 紹介文
	private int logined;				// ログインフラグ
	private Date createdAt;				// 作成日
	private Date updatedAt;				// 更新日

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroductions() {
		return introductions;
	}

	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}


	public int getLogined() {
		return logined;
	}

	public void setLogined(int logined) {
		this.logined = logined;
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
}

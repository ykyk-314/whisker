package com.internousdev.whisker.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public String getPhotoPath() {
		return "./images/users/" + id + "/photo.png";
	}

	public static UserDTO parseDto(ResultSet resultSet) throws SQLException {
		UserDTO result = new UserDTO();
		result.setId(resultSet.getInt("id"));
		result.setLoginId(resultSet.getString("login_id"));
		result.setPassword(resultSet.getString("password"));
		result.setName(resultSet.getString("name"));
		result.setIntroductions(resultSet.getString("introductions"));
		result.setLogined(resultSet.getInt("logined"));
		result.setCreatedAt(resultSet.getDate("created_at"));
		result.setUpdatedAt(resultSet.getDate("updated_at"));
		return result;
	}
}

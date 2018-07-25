package com.internousdev.whisker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.whisker.dto.SignupDTO;
import com.internousdev.whisker.util.DBConnector;

public class SignupDAO {

	// ユーザー情報を登録
	public boolean insert(SignupDTO dto){

		Connection connection = DBConnector.getConnection();

		String sql = "INSERT INTO users(login_id, password, name, created_at, updated_at) VALUES(?,?,?,now(),now())";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getLoginId());
			preparedStatement.setString(2, dto.getPassword());
			preparedStatement.setString(3, dto.getName());

			result = preparedStatement.executeUpdate() > 0;

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	// 指定のログインIDが登録済みか調べる
	public boolean existsLoginId(String loginId){

		Connection connection = DBConnector.getConnection();

		String sql = "SELECT login_id FROM users WHERE login_id = ?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				result = true;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}
}

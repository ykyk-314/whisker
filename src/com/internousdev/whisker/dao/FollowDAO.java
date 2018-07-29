package com.internousdev.whisker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.DBConnector;

public class FollowDAO {

	public List<UserDTO> selectUser(int userId){
		Connection connection = DBConnector.getConnection();
		String sql = "SELECT u.id, u.name, u.introductions FROM follows f LEFT JOIN users u ON f.target_user_id = u.id WHERE f.user_id=?";

		List<UserDTO> result = new ArrayList<UserDTO>();

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);

			System.out.println(preparedStatement.toString());
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				UserDTO dto = new UserDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setName(resultSet.getString("name"));
				dto.setIntroductions(resultSet.getString("introductions"));

				result.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
			result = null;
		}

		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	/*
	userIdがtargetUserIdをフォローしているか
	*/
	public boolean isFollowing(int userId,int targetUserId){
		Connection connection = DBConnector.getConnection();

		String sql = "SELECT id FROM follows WHERE user_id=? AND target_user_id=?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, targetUserId);

			System.out.println(preparedStatement.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
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


	/*
	フォロー
	*/
	public boolean insert(int userId,int targetUserId){

		Connection connection = DBConnector.getConnection();

		String sql = "INSERT INTO follows(user_id, target_user_id, created_at, updated_at) VALUES(?,?,now(),now())";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, targetUserId);

			System.out.println(preparedStatement.toString());
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

	/*
	フォロー解除
	*/
	public boolean delete(int userId,int targetUserId){

		Connection connection = DBConnector.getConnection();
		String sql = "DELETE FROM follows WHERE user_id = ? AND target_user_id = ?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, targetUserId);

			System.out.println(preparedStatement.toString());
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
}

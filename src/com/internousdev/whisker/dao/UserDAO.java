package com.internousdev.whisker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.whisker.dto.UserDTO;
import com.internousdev.whisker.util.DBConnector;

public class UserDAO {

	/*
	 * ログインID(login_id)が一致するレコードがあるか
	 */
	public boolean exists(String loginId){

		Connection connection = DBConnector.getConnection();

		String sql = "SELECT id FROM users WHERE login_id = ?";

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

	/*
	 * ログインID(login_id)とパスワード(password)が一致するレコードがあるか
	 */
	public boolean exists(String loginId, String password){

		Connection connection = DBConnector.getConnection();

		String sql = "SELECT id FROM users WHERE login_id = ? AND password = ?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement.toString());

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

	/*
	 * ログイン
	 * ログインID(login_id)とパスワード(password)が一致したレコードのログインフラグ(logined)を1にする
	 */
	public boolean login(String loginId, String password){

		System.out.println("login");
		Connection connection = DBConnector.getConnection();

		String sql= "UPDATE users SET logined = 1 WHERE login_Id = ? AND password = ?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement.toString());

			result = preparedStatement.executeUpdate() > 0;

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	/*
	 * ログアウト
	 * ログインID(login_id)が一致したレコードのログインフラグ(logined)を0にする
	 */
	public boolean logout(String loginId){

		Connection connection = DBConnector.getConnection();

		String sql= "UPDATE users SET logined = 0 WHERE login_Id = ?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);

			result = preparedStatement.executeUpdate() > 0;

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	public UserDTO select(String loginId, String password){

		Connection connection = DBConnector.getConnection();

		String sql= "SELECT * FROM users WHERE login_Id = ? AND password = ?";

		UserDTO result = null;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				result = toDto(resultSet);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	public UserDTO select(int userId){

		Connection connection = DBConnector.getConnection();

		String sql= "SELECT * FROM users WHERE id = ?";

		UserDTO result = null;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				result = toDto(resultSet);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	public List<UserDTO> searchByName(String name, int ignoreUserId){

		Connection connection = DBConnector.getConnection();

		String sql= "SELECT * FROM users WHERE name LIKE '%" + name + "%' AND id NOT IN (" + ignoreUserId + ")";

		List<UserDTO> result = new ArrayList<UserDTO>();

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			System.out.println(preparedStatement.toString());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				UserDTO dto = toDto(resultSet);
				result.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
			result = null;
		}

		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	public boolean update(int id, String name, String introductions) {

		System.out.println("update");
		Connection connection = DBConnector.getConnection();

		String sql= "UPDATE users SET name = ?, introductions = ? WHERE id = ?";

		boolean result = false;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, introductions);
			preparedStatement.setInt(3, id);

			System.out.println(preparedStatement.toString());
			result = preparedStatement.executeUpdate() > 0;

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	private UserDTO toDto(ResultSet resultSet) throws SQLException {
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

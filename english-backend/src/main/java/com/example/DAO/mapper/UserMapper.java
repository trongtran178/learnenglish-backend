package com.example.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.User;

public class UserMapper implements RowMapper<User>{
	public static final String BASE_SQL = "Select users.ID, users.username, users.password from users";

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("ID");
		String userName = rs.getString("Username");
		String passWord = rs.getString("Password");
		
		return new User(id, userName, passWord);
	}
}

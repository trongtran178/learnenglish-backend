package com.example.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.User_Lesson_Learned;;

public class User_Lesson_LearnedMapper implements RowMapper<User_Lesson_Learned> {

	public static final String BASE_SQL = "Select userLessonLearned.ID, userLessonLearned.userID, userLessonLearned.lessonID from User_Lesson_Learned userLessonLearned";

	@Override
	public User_Lesson_Learned mapRow(ResultSet rs, int rowNum) throws SQLException {
		int ID = rs.getInt("ID");
		int userID = rs.getInt("UserID");
		int lessonID = rs.getInt("LessonID");

		return new User_Lesson_Learned(ID, userID, lessonID);
	}

}

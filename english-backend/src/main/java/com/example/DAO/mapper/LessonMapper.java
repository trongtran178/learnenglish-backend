package com.example.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Lesson;

public class LessonMapper implements RowMapper<Lesson> {

	public static final String BASE_SQL = "Select lesson.ID, lesson.lessonName, lesson.avatar from Lesson lesson";

	@Override
	public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("ID");
		String lessonName = rs.getString("lessonName");
		String avatar = rs.getString("avatar");
		
		return new Lesson(id, lessonName, avatar);
	}

}

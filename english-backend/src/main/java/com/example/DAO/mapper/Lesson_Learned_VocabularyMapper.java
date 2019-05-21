package com.example.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Lesson_Learned_Vocabulary;

public class Lesson_Learned_VocabularyMapper implements RowMapper<Lesson_Learned_Vocabulary> {

	public static final String BASE_SQL = "Select lessonLearnedVocabualry.lessonLearnedID, lessonLearnedVocabualry.vocabularyID from Lesson_Learned_Vocabulary lessonLearnedVocabualry ";

	@Override
	public Lesson_Learned_Vocabulary mapRow(ResultSet rs, int rowNum) throws SQLException {
		int lessonLearnedID = rs.getInt("LessonLearnedID");
		int vocabularyID = rs.getInt("VocabularyID");

		return new Lesson_Learned_Vocabulary(lessonLearnedID, vocabularyID);
	}

}

package com.example.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Vocabulary;

public class VocabularyMapper implements RowMapper<Vocabulary> {

	public static final String BASE_SQL = "SELECT VOCABULARY.ID, VOCABULARY.lessonID, VOCABULARY.word, VOCABULARY.translate, VOCABULARY.image, VOCABULARY.sound, VOCABULARY.pronunciation from Vocabulary VOCABULARY ";

	@Override
	public Vocabulary mapRow(ResultSet rs, int rowNum) throws SQLException {

		int ID = rs.getInt("ID");
		int lessonID = rs.getInt("lessonID");
		String word = rs.getString("word");
		String translate = rs.getString("translate");
		String image = rs.getString("image");
		String sound = rs.getString("sound");
		String pronunciation = rs.getString("pronunciation");

		return new Vocabulary(ID, lessonID, word, translate, image, sound, pronunciation);
	}

}

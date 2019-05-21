package com.example.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.mapper.Lesson_Learned_VocabularyMapper;
import com.example.DAO.mapper.User_Lesson_LearnedMapper;
import com.example.model.Lesson_Learned_Vocabulary;

@Repository
@Transactional
public class Lesson_Learned_VocabularyDAO extends JdbcDaoSupport {

	@Autowired
	public Lesson_Learned_VocabularyDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int getLessonLearnedID() {

		return -1;
	}

	public boolean insertLearnedVocabulary(int lessonLearnedID, int vocabularyID) {

		Object[] params = { lessonLearnedID, vocabularyID };

		String sql = "insert into lesson_learned_vocabulary (LessonLearnedID, VocabularyID) values(?, ?)";

		this.getJdbcTemplate().update(sql, params);

		return false;
	}

	public boolean checkHasLearnedVocabualry(int lessonLearnedID, int vocabularyID) {

		Object[] params = { lessonLearnedID, vocabularyID };

		String sql = "select * from le sson_learned_vocabulary lessonLearnedVocabulary where lessonLearnedVocabulary.lessonLearnedID = ? and lessonLearnedVocabulary.vocabularyID = ?";
		Lesson_Learned_VocabularyMapper lessonLearnedVocabularyMapper = new Lesson_Learned_VocabularyMapper();
		List<Lesson_Learned_Vocabulary> result = this.getJdbcTemplate().query(sql, params,
				lessonLearnedVocabularyMapper);
		if (result.isEmpty()) {
			return false;
		} else
			return true;

	}

}

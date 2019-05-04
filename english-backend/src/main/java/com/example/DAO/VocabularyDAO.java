package com.example.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.mapper.VocabularyMapper;
import com.example.model.Vocabulary;

@Repository
@Transactional
public class VocabularyDAO extends JdbcDaoSupport {
	
	@Autowired
	public VocabularyDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<Vocabulary> getVocabulariesInLesson(int LessonID) {
		String sql = VocabularyMapper.BASE_SQL + " where VOCABULARY.lessonID = ? ";
		Object[] params = new Object[] { LessonID};
		try { 
			VocabularyMapper vocabularyMapper = new VocabularyMapper();
			List<Vocabulary> listVocabulary = this.getJdbcTemplate().query(sql, params, vocabularyMapper);
			return listVocabulary;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}

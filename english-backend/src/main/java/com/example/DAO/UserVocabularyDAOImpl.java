package com.example.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserVocabularyDAOImpl implements UserVocabularyDAO{
	private JdbcTemplate jdbcTemplate;

	public UserVocabularyDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void deleteVocabulary(int userid, int vocabularyid) {
		String sql = "DELETE FROM `english_page`.`user_vocabulary` WHERE (`user_id` = '"+userid+"') and (`vocabulary_id` = '"+vocabularyid+"');";
		jdbcTemplate.update(sql);
	}
	
	public void addVocabulary(int userid, int vocabularyid) {
		String sql = "INSERT INTO `english_page`.`user_vocabulary` (`user_id`, `vocabulary_id`) VALUES ('"+userid+"', '"+vocabularyid+"');\r\n" + 
				"";
		try {
			jdbcTemplate.update(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

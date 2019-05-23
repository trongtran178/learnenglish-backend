package com.example.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.mapper.UserMapper;
import com.example.DAO.mapper.VocabularyMapper;
import com.example.model.User;
import com.example.model.Vocabulary;

@Repository
@Transactional
public class UserDAO extends JdbcDaoSupport{

	
	@Autowired
	public UserDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<User> getUser(){
		String sql = UserMapper.BASE_SQL;
		Object[] params = new Object[] {};
		UserMapper userMapper = new UserMapper();
		List<User> listUser  = this.getJdbcTemplate().query(sql,  params, userMapper);
		
		return listUser;
	}
	
	public boolean checkUserLogin(String username, String password) {
		boolean check = false;
		
		String sql = UserMapper.BASE_SQL;
		Object[] params = new Object[] {};
		UserMapper userMapper = new UserMapper();
		List<User> listUser = this.getJdbcTemplate().query(sql, params, userMapper);
		if(listUser != null) {
			for(int i = 0; i < listUser.size(); i++) {
				String uname = listUser.get(i).getUserName();
				String pword = listUser.get(i).getPassWord();
				if(uname.equals(username) && pword.equals(password)) {
					check = true;
					return check;
				}
			}
		}
		return check;
	}
	
	public List<Vocabulary> getListVocabularyUSer(String username){
		String sql = "select vocabulary_id as ID, lessonID, word, translate, image, sound, pronunciation  from user_vocabulary, vocabulary, users\r\n" + 
				"where user_vocabulary.vocabulary_id = vocabulary.ID\r\n" + 
				"and user_vocabulary.user_id = users.ID\r\n" + 
				"and users.username = '" +username+ "'";
		VocabularyMapper vocabularyMapper = new VocabularyMapper();
		Object[] params = new Object[] {};
		List<Vocabulary> listVocabulary = this.getJdbcTemplate().query(sql, params, vocabularyMapper);
		
		return listVocabulary;
	}
}

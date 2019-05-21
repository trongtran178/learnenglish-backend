package com.example.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

import com.example.DAO.mapper.User_Lesson_LearnedMapper;
import com.example.model.User_Lesson_Learned;

@Repository
@Transactional
public class User_Lesson_LearnedDAO extends JdbcDaoSupport {

	@Autowired
	public User_Lesson_LearnedDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<User_Lesson_Learned> getUserLessonLearnedWithUserID(int userID) {

		String sql = User_Lesson_LearnedMapper.BASE_SQL + " where userLessonLearned.userID = ?";

		Object[] params = new Object[] { userID };
		try {

			User_Lesson_LearnedMapper userLessonLearnedMapper = new User_Lesson_LearnedMapper();
			List<User_Lesson_Learned> listUserLessonLearned = this.getJdbcTemplate().query(sql, params,
					userLessonLearnedMapper);

			return listUserLessonLearned;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean checkUserHasLearnedLesson(int userID, int lessonID) {
		String sql = User_Lesson_LearnedMapper.BASE_SQL + " where userLessonLearned.userID = ? and lessonID = ? ";
		Object[] params = new Object[] {userID, lessonID};
		try {
			User_Lesson_LearnedMapper userLessonLearnedMapper = new User_Lesson_LearnedMapper();
			User_Lesson_Learned userLessonLearned = this.getJdbcTemplate().queryForObject(sql, params, userLessonLearnedMapper);
			
			if(userLessonLearned != null) {
				return true;
			} else {
				return false;
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	public void insertLessonHasLearned(int userID, int lessonID) throws SQLException {
		Object[] params = new Object[] {userID, lessonID};
		String sql = "insert into user_lesson_learned (UserID, lessonID) values(?, ?)";
		this.getJdbcTemplate().update(sql, params);
		
	}
	
	public Integer getLessonLearnedID(int userID, int lessonID) {
		Object[] params = new Object[] {userID, lessonID};
		Integer ID = (Integer) this.getJdbcTemplate().queryForObject("select ID from User_lesson_learned userLessonLearned where userLessonLearned.UserID = ? and userLessonLearned.LessonID = ? ", params, Integer.class);
		
		return ID;
		
	}	
	
	
	

}

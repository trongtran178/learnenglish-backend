package com.example.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.mapper.LessonMapper;
import com.example.model.Lesson;

@Repository
@Transactional
public class LessonDAO extends JdbcDaoSupport {

	@Autowired
	public LessonDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Lesson> getLessons() {
		String sql = LessonMapper.BASE_SQL;
		Object[] params = new Object[] {};
		LessonMapper lessonMapper = new LessonMapper();
		List<Lesson> listLesson = this.getJdbcTemplate().query(sql, params, lessonMapper);
		
		return listLesson;
	}

}

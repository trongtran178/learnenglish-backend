package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.LessonDAO;
import com.example.DAO.Lesson_Learned_VocabularyDAO;
import com.example.DAO.UserDAO;
import com.example.DAO.User_Lesson_LearnedDAO;
import com.example.DAO.VocabularyDAO;
import com.example.form.SaveLearnedWordForm;
import com.example.model.Lesson;
import com.example.model.Lesson_Learned_Vocabulary;
import com.example.model.User;
import com.example.model.User_Lesson_Learned;
import com.example.model.Vocabulary;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@RestController
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainRestController {

	@Autowired
	private LessonDAO lessonDAO;

	@Autowired
	private VocabularyDAO vocabularyDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User_Lesson_LearnedDAO userLessonLearnedDAO;

	@Autowired
	private Lesson_Learned_VocabularyDAO lessonLearnedVocabularyDAO;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/lessons", //
			method = RequestMethod.GET, //
			produces = { "application/json" })
	@ResponseBody
	public List<Lesson> getLessons() {
		List<Lesson> list = lessonDAO.getLessons();
		return list;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/vocabularies/{lessonID}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<Vocabulary> getVocabularyInLesson(@PathVariable("lessonID") int lessonID) {
		return vocabularyDAO.getVocabulariesInLesson(lessonID);
	}

	@PostMapping("/login/checklogin")
	@ResponseBody
	public int checkLogin(@RequestBody User user, HttpSession session) {
		int userID = -1;
		String uname = user.getUserName();
		String pword = user.getPassWord();
		session.setAttribute("userLogin", user);
		userID = userDAO.checkUserLogin(uname, pword);
		return userID;
	}

	@RequestMapping(value = "/vocabulariesChallenge", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<Vocabulary> getVocabulariesToChallenge() {
		return vocabularyDAO.getRandomVocabulary();
	}

	@RequestMapping(value = "/test/{lessonLearnedID}/{vocabularyID}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public boolean test(@PathVariable("lessonLearnedID") int lessonLearnedID, @PathVariable("vocabularyID") int vocabularyID) {
		
		return this.lessonLearnedVocabularyDAO.checkHasLearnedVocabualry(lessonLearnedID, vocabularyID);

	}

	@RequestMapping(value = "/saveLearningProcess", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public boolean saveLearningProcess(@RequestBody SaveLearnedWordForm saveLearnedWordForm) throws SQLException {

		System.out.println(saveLearnedWordForm.getUserID());

		boolean checkUserLearnedLesson = false;

		checkUserLearnedLesson = userLessonLearnedDAO.checkUserHasLearnedLesson(saveLearnedWordForm.getUserID(),
				saveLearnedWordForm.getLessonID());

		// user đã học bài này
		if (checkUserLearnedLesson) {
			int userLessonLearnedID = userLessonLearnedDAO.getLessonLearnedID(saveLearnedWordForm.getUserID(),
					saveLearnedWordForm.getLessonID());

			boolean checkUserHasLearnedVocabulary = this.lessonLearnedVocabularyDAO
					.checkHasLearnedVocabualry(userLessonLearnedID, saveLearnedWordForm.getVocabularyID());

			if (checkUserHasLearnedVocabulary == false) {
				this.lessonLearnedVocabularyDAO.insertLearnedVocabulary(userLessonLearnedID,
						saveLearnedWordForm.getVocabularyID());
			}

			return true;
		}
		// user chưa học bài này
		else {
			userLessonLearnedDAO.insertLessonHasLearned(saveLearnedWordForm.getUserID(),
					saveLearnedWordForm.getLessonID());

			int userLessonLearnedID = userLessonLearnedDAO.getLessonLearnedID(saveLearnedWordForm.getUserID(),
					saveLearnedWordForm.getLessonID());

			boolean checkUserHasLearnedVocabulary = this.lessonLearnedVocabularyDAO
					.checkHasLearnedVocabualry(userLessonLearnedID, saveLearnedWordForm.getVocabularyID());

			if (checkUserHasLearnedVocabulary == false) {
				this.lessonLearnedVocabularyDAO.insertLearnedVocabulary(userLessonLearnedID,
						saveLearnedWordForm.getVocabularyID());
			}

			return true;
		}
	}

}

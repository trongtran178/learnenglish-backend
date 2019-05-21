package com.example.form;

public class SaveLearnedWordForm {

	private int userID;
	private int lessonID;
	private int vocabularyID;

	public SaveLearnedWordForm() {
		super();
	}

	public SaveLearnedWordForm(int userID, int lessonID, int vocabularyID) {
		super();
		this.userID = userID;
		this.lessonID = lessonID;
		this.vocabularyID = vocabularyID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getLessonID() {
		return lessonID;
	}

	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}

	public int getVocabularyID() {
		return vocabularyID;
	}

	public void setVocabularyID(int vocabularyID) {
		this.vocabularyID = vocabularyID;
	}

}

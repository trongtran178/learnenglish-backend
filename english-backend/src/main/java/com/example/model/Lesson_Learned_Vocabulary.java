package com.example.model;

public class Lesson_Learned_Vocabulary {
	private int lessonLearnedID; // references user_lesson_learned ID
	private int vocabularyID;

	public Lesson_Learned_Vocabulary(int lessonLearnedID, int vocabularyID) {
		super();
		this.lessonLearnedID = lessonLearnedID;
		this.vocabularyID = vocabularyID;
	}

	public int getLessonLearnedID() {
		return lessonLearnedID;
	}

	public void setLessonLearnedID(int lessonLearnedID) {
		this.lessonLearnedID = lessonLearnedID;
	}

	public int getVocabularyID() {
		return vocabularyID;
	}

	public void setVocabularyID(int vocabularyID) {
		this.vocabularyID = vocabularyID;
	}

}

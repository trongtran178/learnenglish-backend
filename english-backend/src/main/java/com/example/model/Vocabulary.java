package com.example.model;

public class Vocabulary {
	
	private int ID;
	private int lessonID;
	private String word;
	private String translate;
	private String sound;
	private String pronunciation;

	public Vocabulary(int ID, int lessonID, String word, String translate, String sound, String pronunciation) {
		super();
		this.ID = ID;
		this.lessonID = lessonID;
		this.word = word;
		this.translate = translate;
		this.sound = sound;
		this.pronunciation = pronunciation;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getLessonID() {
		return lessonID;
	}

	public void setLessonID(int lessonID) {
		this.lessonID = lessonID;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}

}

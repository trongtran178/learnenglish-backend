package com.example.model;

public class Vocabulary {

	private int ID;
	private int lessonID;
	private String word;
	private String translate;
	private String image;
	private String sound;
	private String pronunciation;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Vocabulary(int iD, int lessonID, String word, String translate, String image, String sound,
			String pronunciation) {
		super();
		ID = iD;
		this.lessonID = lessonID;
		this.word = word;
		this.translate = translate;
		this.image = image;
		this.sound = sound;
		this.pronunciation = pronunciation;
	}

	public Vocabulary() {
		super();
	}

}

package com.example.model;

public class Lesson {

	private int ID;
	private String lessonName;
	private String avatar;

	public Lesson(int iD, String lessonName, String avatar) {
		super();
		ID = iD;
		this.lessonName = lessonName;
		this.avatar = avatar;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}

package com.example.model;

public class User_Lesson_Learned {

	private int ID;
	private int userID;
	private int lessonID;

	public User_Lesson_Learned(int iD, int userID, int lessonID) {
		super();
		ID = iD;
		this.userID = userID;
		this.lessonID = lessonID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

}

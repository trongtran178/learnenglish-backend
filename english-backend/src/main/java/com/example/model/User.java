package com.example.model;

public class User {
	private int ID;
	private String userName;
	private String passWord;
	public User(int iD, String userName, String passWord) {
		super();
		ID = iD;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}

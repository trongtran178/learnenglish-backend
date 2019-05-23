package com.example.model;

public class UserVocabulary {
	private int userid;
	private int vocabularyid;
	private String purpose;
	public UserVocabulary(int userid, int vocabularyid, String purpose) {
		super();
		this.userid = userid;
		this.vocabularyid = vocabularyid;
		this.purpose = purpose;
	}
	public UserVocabulary() {
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getVocabularyid() {
		return vocabularyid;
	}
	public void setVocabularyid(int vocabularyid) {
		this.vocabularyid = vocabularyid;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}

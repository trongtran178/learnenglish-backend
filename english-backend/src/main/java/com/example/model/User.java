package com.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class User {
	private int ID;
	private String userName;
	private String passWord;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_vocabulary",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
	        inverseJoinColumns = @JoinColumn(name = "vocabulary_id", referencedColumnName = "ID"))
	
	private Set<Vocabulary> vocabularies = new HashSet<>();
	
	public Set<Vocabulary> getVocabularies() {
		return vocabularies;
	}


	public void setVocabularies(Set<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}

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

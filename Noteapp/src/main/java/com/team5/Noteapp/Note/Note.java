package com.team5.Noteapp.Note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {
	
    @Id
    @GeneratedValue
	private int id;
    
    @Column(nullable = false)
    private int userId;
    
    @Column(nullable = false)
	private String title;
    
    @Column(nullable = false)
	private String content;
	
    public Note() {
    	
    }

	public Note(int id, int userId, String title, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

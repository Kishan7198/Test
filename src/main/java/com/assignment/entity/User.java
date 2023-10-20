package com.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "comment_from", length = 25, nullable = false)
    private String commentFrom;

    @Column(name = "comment_to", length = 25, nullable = false)
    private String commentTo;

	
    
    
    public User(Long userId, String commentFrom, String commentTo) {
		super();
		this.userId = userId;
		this.commentFrom = commentFrom;
		this.commentTo = commentTo;
	}
    
    

	public User() {
		
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCommentFrom() {
		return commentFrom;
	}

	public void setCommentFrom(String commentFrom) {
		this.commentFrom = commentFrom;
	}

	public String getCommentTo() {
		return commentTo;
	}

	public void setCommentTo(String commentTo) {
		this.commentTo = commentTo;
	}

    
}

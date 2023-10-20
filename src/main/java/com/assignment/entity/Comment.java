package com.assignment.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "message", length = 255, nullable = false)
    private String message;

    @Column(name = "comment_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDateTime;

    @ManyToOne
    @JoinColumn(name = "posted_by_user_id")
    private User postedByUser;

	
    
    
    
    public Comment(Long commentId, String message, Date commentDateTime, User postedByUser) {
		super();
		this.commentId = commentId;
		this.message = message;
		this.commentDateTime = commentDateTime;
		this.postedByUser = postedByUser;
	}
    
    

	public Comment() {
		
	}



	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCommentDateTime() {
		return commentDateTime;
	}

	public void setCommentDateTime(Date commentDateTime) {
		this.commentDateTime = commentDateTime;
	}

	public User getPostedByUser() {
		return postedByUser;
	}

	public void setPostedByUser(User postedByUser) {
		this.postedByUser = postedByUser;
	}

    
}

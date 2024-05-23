package com.jpa.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class Comments implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  Comment_ID;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id")
	@JsonBackReference
	private Taskinfo taskinfo;
	
	
	private String  Comment;
	
	private String  CommentedBy;
	
	private String Created;
	
	private String   flag;

	public int getComment_ID() {
		return Comment_ID;
	}

	public void setComment_ID(int comment_ID) {
		Comment_ID = comment_ID;
	}

	public Taskinfo getTaskinfo() {
		return taskinfo;
	}

	public void setTaskinfo(Taskinfo taskinfo) {
		this.taskinfo = taskinfo;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getCommentedBy() {
		return CommentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		CommentedBy = commentedBy;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
	
}

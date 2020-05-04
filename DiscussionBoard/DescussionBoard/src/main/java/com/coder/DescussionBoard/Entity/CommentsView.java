package com.coder.DescussionBoard.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments_view")
public class CommentsView {

	@Id
	private int id;
	private String description;
	private Date date;
	private Boolean active;
	private int issuesId;
	
	public CommentsView() {
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public Boolean getActive() {
		return active;
	}

	public int getIssuesId() {
		return issuesId;
	}
	
	
}

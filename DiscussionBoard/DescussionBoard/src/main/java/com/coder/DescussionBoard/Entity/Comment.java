package com.coder.DescussionBoard.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comments")
public class Comment {

 	@Id
	private int id;
    @Column(name="description")
 	private String description;
 	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    @Column(name="date")
	private Date date;
    @Column(name="active")
 	private boolean active;
	@ManyToOne(fetch = FetchType.EAGER)//(cascade=CascadeType.ALL, fetch = FetchType.EAGER) 
    @JoinColumn(name = "issues_id")
  	//@JsonIgnore
	//@JsonManagedReference
	private Issues issues;
	
	public Comment() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    Instant instant2 = timestamp.toInstant();
		this.date = instant2;
	}*/
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Issues getIssues() {
		return issues;
	}

	public void setIssues(Issues issues) {
		this.issues = issues;
	}
}

package com.coder.DescussionBoard.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="comments")
public class Comments implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
    @Column(name="description")
 	private String description;
 	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    @Column(name="date")
	private Date date;
    @Column(name="active")
 	private boolean active;
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER) 
    @JoinColumn(name = "issues_id")
  	@JsonIgnore
 	private Issues issues;
	
	public Comments() {
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

package com.healthcare.Patient.Managment.System.configuration;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
public class AuthoritiesId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="username")
	private String userName;
	@Column(name="authority")
	private String authorities;
	
	
	public AuthoritiesId() {
		super();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getAuthorities() {
		return authorities;
	}


	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	
}

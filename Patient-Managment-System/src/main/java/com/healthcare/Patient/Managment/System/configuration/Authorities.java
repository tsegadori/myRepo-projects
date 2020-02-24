package com.healthcare.Patient.Managment.System.configuration;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorities {

	@EmbeddedId
	private AuthoritiesId authoritiesId;
	@MapsId("username") 
	@JoinColumn(name = "username", referencedColumnName = "username")
 	@ManyToOne
	private AppUser appUser;
	
	
	public Authorities() {
		super();
	}


	public AuthoritiesId getAuthoritiesId() {
		return authoritiesId;
	}


	public void setAuthoritiesId(AuthoritiesId authoritiesId) {
		this.authoritiesId = authoritiesId;
	}


	public AppUser getAppuser() {
		return appUser;
	}


	public void setAppuser(AppUser appuser) {
		this.appUser = appuser;
	}
	
	
}

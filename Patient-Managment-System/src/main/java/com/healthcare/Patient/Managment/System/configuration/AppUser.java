package com.healthcare.Patient.Managment.System.configuration;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="app_user")
public class AppUser {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
    private String encrytedPassword;
	@Column(name="enabled")
    private int enabled;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="authoritiesId.userName")
	List<Authorities> authorities;
    @Transient
    private String roleOne;
    @Transient
    private String roleTwo;
    
    public AppUser() {
    }
 
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AppUser(String userName, String encrytedPassword) {
        this.username = userName;
        this.encrytedPassword = encrytedPassword;
    }
 
    public String getUserName() {
        return username;
    }
 
    public void setUserName(String userName) {
        this.username = userName;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
 
    
    public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRoleOne() {
		return roleOne;
	}

	public void setRoleOne(String roleOne) {
		this.roleOne = roleOne;
	}

	public String getRoleTwo() {
		return roleTwo;
	}

	public void setRoleTwo(String roleTwo) {
		this.roleTwo = roleTwo;
	}

	
	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities.add(authorities);
	}

	@Override
    public String toString() {
        return this.username + "/" + this.encrytedPassword;
    }
 
}

package com.healthcare.Patient.Managment.System.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.healthcare.Patient.Managment.System.configuration.AppUser;
import com.healthcare.Patient.Managment.System.configuration.Authorities;
import com.healthcare.Patient.Managment.System.configuration.AuthoritiesId;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	EntityManager em;
	
	  public void searchAppUser(AppUser newUser, Model newModel) {
		AppUser user = new AppUser();
        TypedQuery<AppUser> userQuery = em.createQuery("Select u From AppUser u Where u.username=?1", AppUser.class);
    	user=userQuery.setParameter(1, newUser.getUsername()).getSingleResult();
    	if(user.getAuthorities().size()==1) {
        	user.setRoleOne(user.getAuthorities().get(0).getAuthoritiesId().getAuthorities());
        	user.setRoleTwo("");
        }
        if(user.getAuthorities().size()==2) {
        	user.setRoleOne(user.getAuthorities().get(0).getAuthoritiesId().getAuthorities());
        	user.setRoleTwo(user.getAuthorities().get(1).getAuthoritiesId().getAuthorities());
        }
        int x = user.getEnabled();
        System.out.println("---->"+x);
    	newModel.addAttribute("user", user);
	}
	  
	  public void updateAppUser(AppUser newUser) {
			System.out.println(newUser.getRoleOne());
			AuthoritiesId authoritiesid = new AuthoritiesId();
			Authorities authorities = new Authorities();

	    	if(newUser.getRoleOne()!=null) {
	    		authoritiesid.setUserName(newUser.getUsername());
	    		authoritiesid.setAuthorities(newUser.getRoleOne());
	        }
	        if(newUser.getRoleTwo()!=null) {
	    		authoritiesid.setUserName(newUser.getUsername());
	    		authoritiesid.setAuthorities(newUser.getRoleTwo());
	    	}
			authorities.setAuthoritiesId(authoritiesid);
	    	em.merge(newUser);
	    	em.merge(authorities);
		}

	@Override
	public void addNewUser(AppUser newUser) {
		String password = newUser.getEncrytedPassword();
		newUser.setEncrytedPassword(passwordEncoder(password));
		em.persist(newUser); 
 		}    
	
	public String passwordEncoder(String password) {
		String encoded=new BCryptPasswordEncoder().encode(password);
		return encoded;
	}
		  
    public void addAuthorities(AppUser newUser) {
	Authorities authorities = new Authorities();
	AuthoritiesId authoritiesid = new AuthoritiesId();
	String tempUsername = newUser.getUsername(); 

		if(newUser.getRoleOne()!=null) {
			if(newUser.getRoleOne().equalsIgnoreCase("USER")) {
				authoritiesid.setUserName(tempUsername);
				authoritiesid.setAuthorities("ROLE_USER");
				authorities.setAuthoritiesId(authoritiesid);
				em.persist(authorities);
			}
			if(newUser.getRoleOne().equalsIgnoreCase("ADMIN")) {
				authoritiesid.setUserName(tempUsername);
				authoritiesid.setAuthorities("ROLE_ADMIN");
				authorities.setAuthoritiesId(authoritiesid);
				em.persist(authorities);
				}
		}
		if(newUser.getRoleTwo()!=null) {
			if(newUser.getRoleTwo().equalsIgnoreCase("USER")) {
				authoritiesid.setUserName(tempUsername);
				authoritiesid.setAuthorities("ROLE_USER");
				authorities.setAuthoritiesId(authoritiesid);
				em.persist(authorities);
			}
			if(newUser.getRoleTwo().equalsIgnoreCase("ADMIN")) {
				authoritiesid.setUserName(tempUsername);
				authoritiesid.setAuthorities("ROLE_ADMIN");
				authorities.setAuthoritiesId(authoritiesid);
				em.persist(authorities);
				}
		}
    }
}

package com.healthcare.Patient.Managment.System.dao;

import org.springframework.ui.Model;

import com.healthcare.Patient.Managment.System.configuration.AppUser;

public interface UserDao {
	  void searchAppUser(AppUser newUser, Model newModel);
	  void updateAppUser(AppUser newUser);
	  void addNewUser(AppUser newUser);
	  String passwordEncoder(String password);
	  void addAuthorities(AppUser newUser);
	  
}

package com.healthcare.Patient.Managment.System.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.healthcare.Patient.Managment.System.configuration.AppUser;
import com.healthcare.Patient.Managment.System.configuration.WebUtils;
import com.healthcare.Patient.Managment.System.service.ServiceDao;

@Controller
public class SecurityController {
	
	@Autowired
 	ServiceDao serviceDao;
	
	@RequestMapping(value = { "/", "/welcome","/pms" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Patients Managment Application");
        model.addAttribute("message", "Patients Managment Home page");
        return "welcomePage";
    }
 
	@RequestMapping(value = "/admin/updateUser", method = RequestMethod.POST)
    public String updateProcessPage(@ModelAttribute("newUser") AppUser user) {
      return "userProcessSuccessPage";
    }
	
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "adminPage";
    }
 /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "loginPage";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
 */
    @RequestMapping(value = "/pms/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        return "userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
    
    @RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
    public String addNewAppUserPage(Model model) {
        AppUser newUser = new AppUser();
        model.addAttribute("newUser", newUser);
        return "addUserPage";
    }
 
    @RequestMapping(value = "/admin/SearchUser", method = RequestMethod.GET)
    public String SearchUserPage(Model model) {
        AppUser newUser = new AppUser();
        model.addAttribute("newUser", newUser);
        return "SearchUserPage";
    }
    
    @RequestMapping(value = "/admin/UpdateUser", method = RequestMethod.GET)
    @Transactional(propagation=Propagation.REQUIRED)    
    public String SearchResult(@ModelAttribute("newUser") AppUser newUser, Model newModel) {
    	serviceDao.searchAppUser(newUser, newModel);
        return "updateUserPage";
    }

	
    
    @RequestMapping(value = "admin/updateUserProcessSuccessPage", method = RequestMethod.POST)
    @Transactional(propagation=Propagation.REQUIRED, noRollbackFor=Exception.class)
    public String updateProcessUserPage(@ModelAttribute("user") AppUser newUser) {
    	serviceDao.updateAppUser(newUser);
    	return "userProcessSuccessPage";
    	}

	
    
    @RequestMapping(value = "admin/userProcessSuccessPage", method = RequestMethod.POST)
    @Transactional(propagation=Propagation.REQUIRED, noRollbackFor=Exception.class)
    public String processNewAppUserPage(@ModelAttribute("newUser") AppUser newUser) {
    	serviceDao.addNewUser(newUser);
    	System.out.println(newUser.getUsername());
         
    	if(newUser.getUsername()!=null) {
    	   try{
    		   serviceDao.addAuthorities(newUser);
    	}
    	catch(Exception e) {
    		e.getStackTrace();
    	}
   	}
     return "userProcessSuccessPage";
    }
}

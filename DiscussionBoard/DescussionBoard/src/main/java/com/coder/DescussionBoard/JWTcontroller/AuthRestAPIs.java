package com.coder.DescussionBoard.JWTcontroller;

import java.util.HashSet;
import java.util.Set;
 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.DescussionBoard.JWTmodel.User;
import com.coder.DescussionBoard.JWTmodel.Role;
import com.coder.DescussionBoard.JWTmodel.RoleName;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
//@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    com.coder.DescussionBoard.JWTrepository.UserRepository userRepository;

    @Autowired
    com.coder.DescussionBoard.JWTrepository.RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    com.coder.DescussionBoard.JWTsecurity.jwt.JwtProvider jwtProvider;
    
   // ExistingUser user = new ExistingUser();
    
    @PostMapping("/api/auth/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody ExistingUser user) {
    
    	Authentication authentication = authenticationManager.authenticate(
        		 new UsernamePasswordAuthenticationToken(
                         user.getEmail(),
                         user.getPassword()
                 )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = com.coder.DescussionBoard.JWTsecurity.jwt.JwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new com.coder.DescussionBoard.JWTmessageResponse.JwtResponse(jwt));
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody com.coder.DescussionBoard.JWTmessageRequest.SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<com.coder.DescussionBoard.JWTmodel.Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "pm":
	            	Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	            	roles.add(pmRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        		roles.add(userRole);        			
        	}
        });
        
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}

class ExistingUser{
	private String email;
	private String password;
	
	public ExistingUser() {
 	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
package com.healthcare.Patient.Managment.System.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	@Autowired
    UserDetailsServiceImpl userDetailsService;
	
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	  }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
		  http.csrf().disable();
		  http
          //HTTP Basic authentication
          .httpBasic()
          .and()
          .authorizeRequests()
          .antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
          .antMatchers(HttpMethod.POST, "/api").hasRole("USER")
          .antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")
          .antMatchers(HttpMethod.PATCH, "/api/**").hasRole("USER")
          .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER")
          .and().formLogin().disable();
 		 // Authenticate users with HTTP basic authentication 
		  http.authorizeRequests().antMatchers("/", "/login","/pms/**").authenticated().anyRequest().permitAll().and()
			.authorizeRequests().antMatchers("/admin/**").authenticated().anyRequest()
			.hasAnyRole("ADMIN").and().formLogin().permitAll();
		  }
	  
	  @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
}

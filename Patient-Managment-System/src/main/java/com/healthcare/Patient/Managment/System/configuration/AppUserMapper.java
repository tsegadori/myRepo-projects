package com.healthcare.Patient.Managment.System.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AppUserMapper implements RowMapper<AppUser>{
	public static final String BASE_SQL //
    = "Select u.username, u.password From App_User u ";

public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

	String userName = rs.getString("Username");
	String encrytedPassword = rs.getString("password");

	return new AppUser(userName, encrytedPassword);
}

}

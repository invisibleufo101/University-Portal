package com.university.service;

import java.util.Base64;

import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;
import com.university.util.PasswordUtil;


public class LoginService {

	public User getLoginUser(String schoolId) {
		
		User loginUser = new QueryBuilder(User.class)
									.select(
										"users.*", 
										"userRoles.roleName as roleName",  
										"majors.majorName as majorName")
									.join("userRoles", "id", "roleId")
									.join("majors", "id", "majorId")
										.where("schoolId", schoolId)
									.get();
		return loginUser;
	}
	
	public boolean verifyPassword(String password, String hashedPassword, byte[] salt) {
		String hashedInput = PasswordUtil.hashPassword(password, salt);
		return hashedInput.equals(hashedPassword);
	}

}

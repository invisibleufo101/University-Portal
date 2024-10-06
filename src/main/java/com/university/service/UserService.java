package com.university.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import com.university.exception.InvalidSchoolIdGenerationException;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;
import com.university.util.PasswordUtil;


public class UserService {

	// Memory leak issues?
//	private QueryBuilder queryBuilder = new QueryBuilder(User.class);
	
	// browse users
	public List<User> browseUsers(){
		QueryBuilder queryBuilder = new QueryBuilder(User.class);
		List<User> users = queryBuilder.select("user_roles.role_name as role_name", "schoolId", "name", "majors.major_name as major_name")
				  .join("majors", "id", "majorId")
				  .join("user_roles", "id", "roleId")
				  .orderBy("users.id", "ASC")
				  .getAll();
		
		return users;
	}
	
	// read user
	public User readUser(String schoolId) {
		QueryBuilder queryBuilder = new QueryBuilder(User.class);
		User readUser = queryBuilder.select("user_roles.role_name as role_name", "users.role_id", "schoolId", "name", "email", "phoneNumber", "users.major_id as major_id", "majors.major_name as major_name", "birthDate")
				  .join("majors", "id", "majorId")
				  .join("user_roles", "id", "roleId")
				  .where("schoolId", schoolId)
				  .get();
		
		return readUser;
	}
	
	
	// edit user
	public void editUser(String schoolId, Long editedMajor) {
		QueryBuilder queryBuilder = new QueryBuilder(User.class);
		queryBuilder.update().set("majorId", editedMajor).where("schoolId", schoolId).execute();
	}
	
	/**
	 * 새로운 사용자 계정을 생성합니다.
	 * 
	 * @param user 계정 등록 페이지에서 받은 사용자 등록 정보
	 */
	public void addUser(User newUser) {
		
		System.out.println("New Password:" + newUser.getPassword());
		
		// 사용자의 학번/교번을 자동 생성합니다.
		String schoolId = generateSchoolId(newUser);
		newUser.setField("schoolId", schoolId);
		
		// 초기 비밀번호 값을 생년월일 6자리 (yyMMdd)으로 만듭니다.
		String password = setBirthDateFormat(newUser);		
		
		// 비밀번호 값을 hashing하고 사용했던 salt도 같이 데이터베이스에 넣어줍니다.
		byte[] salt = PasswordUtil.generateSalt();
		String hashedPassword = PasswordUtil.hashPassword((String) password, salt);
		newUser.setField("salt", salt);
		newUser.setField("password", hashedPassword);
		
		QueryBuilder queryBuilder = new QueryBuilder(User.class);
		queryBuilder.insert("roleId", "majorId", "schoolId", "name", "email", "phoneNumber", "password", "salt", "birthDate")
					.values(newUser.getRoleId(), newUser.getMajorId(), newUser.getSchoolId(), newUser.getName(), newUser.getEmail(), newUser.getPhoneNumber(), newUser.getPassword(), newUser.getSalt(), newUser.getBirthDate())
					.execute();
	}
	
	
	public List<User> getProfessors(){
		return new QueryBuilder(User.class).select("id", "name").where("roleId", 3).getAll();
	}
	/**
	 * 새 사용자 계정을 만들 때 생년월일 (yyMMdd) 형식으로 만들어지게 하는 메소드입니다.
	 * 
	 * @param user 새 계정 사용자의 정보 
	 */
	private String setBirthDateFormat(User user) {
		Date sqlDate = (Date) user.getField("birthDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return sdf.format(sqlDate);
	}
	
	/**
	 * 학번/교번은 현재 년도(yyyy) + 계정 역할 (role_id) + 학과 id (major_id) + 해당 학과에 있는 사람 수로 
	 * 결정이 됩니다.
	 *  
	 * 총 10자리의 숫자를 학번으로 생성합니다.
	 *
	 * @param vo 새 계정 사용자의 정보
	 * @throws Exception 
	 */
	private String generateSchoolId(User user) {	
		QueryBuilder queryBuilder = new QueryBuilder(User.class);
		User userCntInMajor = queryBuilder.select("count(*) as cnt").where("majorId", user.getMajorId()).get();
		
		// Convert all criteria to String
		String registeredYear = String.valueOf(LocalDate.now().getYear());
		String roleId = String.format("%02d", user.getRoleId());
		String majorId = String.format("%02d", user.getMajorId());
		String numberOfPeopleInMajor = String.format("%02d", userCntInMajor.getCnt());
		
		String generatedSchoolId = registeredYear + roleId + majorId + numberOfPeopleInMajor;
		
		if (generatedSchoolId.length() != 10) {
			throw new InvalidSchoolIdGenerationException();
		}

		return generatedSchoolId;
	}
}

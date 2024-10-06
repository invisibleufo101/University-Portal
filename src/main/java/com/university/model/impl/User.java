package com.university.model.impl;

import java.sql.Date;

import com.university.model.Model;
import lombok.ToString;
import lombok.Getter;

@Getter
@ToString
public class User extends Model {

	private Long id;            // 행 id
	private Long roleId;        // 사용자 계정 구분 (Student, Professor, Admin)
	private Long majorId;       // 사용자가 속한 학과(major)
	private String schoolId;    // 사용자가 부여받은 id (학생일 경우 학번, 교직원일 경우 교번)
	private String name;        // 이름
	private String email;       // 이메일
	private String phoneNumber; // 전화번호
	private String password;    // 비밀번호
	private byte[] salt;        // 로그인할 때 필요한 salt
	private Date birthDate;
	
	private String roleName;    // users_role 테이블과 JOIN할 때 쓰는 사용자 역할 (Admin, Professor, Student)
	private String majorName;   // majors 테이블과 JOIN할 때 쓰는 사용자 소속학과 
	
	private Long cnt;            // 학과에 몇명 있는지 확인할 때 쓰는 필드
}

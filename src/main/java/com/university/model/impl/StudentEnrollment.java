package com.university.model.impl;

import lombok.Getter;
import lombok.ToString;

import com.university.model.Model;

@Getter
@ToString
public class StudentEnrollment extends Model {

	private Long id;           // 행 id
	private Long enrollmentId; // 수강한 교과목 id
	private Long studentId;    // 수강하는 학생의 users(id)
	private Long cnt;          // 수강하는 학생의 수
	
	// users 테이블과 JOIN할 때 쓰는 항목들
	private String schoolId;
	private String name;
	
	// student_grades 테이블과 JOIN할 때 쓰는 항목
	private String grade;
	
	public StudentEnrollment() {
		super("student_enrollments");
	}
}

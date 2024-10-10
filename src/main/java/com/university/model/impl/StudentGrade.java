package com.university.model.impl;

import com.university.model.Model;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StudentGrade extends Model {

	private Long id; // 행 id
	private Long studentEnrollmentId; // 해당 성적을 받는 학생의 수강 id
	private String grade; // 성적 (A+, A0, A-, B+, B0, B-, C+, C0, C-, D+, D0, D-, F)
	
	// courses 테이블과 JOIN했을 때 필요한 항목들
	private String courseType; // 교과목 구분 (전공, 교양)
	private String courseName; // 교과목 이름
	
	// users 테이블과 JOIN했을 때 필요한 항목
	private String name; // 교과목을 담당하는 교수 이름
	
	public StudentGrade() {
		super("student_grades");
	}
}

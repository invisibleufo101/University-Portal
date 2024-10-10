package com.university.model.impl;

import com.university.model.Model;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StudentGrade extends Model {

	private Long id;
	private Long studentEnrollmentId;
	private String grade;
	
	public StudentGrade() {
		super("student_grades");
	}
}

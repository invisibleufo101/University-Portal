package com.university.model.impl;

import lombok.Getter;
import lombok.ToString;

import com.university.model.Model;

@Getter
@ToString
public class StudentEnrollment extends Model {

	private Long id;
	private Long enrollmentId;
	private Long studentId;
	private Long cnt;
	
	public StudentEnrollment() {
		super("student_enrollments");
	}
}

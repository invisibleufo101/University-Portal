package com.university.service;

import com.university.model.impl.StudentGrade;
import com.university.querybuilder.QueryBuilder;

public class GradeService {

	private QueryBuilder queryBuilder = new QueryBuilder(StudentGrade.class);
	
	public void addGrade(StudentGrade newGrade) {
		queryBuilder.update()
					.set("grade", newGrade.getGrade())
					.where("studentEnrollmentId", newGrade.getStudentEnrollmentId())
					.execute();
	}
}

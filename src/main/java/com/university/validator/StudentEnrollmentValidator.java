package com.university.validator;

import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentEnrollment;
import com.university.querybuilder.QueryBuilder;

public class StudentEnrollmentValidator {
	
	public boolean validate(Long enrollmentId) {
		Enrollment checkEnrollment = new QueryBuilder(Enrollment.class)
				.select("currentlyEnrolled", "enrollmentCapacity")
				.where("id", enrollmentId)
				.get();
		
		int currentEnrolled = (int) checkEnrollment.getCurrentlyEnrolled();
		int enrollmentCapacity = (int) checkEnrollment.getEnrollmentCapacity();
		
		return currentEnrolled < enrollmentCapacity;
	}
}

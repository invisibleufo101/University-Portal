package com.university.service;

import java.sql.SQLException;
import java.util.List;

import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentEnrollment;
import com.university.querybuilder.QueryBuilder;

public class StudentEnrollmentService {

	public List<Enrollment> browseAvailableEnrollments(){
		
		List<Enrollment> availableCourses = new QueryBuilder(Enrollment.class)
												.select(
													"courses.courseName as courseName",
													"courses.courseType as courseType",
													"users.name as name",
													"enrollments.*")
												.join("courses", "id", "courseId")
												.join("users", "id", "professorId")
												.leftJoin("studentEnrollments", "enrollmentId", "id")
													.and("studentEnrollments.studentId", 13)
												.whereNull("studentEnrollments.enrollmentId")
												.orderBy("enrollments.id").getAll();

		return availableCourses;
	}
	
	public List<Enrollment> browseRegisteredEnrollments(){
		List<Enrollment> registeredCourses = new QueryBuilder(Enrollment.class)
				.select(
					"courses.courseName as courseName",
					"courses.courseType as courseType",
					"users.name as name",
					"enrollments.*")
				.join("courses", "id", "courseId")
				.join("users", "id", "professorId")
				.innerJoin("studentEnrollments", "enrollmentId", "id")
				.where("studentEnrollments.studentId", 13)
				.orderBy("enrollments.id")
				.getAll();
		
		return registeredCourses;
	}
	
	public void addStudentEnrollment(Long studentId, Long enrollmentId) {
		// add record to StudentEnrollments table
		new QueryBuilder(StudentEnrollment.class)
						.insert("enrollmentId", "studentId")
						.values(enrollmentId, studentId)
						.execute();
		
		// then update the currentlyEnrolled column of Enrollments table
		StudentEnrollment enrollments = new QueryBuilder(StudentEnrollment.class)
				.select("count(enrollment_id) as cnt")
				.where("enrollmentId", enrollmentId)
				.get();
		
		System.out.println("Enrollments:");
		System.out.println(enrollments.toString());
		

		new QueryBuilder(Enrollment.class)
			.update()
			.set("currentlyEnrolled", enrollments.getCnt())
			.where("id", enrollmentId)
			.execute();
	}
}


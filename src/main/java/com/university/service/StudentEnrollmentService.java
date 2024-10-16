package com.university.service;

import java.util.List;
import java.util.Map;

import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentEnrollment;
import com.university.model.impl.StudentGrade;
import com.university.querybuilder.QueryBuilder;

public class StudentEnrollmentService {

	public List<Enrollment> browseAvailableEnrollments(Long studentId, Map<String, String> searchParams){
		
		List<Enrollment> availableCourses = new QueryBuilder(Enrollment.class)
												.select(
													"courses.courseName as courseName",
													"courses.courseType as courseType",
													"users.name as name",
													"enrollments.*")
												.join("courses", "id", "courseId")
												.join("users", "id", "professorId")
												.leftJoin("studentEnrollments", "enrollmentId", "id")
													.and("studentEnrollments.studentId", studentId)
												.whereNull("studentEnrollments.enrollmentId")
												.orderBy("enrollments.id").getAll();

		return availableCourses;
	}
	
	public List<Enrollment> browseRegisteredEnrollments(Long studentId){
		List<Enrollment> registeredCourses = new QueryBuilder(Enrollment.class)
				.select(
					"courses.courseName as courseName",
					"courses.courseType as courseType",
					"users.name as name",
					"enrollments.*")
				.join("courses", "id", "courseId")
				.join("users", "id", "professorId")
				.innerJoin("studentEnrollments", "enrollmentId", "id")
				.where("studentEnrollments.studentId", studentId)
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
		
		new QueryBuilder(Enrollment.class)
			.update()
			.set("currentlyEnrolled", enrollments.getCnt())
			.where("id", enrollmentId)
			.execute();
		
		addStudentGradeRecord();
	}
	
	private void addStudentGradeRecord() {
		StudentEnrollment latestEnrollment = new QueryBuilder(StudentEnrollment.class)
																.select("id")
																.orderBy("id", "DESC")
																.get();
		
		Long latestEnrollmentId = latestEnrollment.getId();
		
		new QueryBuilder(StudentGrade.class)
						.insert("studentEnrollmentId")
						.values(latestEnrollmentId)
						.execute();
	}
	
	public List<StudentEnrollment> getEnrolledStudents(Long courseId){
		QueryBuilder queryBuilder = new QueryBuilder(StudentEnrollment.class);
		List<StudentEnrollment> enrolledStudents = queryBuilder
														.select(
															"studentEnrollments.id as id",
															"users.schoolId as schoolId",
															"users.name as name")
														.join("enrollments", "id", "enrollmentId")
														.join("users", "id", "studentId")
														.chainJoin("courses", "id", "enrollments", "courseId")
														.where("enrollments.id", courseId)
														.getAll();
		
		return enrolledStudents;
	}
}


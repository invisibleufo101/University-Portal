package com.university.service;

import java.util.List;

import com.university.model.impl.StudentEnrollment;
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
	
	public List<StudentGrade> showGrades(Long studentId){
		List<StudentGrade> grades =queryBuilder
				.select(
					"courses.courseType as courseType",
					"courses.courseName as courseName",
					"users.name as name",
					"studentGrades.grade")
				.join("studentEnrollments", "id", "studentEnrollmentId")
				.chainJoin("enrollments", "id", "studentEnrollments", "enrollmentId")
				.chainJoin("courses", "id", "enrollments", "courseId")
				.chainJoin("users", "id", "enrollments", "professorId")
				.where("studentEnrollments.studentId", studentId)
				.whereNotNull("studentGrades.grade")
				.getAll();
		
		return grades;
	}
	
	public List<StudentEnrollment> getStudentGrades(Long courseId){
		QueryBuilder queryBuilder = new QueryBuilder(StudentEnrollment.class);
		List<StudentEnrollment> enrolledStudents = queryBuilder
														.select(
															"studentEnrollments.id as id",
															"users.schoolId as schoolId",
															"users.name as name",
															"studentGrades.grade")
														.join("enrollments", "id", "enrollmentId")
														.join("users", "id", "studentId")
														.join("studentGrades", "studentEnrollmentId", "id")
														.where("enrollments.id", courseId)
														.getAll();
		
		return enrolledStudents;
	}
}
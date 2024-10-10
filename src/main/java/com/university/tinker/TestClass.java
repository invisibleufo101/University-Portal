package com.university.tinker;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.university.model.impl.Course;
import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentEnrollment;
import com.university.model.impl.StudentGrade;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;

public class TestClass {

	public static void main(String[] args) {
		
		QueryBuilder queryBuilder = new QueryBuilder(StudentGrade.class);
		Long studentId = 14L;
		
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
		
	}
}

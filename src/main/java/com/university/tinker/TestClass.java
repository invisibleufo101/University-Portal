package com.university.tinker;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.university.model.impl.Course;
import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentEnrollment;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;

public class TestClass {

	public static void main(String[] args) {
		
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
														.where("enrollments.id", 14)
														.getAll();
		
		for (StudentEnrollment student : enrolledStudents) {
			System.out.println(student.toString());
			
		}
	}
}

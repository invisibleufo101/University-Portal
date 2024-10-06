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
		
//		List<Enrollment> registered = new QueryBuilder(Enrollment.class)
//				.select(
//					"studentEnrollments.id as studentEnrollmentId",	
//					"courses.courseName as courseName",
//					"courses.courseType as courseType",
//					"users.name as name",
//					"enrollments.*")
//				.join("courses", "id", "courseId")
//				.join("users", "id", "professorId")
//				.innerJoin("studentEnrollments", "enrollmentId", "id")
//				.where("studentEnrollments.studentId", 13)
//				.orderBy("enrollments.id")
//				.getAll();
//		
//		for (Enrollment reg : registered) {
//			System.out.println(reg.toString());
//		}
		
		Enrollment enrollment = new QueryBuilder(Enrollment.class)
				.select("currentlyEnrolled", "enrollmentCapacity")
				.where("id", 1)
				.get();
		
		int currentEnrolled = (int) enrollment.getCurrentlyEnrolled();
		int enrollmentCapacity = (int) enrollment.getEnrollmentCapacity();
		
		boolean flag = (currentEnrolled >= enrollmentCapacity);
		System.out.println("Flag: " + flag);
			
	}
}

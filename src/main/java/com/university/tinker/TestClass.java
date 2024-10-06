package com.university.tinker;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.university.model.impl.Course;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;

public class TestClass {

	public static void main(String[] args) {
		String temp = "3333333333333333333333333333333333333";
		
		int tempInt = Integer.parseInt(temp);
		System.out.println(tempInt);
		
//		List<Enrollment> enrollments = new QueryBuilder(Enrollment.class).select(
//				"courses.courseName as courseName",
//				"users.name as name",
//				"enrollments.*")
//		.join("courses", "id", "courseId")
//		.join("users", "id", "professor_id")
//		.orderBy("enrollments.id")
//		.getAll();
		
//		for (Enrollment enrollment : enrollments) {
//			System.out.println(enrollment.toString());
//		}
	}
}

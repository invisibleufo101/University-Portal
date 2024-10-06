package com.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.university.model.impl.Enrollment;
import com.university.querybuilder.QueryBuilder;

public class EnrollmentService {

	
	public List<Enrollment> browseEnrollments(String searchCategory, String searchKeyword){
		QueryBuilder queryBuilder = new QueryBuilder(Enrollment.class);
		if (searchCategory.equals("course_name")) {
			return queryBuilder
					.select(
							"courses.courseName as courseName",
							"courses.courseType as courseType",
							"users.name as name",
							"enrollments.*")
						.join("courses", "id", "courseId")
						.join("users", "id", "professor_id")
						.whereLike("courseName", "%" + searchKeyword + "%")
						.orderBy("enrollments.id")
						.getAll();
		} else if (searchCategory.equals("name")) {
			return queryBuilder
					.select(
							"courses.courseName as courseName",
							"courses.courseType as courseType",
							"users.name as name",
							"enrollments.*")
						.join("courses", "id", "courseId")
						.join("users", "id", "professor_id")
						.whereLike("name", "%" + searchKeyword + "%")
						.orderBy("enrollments.id")
						.getAll();
		} else if (searchCategory.equals("weighted_points")) {
			return queryBuilder
					.select(
							"courses.courseName as courseName",
							"courses.courseType as courseType",
							"users.name as name",
							"enrollments.*")
						.join("courses", "id", "courseId")
						.join("users", "id", "professor_id")
						.where("weightedPoints", searchKeyword)
						.orderBy("enrollments.id")
						.getAll();
		}
		
		return queryBuilder
				.select(
					"courses.courseName as courseName",
					"courses.courseType as courseType",
					"users.name as name",
					"enrollments.*")
				.join("courses", "id", "courseId")
				.join("users", "id", "professor_id")
				.orderBy("enrollments.id")
				.getAll();
	}
	
	public Enrollment readEnrollment(Long id) {
		QueryBuilder queryBuilder = new QueryBuilder(Enrollment.class);
		
		return queryBuilder
		.select(
				"courses.courseName as courseName",
				"courses.courseType as courseType",
				"users.name as name",
				"enrollments.*")
			.join("courses", "id", "courseId")
			.join("users", "id", "professorId")
			.where("enrollments.id", id)
			.get();
	}
	
	public void editEnrollment(Enrollment updateEnrollment) {
		
		System.out.println("Update Enrollment:");
		System.out.println(updateEnrollment.toString());
		
		QueryBuilder queryBuilder = new QueryBuilder(Enrollment.class);
		queryBuilder.update()
					.set("professorId", updateEnrollment.getProfessorId())
					.set("weightedPoints",updateEnrollment.getWeightedPoints())
					.set("enrollmentCapacity", updateEnrollment.getEnrollmentCapacity())
					.where("id", updateEnrollment.getId())
					.execute();
	}
	
	public void addEnrollment(Enrollment newEnrollment) {
		QueryBuilder queryBuilder = new QueryBuilder(Enrollment.class);
		
		queryBuilder.insert("courseId", "professorId", "weightedPoints", "enrollmentCapacity")
					.values(newEnrollment.getCourseId(), newEnrollment.getProfessorId(), newEnrollment.getWeightedPoints(), newEnrollment.getEnrollmentCapacity())
					.execute();
	}
	
	public void deleteEnrollment(Long id) {
		QueryBuilder queryBuilder = new QueryBuilder(Enrollment.class);
		queryBuilder.delete()
					.where("id", id)
					.execute();
	}
	
	
}

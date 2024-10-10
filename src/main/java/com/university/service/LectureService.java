package com.university.service;

import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;

import java.util.List;

public class LectureService {

	private QueryBuilder queryBuilder = new QueryBuilder(Enrollment.class);
	
	public List<Enrollment> browseAssignedLectures(Long professorId){
		return queryBuilder
				.select(
					"enrollments.id",
					"courses.courseType as courseType",
					"courses.courseName as courseName"
				)
				.join("courses", "id", "courseId")
				.where("enrollments.professorId", professorId)
				.getAll();
	}
	
	public Enrollment readAssignedLecture(Long lectureId) {
		return queryBuilder
				.select(
					"enrollments.id as id", 
					"courses.courseName as courseName")
				.join("courses", "id", "courseId")
				.where("enrollments.id", lectureId)
				.get();
	}
	
}

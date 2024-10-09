package com.university.service;

import java.util.List;

import com.university.model.impl.Course;
import com.university.querybuilder.QueryBuilder;

public class CourseService {

	private QueryBuilder queryBuilder = new QueryBuilder(Course.class);
	
	public List<Course> browseCourses(){
		return queryBuilder.select("id", "courseName").orderBy("id").getAll();
	}
}

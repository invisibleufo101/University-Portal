package com.university.service;

import java.util.List;

import com.university.model.impl.Major;
import com.university.querybuilder.QueryBuilder;

public class MajorService {

	private QueryBuilder queryBuilder = new QueryBuilder(Major.class); 
	
	public List<Major> browseMajors(){
		List<Major> majors = queryBuilder.select("*").orderBy("id").getAll();
		return majors;
	}
}

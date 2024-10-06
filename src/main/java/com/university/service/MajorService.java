package com.university.service;

import java.util.List;

import com.university.model.impl.Major;
import com.university.querybuilder.QueryBuilder;

public class MajorService {

	public List<Major> browseMajors(){
		List<Major> majors = new QueryBuilder(Major.class).select("*").orderBy("id").getAll();
		return majors;
	}
}

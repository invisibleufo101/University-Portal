package com.university.model.impl;

import com.university.model.Model;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Course extends Model {

	private Long id;           // 행 id
	private String courseType; // 교과목 구분 (교양, 전공)
	private String courseName; // 교과목 이름
	
}

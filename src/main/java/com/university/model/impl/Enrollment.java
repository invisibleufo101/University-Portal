package com.university.model.impl;

import com.university.model.Model;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Enrollment extends Model {

	private Long id;                // 행 id     
	private Long courseId;          // 교과목 id
	private Long professorId;       // 교수 id
	private int weightedPoints;     // 수강 학점 (3,2,1)
	private int enrollmentCapacity; // 수강 인원 
	
	// courses 테이블과 users 테이블들을 JOIN 했을 시 쓰는 필드들
	private String courseName;      // 교과목 이름
	private String courseType;		// 교과목 구분 (전공, 교양)
	private String name;            // 교수 이름
}

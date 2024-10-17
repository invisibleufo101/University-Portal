package com.university.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.university.model.impl.Course;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;

public class EnrollmentValidator {

	private Map<String, String> errors = new LinkedHashMap<>();
	
	public boolean validate(Map<String, String> params) {
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String param = entry.getKey();
			String value = entry.getValue();
			
			if (param.equals("course_id")) {
				if (!validateCourseId(value)) {
					return false;
				}
			} else if (param.equals("professor_id")) {
				if (!validateProfessorId(value)) {
					return false;
				}
			} else if (param.equals("weighted_points")) {
				if (!validateWeightedPoints(value)) {
					return false;
				}
			} else if (param.equals("enrollment_capacity")) {
				if (!validateEnrollmentCapacity(value)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 등록할 수강 교과목의 이름의 예외처리를 합니다.
	 * 
	 * @param value
	 * @return
	 */
	private boolean validateCourseId(String value) {
		// 입력 값이 없는 경우
		if (value.equals("") || value == null) {
			errors.put("courseId", "* 교과목명을 입력해주세요.");
			return false;
		}
		
		// 입력 값이 조작된 경우 (숫자가 아닌 경우)
		Long courseId = 0L;
		try {
			courseId = Long.parseLong(value);
		} catch (Exception e) {
			errors.put("courseId", "* 올바른 교과목명을 입력해주세요.");
			return false;
		}
		
		// 입력 값이 조작된 경우 (없는 courses(id)인 경우)
		Long courseIds[] = getValidCourseIds();
		int pos = Arrays.binarySearch(courseIds, courseId);
		if (pos < 0) {
			errors.put("courseId", "* 존재하지 않는 교과목입니다.");
			return false;
		}

		return true;
	}
	
	/**
	 * 등록할 수강 교과목의 담당 교수를 예외처리 합니다.
	 * @param value
	 * @return
	 */
	private boolean validateProfessorId(String value) {
		// 입력 값이 없는 경우
		if (value.equals("") || value == null){
			errors.put("professorId", "* 담당 교수를 선택해주세요.");
			return false;
		}
		
		// 입력 값이 조작된 경우 (숫자가 아닌 경우)
		Long professorId = 0L;
		try {
			professorId = Long.parseLong(value);
		} catch (Exception e) {
			errors.put("professorId", "* 올바른 교수를 선택해주세요.");
			return false;
		}
		
		// 입력 값이 조작된 경우 (없는 교수인 경우)
		Long professorIds[] = getValidProfessorIds();
		int pos = Arrays.binarySearch(professorIds, professorId);
		if (pos < 0) {
			errors.put("professorId", "* 존재하지 않는 교수입니다.");
			return false;
		}
		
		return true;
	}
	
	private boolean validateWeightedPoints(String value) {
		// 입력 값이 없는 경우
		if (value.equals("") || value == null) {
			errors.put("weightedPoints", "* 학점을 입력해주세요.");
			return false;
		}
		
		// 입력 값이 조작된 경우 (숫자가 아닌 경우)
		int weightedPoints = 0;
		try {
			weightedPoints = Integer.parseInt(value);
		} catch (Exception e) {
			errors.put("weightedPoints", "* 올바른 학점을 입력해주세요.");
			return false;
		}
		
		// 입력 값이 조작된 경우 (1-3 학점 사이가 아닌 경우)
		if (weightedPoints < 1 || weightedPoints > 3) {
			errors.put("weightedPoints", "* 올바른 학점을 입력해주세요.");
			return false;
		}
	
		return true;
	}
	
	private boolean validateEnrollmentCapacity(String value) {
		if (value.equals("") || value == null) {
			errors.put("enrollmentCapacity", "* 수강 인원을 입력해주세요.");
			return false;
		}
		
		int enrollmentCapacity = 0;
		try {
			enrollmentCapacity = Integer.parseInt(value);
		} catch (Exception e) {
			errors.put("enrollmentCapacity", "* 올바른 수강 인원을 입력해주세요.");
			return false;
		}
		
		if (enrollmentCapacity < 5) {
			errors.put("enrollmentCapacity", "* 최소 수강 인원 미만입니다. 다시 입력해주세요.");
			return false;
		}
		
		if (enrollmentCapacity > 150) {
			errors.put("enrollmentCapacity", "* 최대 수강 인원 초과입니다. 다시 입력해주세요.");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 현재 시스템에 등록된 교과목 id를 가져옵니다.
	 * @return
	 */
	private Long[] getValidCourseIds() {
		List<Course> courses = new QueryBuilder(Course.class).select("id").orderBy("id").getAll();
		Long[] courseIds = new Long[courses.size()];
		for(int i=0; i<courses.size(); i++) {
			courseIds[i] = courses.get(i).getId();
		}
		
		return courseIds;
	}
	
	/**
	 * 현재 시스템에 등록된 모두 교수의 id를 가져옵니다.
	 * 
	 * @return
	 */
	private Long[] getValidProfessorIds() {
		List<User> professors = new QueryBuilder(User.class).select("id").where("roleId", 3).getAll();
		Long[] professorIds = new Long[professors.size()];
		for (int i=0; i<professors.size(); i++) {
			professorIds[i] = professors.get(i).getId();
		}
		
		return professorIds;
	}
	
	public Map<String, String> getErrors(){
		return this.errors;
	}
}

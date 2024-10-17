package com.university.validator;

import java.util.LinkedHashMap;
import java.util.Map;

public class GradeValidator {

	private Map<String, String> errors = new LinkedHashMap<>();
	
	public boolean validate(String grade) {
		
		if (grade.equals("") || grade == null) {
			errors.put("student_grade", "* 성적을 입력해주세요.");
			return false;
		}
		
		String gradePattern = "A[+-0]|B[+-0]|C[+-0]|D[+-0]|F";
		if (!grade.matches(gradePattern)) {
			errors.put("student_grade", "* 올바르지 않은 성적 입력 값입니다.");
			return false;
		}
		
		return true;
	}
	
	public Map<String, String> getErrors(){
		return this.errors;
	}
}

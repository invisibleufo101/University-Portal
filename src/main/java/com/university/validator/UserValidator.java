package com.university.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;

public class UserValidator {
	
	private Map<String, String> errors = new LinkedHashMap<>();

	public boolean validate(Map<String, String> params) {
		for (Map.Entry<String,String> entry : params.entrySet()) {
			String param = entry.getKey();
			String value = entry.getValue();
			
			if (param.equals("register_role_id")) {
				if (!validateRoleId(value)) {
					return false;
				}
			} else if (param.equals("register_major_id")) {
				if (!validateMajorId(value)) {
					return false;
				}
			} else if (param.equals("register_name")) {
				if (!validateName(value)) {
					return false;
				}
			} else if (param.equals("register_birth_date")) {
				if (!validateBirthDate(value)) {
					return false;
				}
			} else if (param.equals("register_email")) {
				if (!validateEmail(value)) {
					return false;
				}
			} else if (param.equals("register_phone_number")) {
				if (!validatePhoneNumber(value)) {
					return false;
				}
			} else if (param.equals("update_major_id")) {
				if (!validateMajorId(value)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// This is so hard-coded....
	/**
	 * role_id 항목 값의 예외처리를 합니다.
	 * 사용자 요청이 조작된 경우를 처리하기 위해서 만들었습니다.
	 * 
	 * role_id가 1 ~ 3의 값이 아닌 경우 예외처리를 합니다.
	 * @return
	 */
	private boolean validateRoleId(String value) {
		if (value.equals("") || value == null) {
			errors.put("roleId", "* 계정 구분 값을 입력해주세요.");
			return false;
		}
		Long roleId = 0L;
		
		try {			
			roleId = Long.parseLong(value);
		} catch (NumberFormatException nfe) {
			errors.put("roleId", "* 올바른 계정 구분 값을 입력해주세요.");
			return false;
		}
		
		if (roleId < 1L || roleId > 3L) {
			errors.put("roleId", "* 올바른 계정 구분 값을 입력해주세요.");
			return false;
		}

		return true;
	}
	
	// This is so hard-coded....
	/**
	 * major_id 항목 값의 예외처리르 합니다.
	 * 사용자 요청이 조작된 경우를 처리하기 위해서 만들었습니다.
	 * 
	 * majors 데이터베이스 테이블의 id 값들의 범위를 벗어날 경우 예외처리를 합니다.
	 * @param majorId
	 * @return
	 */
	private boolean validateMajorId(String value) {
		Long majorId = 0L;
		
		if (value.equals("") || value == null) {
			errors.put("majorId", "* 학과명을 선택해주세요.");
			return false;
		}
		
		try {
			majorId = Long.parseLong(value);
		} catch (NumberFormatException nfe) {
			errors.put("majorId", "* 올바른 학과명을 입력해주세요.");
			return false;
		}
		
		if (majorId < 1L || majorId > 42L) {
			errors.put("majorId", "* 올바른 학과명을 입력해주세요.");
			return false;
		}

		return true;
	}
	
	/**
	 * 사용자의 이름을 예외처리합니다.
	 * 사용자의 이름이 한글이 아니거나 2-7글자가 아닌 경우 예외처리를 합니다.
	 * 
	 * @param name
	 * @return
	 */
	private boolean validateName(String name) {
		if (name.equals("") || name == null) {
			errors.put("name", "* 이름을 입력해주세요.");
			return false;
		}
		
		if (name.length() < 2 && name.length() > 7) {
			errors.put("name", "* 이름은 2-7글자 사로 입력해주세요.");
			return false;
		}
		
		String namePattern = "^[가-힣]{2,7}$"; // Code provided by chatGPT
		if (!name.matches(namePattern)) {
			errors.put("name", "* 이름은 한글로 2글자에서 7글자 사이로 입력해주세요.");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 사용자의 생년월일을 예외처리합니다.
	 * 
	 * 사용자의 입력 형식이 yyyy-MM-dd 형식을 따르지 않거나
	 * 생년월일이 만18세 이상 만65세 미만이 아닐 경우 예외처리를 합니다.
	 * 
	 * @param value
	 * @return
	 */
	private boolean validateBirthDate(String value) {
		if (value.equals("") || value == null) {
			errors.put("birthDate", "* 생년월일을 입력해주세요");
			return false;
		}
		
		try {			
			LocalDate birthDate = LocalDate.parse(value);
			LocalDate now = LocalDate.now();
			int age = Period.between(birthDate, now).getYears();
			if (age < 18) {
				errors.put("birthDate", "* 나이는 만18세 이상이어야 합니다.");
				return false;
			}
			
			if (age >= 65) {
				errors.put("birthDate", "* 나이는 만65세 미만이어야 합니다.");
				return false;
			}
		} catch (DateTimeParseException dtpe) {
			errors.put("birthDate", "* 올바른 날짜 형식으로 입력해주세요. (yyyy-MM-dd)");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 사용자의 이메일을 예외처리합니다.
	 * 
	 * 이메일이 example@example.com 등 이메일 형식에 안맞는 경우 예외처리를 합니다.
	 * @param email
	 * @return
	 */
	private boolean validateEmail(String email) {
		if(email.equals("") || email == null) {
			errors.put("email", "* 이메일을 입력해주세요.");
			return false;
		}
		
		// Code provided by chatGPT
		String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; 
		if(!email.matches(emailPattern)) {
			errors.put("email", "* 올바른 이메일 형식으로 입력해주세요.");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 사용자의 전화번호를 예외처리합니다.
	 * 
	 * 전화번호 패턴이 010-1234-5678 패턴에 안맞거나 
	 * 이미 등록된 전화번호라면 예외처리를 합니다.
	 * 
	 * @param value
	 * @return
	 */
	private boolean validatePhoneNumber(String value) {
		if (value.equals("") || value == null) {
			errors.put("phoneNumber", "* 전화번호를 입력해주세요.");
			return false;
		}
		
		String phoneNumberPattern = "010-\\d{4}-\\d{4}";
		if (!value.matches(phoneNumberPattern)) {
			errors.put("phoneNumber", "* 전화번호는 010-1234-5678 형식으로 입력해주세요.");
			return false;
		}
		
		if (!checkDuplicatePhoneNumber(value)) {
			errors.put("phoneNumber", "* 이미 존재하는 전화번호입니다.");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 데이터베이스에서 중복된 전화번호를 찾기 위해 쓰는 메소드입니다.
	 * 
	 * @param value
	 * @return
	 */
	private boolean checkDuplicatePhoneNumber(String value) {
		List<User> userPhoneNumbers = new QueryBuilder(User.class).select("phoneNumber").getAll();
		
		return userPhoneNumbers.stream()
				.map(User::getPhoneNumber)
				.noneMatch(phoneNumber -> phoneNumber.equals(value));
	}
	
	/**
	 * Validator 객체에서 잡은 예외처리를 다시 반환합니다.
	 * 
	 * Error맵의 Key는 페이지의 어느 항목이 예외처리 되었는지 알려주는 input parameter이고
	 * Value는 해당 에러의 메세지를 담고 있습니다.
	 * 
	 * @return [Key => <input> Parameter, Value => Error Message]
	 */
	public Map<String, String> getErrors(){
		return this.errors;
	}
}

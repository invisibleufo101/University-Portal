package com.university.controller.impl.admin;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.controller.Controller;
import com.university.model.impl.Major;
import com.university.model.impl.User;
import com.university.service.MajorService;
import com.university.service.UserService;
import com.university.util.RequestParameterUtil;
import com.university.validator.UserValidator;


public class UserController extends Controller {

	private UserValidator validator = new UserValidator();
	private UserService userService = new UserService();
	
	@Override
	public String browse(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userService.browseUsers();
		request.setAttribute("users", users);
		return "admin/accounts/accounts";
	}
	
	@Override
	public String read(HttpServletRequest request, HttpServletResponse response) {
		String schoolId = request.getParameter("schoolId");
		User readUser = userService.readUser(schoolId);
		List<Major> majors = new MajorService().browseMajors();
		
		request.setAttribute("majors", majors);
		request.setAttribute("readUser", readUser);
		
		return "admin/accounts/read_account";
	}
	
	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		String editSchoolId = request.getParameter("update_school_id");
		String editMajor = request.getParameter("update_major_id");
		
		Map<String, String> editParams = RequestParameterUtil.mapRequestParameters(request);
		
		if (!validator.validate(editParams)) {
			Map<String, String> errors = validator.getErrors();
			request.setAttribute("errors", errors);
			return "account-read.do?schoolId=" + editSchoolId;
		}
		
		userService.editUser(editSchoolId, Long.parseLong(editMajor));
		
		return "account-management.do";
	}

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> addParams = RequestParameterUtil.mapRequestParameters(request);
		
		if (!validator.validate(addParams)) {
			Map<String,String> errors = validator.getErrors();

			request.setAttribute("oldInputs", addParams);
			request.setAttribute("errors", errors);
			return "account-register.do";
		}

		User newUser = new User();
		Long roleId = Long.parseLong(addParams.get("register_role_id"));
		newUser.setField("roleId", roleId);
		
		Long majorId = Long.parseLong(addParams.get("register_major_id"));
		newUser.setField("majorId", majorId);
		
		newUser.setField("name", addParams.get("register_name"));
		
		String birthDateString = addParams.get("register_birth_date");
		newUser.setField("birthDate", Date.valueOf(birthDateString));
		
		String email = addParams.get("register_email");
		newUser.setField("email", email);
		
		String phoneNumber = addParams.get("register_phone_number");
		newUser.setField("phoneNumber", phoneNumber);
		
		userService.addUser(newUser);
		
		return "account-management.do";
	}
	
}

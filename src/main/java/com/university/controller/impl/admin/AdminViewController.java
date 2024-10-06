package com.university.controller.impl.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.controller.Controller;
import com.university.model.impl.Course;
import com.university.model.impl.Major;
import com.university.model.impl.User;
import com.university.querybuilder.QueryBuilder;


public class AdminViewController extends Controller {

	/**
	 * 메인 관리자 포털 페이지를 보여주는 메소드입니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String showPortal(HttpServletRequest request, HttpServletResponse response) {
		return "admin/portal";
	}
	
	/**
	 * 관리자가 계정 등록하는 페이지를 보여주는 메소드입니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String showRegisterAccount(HttpServletRequest request, HttpServletResponse response) {
		List<Major> majors = new QueryBuilder(Major.class).select("*").orderBy("id").getAll();
		
		request.setAttribute("majors", majors);
		return "admin/accounts/add_account";
	}
	
	/**
	 * 관리자가 수강 교과목 등록하는 페이지를 보여주는 메소드입니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String showRegisterEnrollment(HttpServletRequest request, HttpServletResponse response) {
		List<Course> courses = new QueryBuilder(Course.class).select("id", "courseName").getAll();
		List<Course> courseTypes = new QueryBuilder(Course.class).select("distinct(course_type)").getAll();
		List<User> professors = new QueryBuilder(User.class).select("id", "name").where("roleId", 3).getAll();

		request.setAttribute("courses", courses);
		request.setAttribute("courseTypes", courseTypes);		
		request.setAttribute("professors", professors);
		
		return "admin/enrollments/add_enrollment";
	}
}

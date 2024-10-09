package com.university.controller.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.User;
import com.university.service.LoginService;
import com.university.util.PasswordUtil;

/**
 * 로그인 하나만 책임지는 Controller 객체입니다.
 */
public class LoginController extends Controller {
	
	private LoginService loginService = new LoginService();
	
	/**
	 * 사용자가 로그인할 때 validator 객체로 먼저 입력한 아이디와 비밀번호가 데이터베이스에 존재하는지 확인하며
	 * 존재한다면 user_role에 맞는 경로로 사용자를 보내줍니다.
	 * 
	 * 그렇지 않다면 에러 메세지와 함께 다시 로그인 페이지로 돌아옵니다.
	 * @param request
	 * @param response
	 * @return
	 */
	public String doLogin(HttpServletRequest request, HttpServletResponse response) {
		String schoolId = request.getParameter("school_id");
		String password = request.getParameter("password");

		User loginUser = loginService.getLoginUser(schoolId);

		if (loginUser != null && loginService.verifyPassword(password, (String) loginUser.getField("password"), (byte[]) loginUser.getField("salt"))) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			// 원래 role_name으로 구별해서 로그인 routing을 다르게 하려고 했으나 한글 인식이 잘 안되어서 숫자로 구분했습니다.
			
			// 사용자가 관리자라면 관리자 페이지로 넘겨줍니다.
			if (loginUser.getRoleId() == 1L) {
				return "/admin-portal.do";
			}
			
			// 사용자가 학생이라면 학생 페이지로 넘겨줍니다.
			if (loginUser.getRoleId() == 2L) {
				return "/student-portal.do";
			}
			
			// 사용자가 교수라면 교수 페이지로 넘겨줍니다.
			if (loginUser.getRoleId() == 3L) {
				return "/professor-portal.do";
			}
		} 
		
		Map<String, String> errors = new HashMap<>();
		errors.put("LoginError", "*학번/교번 또는 비밀번호가 맞지 않습니다.");
		request.setAttribute("errors", errors);
		
		return "login";
	}
	
	/**
	 * 사용자를 로그아웃 시킵니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String doLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}

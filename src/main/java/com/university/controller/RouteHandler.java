package com.university.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RouteHandler {

	private Map<String,String> routeMap;
	
	/**
	 * 사용자가 요청한 각 경로에 따라 어느 Controller객체의 메소드가 담당하는지 맵으로 저장하여 명시해줍니다.
	 * [Key => 사용자 요청 루트, Value => 핸들링하는 Controller 객체의 메소드] 
	 *  
	 * Controller 객체에 패키지명까지 쓰는 이유는 사용자의 user_role에 따라 패키지명이 달라지기 때문입니다.
	 */
	public RouteHandler() {
		routeMap = new HashMap<>();
		routeMap.put("/login.do", "com.university.controller.impl." + "LoginController@doLogin");
		routeMap.put("/logout.do", "com.university.controller.impl." + "LoginController@doLogout");
		
		// 관리자 포털 메인 페이지
		routeMap.put("/admin-portal.do", "com.university.controller.impl.admin." + "AdminViewController@showPortal");
		
		// 관리자 계정 관리 페이지 및 요청 처리
		routeMap.put("/account-management.do", "com.university.controller.impl.admin." + "UserController@browse");
		routeMap.put("/account-register.do", "com.university.controller.impl.admin." + "AdminViewController@showRegisterAccount");
		routeMap.put("/account-add.do", "com.university.controller.impl.admin." + "UserController@add");
		routeMap.put("/account-read.do", "com.university.controller.impl.admin." + "UserController@read");
		routeMap.put("/account-edit.do", "com.university.controller.impl.admin." + "UserController@edit");
		
		// 관리자 수강 관리 페이지 및 요청 처리
		routeMap.put("/enrollment-management.do", "com.university.controller.impl.admin." + "EnrollmentController@browse");
		routeMap.put("/enrollment-register.do", "com.university.controller.impl.admin." + "AdminViewController@showRegisterEnrollment");
		routeMap.put("/enrollment-add.do", "com.university.controller.impl.admin." + "EnrollmentController@add");
		routeMap.put("/enrollment-read.do", "com.university.controller.impl.admin." + "EnrollmentController@read");
		routeMap.put("/enrollment-edit.do", "com.university.controller.impl.admin." + "EnrollmentController@edit");
		routeMap.put("/enrollment-delete.do", "com.university.controller.impl.admin." + "EnrollmentController@delete");
		
		// 학생 포털 메인 페이지
		routeMap.put("/student-portal.do", "com.university.controller.impl.student." + "StudentViewController@showPortal");
		routeMap.put("/enrollment-registration.do", "com.university.controller.impl.student." + "StudentEnrollmentController@browse");
		routeMap.put("/enrollment-add.do", "com.university.controller.impl.student." + "StudentEnrollmentController@add");
		routeMap.put("/enrollment-read.do", "com.university.controller.impl.student." + "StudentEnrollmentController@read");
		
	}
	
	@SuppressWarnings("unchecked")
	public String handleRequest(String path, HttpServletRequest request, HttpServletResponse response) {
		String[] parts = routeMap.get(path).split("@");
		String controllerName =  parts[0]; 
		String methodName = parts[1];
		
		// debug
		System.out.println("Controller Name: " + controllerName);
		System.out.println("Method Name: " + methodName);
	
		Class<? extends Controller> controllerClass = null;
		Controller controllerObject = null;
		
		try {
			// Reflect API로 문자열로 된 Controller의 이름으로 Controller 객체를 만듭니다.
			controllerClass = (Class<? extends Controller>) Class.forName(controllerName);
			controllerObject = controllerClass.getDeclaredConstructor().newInstance();
			
			// 문자열로 된 메소드의 이름을 Reflect API로 Method 객체로 가져온 뒤 Controller 객체에 해당 메소드를 호출합니다.
			Method controllerMethod = controllerClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			return (String) controllerMethod.invoke(controllerObject, request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
//			return null;
			// 테스트용
			return "error";
		}

		
	}
}

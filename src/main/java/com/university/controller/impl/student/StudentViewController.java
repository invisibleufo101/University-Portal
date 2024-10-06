package com.university.controller.impl.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.controller.Controller;

public class StudentViewController extends Controller {

	public String showPortal(HttpServletRequest request, HttpServletResponse response) {
		return "student/portal";
	}
}

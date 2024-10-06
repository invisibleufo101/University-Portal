package com.university.controller.impl.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.service.StudentEnrollmentService;

public class StudentViewController extends Controller {

	public String showPortal(HttpServletRequest request, HttpServletResponse response) {
		List<Enrollment> registeredCourses = new StudentEnrollmentService().browseRegisteredEnrollments();
		request.setAttribute("registeredCourses", registeredCourses);
		
		return "student/portal";
	}
}

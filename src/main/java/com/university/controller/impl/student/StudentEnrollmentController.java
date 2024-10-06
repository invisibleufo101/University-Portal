package com.university.controller.impl.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.service.StudentEnrollmentService;

public class StudentEnrollmentController extends Controller {

	private StudentEnrollmentService service = new StudentEnrollmentService();
	
	// GET @ enrollment-registration.do
	@Override
	public String browse(HttpServletRequest request, HttpServletResponse response) {
		List<Enrollment> availableCourses = service.browseAvailableEnrollments();
		request.setAttribute("availableCourses", availableCourses);
		
		return "student/enrollments/enrollments";
	}
	
	// POST @ enrollment-add.do
	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) {
		String enrollmentIdString = request.getParameter("enrollment_id");
		Long enrollmentId = Long.parseLong(enrollmentIdString);
		
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("loginUser");
		
		service.addStudentEnrollment(currentUser.getId(), enrollmentId);
		
		return "/enrollment-registration.do";
	}
	
	
	// GET @ enrollment-read.do
	@Override
	public String read(HttpServletRequest request, HttpServletResponse response) {
		List<Enrollment> registeredCourses = service.browseRegisteredEnrollments();
		request.setAttribute("registeredCourses", registeredCourses);
		
		return "student/enrollments/read_enrollments";
	}
}

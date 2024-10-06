package com.university.controller.impl.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.service.StudentEnrollmentService;
import com.university.validator.StudentEnrollmentValidator;

public class StudentEnrollmentController extends Controller {

	private StudentEnrollmentValidator validator = new StudentEnrollmentValidator();
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
		
		System.out.println(validator.validate(enrollmentId));
		if (!validator.validate(enrollmentId)) {
			
			// how do I send error message? where do I put it?
			String errorMsg = "해당 교과목은 수강 신청이 불가합니다.";
			request.setAttribute("errorStatus", true);
			request.setAttribute("errorMsg", errorMsg);
			
			return "/enrollment-registration.do";
		}
		
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

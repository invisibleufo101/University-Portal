package com.university.controller.impl.student;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.service.StudentEnrollmentService;
import com.university.util.RequestParameterUtil;
import com.university.validator.StudentEnrollmentValidator;

public class StudentEnrollmentController extends Controller {

	private StudentEnrollmentValidator validator = new StudentEnrollmentValidator();
	private StudentEnrollmentService service = new StudentEnrollmentService();
	
	// GET @ enrollment-registration.do
	@Override
	public String browse(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> searchParams = RequestParameterUtil.mapRequestParameters(request);
		
		Long studentId = getCurrentUserId(request);
		
		List<Enrollment> availableCourses = service.browseAvailableEnrollments(studentId, searchParams);
		request.setAttribute("availableCourses", availableCourses);
		
		return "student/enrollments/enrollments";
	}
	
	// POST @ enrollment-add.do
	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) {
		String enrollmentIdString = request.getParameter("enrollment_id");
		Long enrollmentId = Long.parseLong(enrollmentIdString);
		
		Long studentId = getCurrentUserId(request);
		
		if (!validator.validate(enrollmentId)) {
			
			// how do I send error message? where do I put it?
			String errorMsg = "해당 교과목은 수강 신청이 불가합니다.";
			request.setAttribute("errorStatus", true);
			request.setAttribute("errorMsg", errorMsg);
			
			System.out.println("수강 신청이 불가함!!!");
			
			return "/student-enrollment-registration.do";
		}
		
		service.addStudentEnrollment(studentId, enrollmentId);
		
		return "/student-enrollment-registration.do";
	}
	
	
	// GET @ enrollment-read.do
	@Override
	public String read(HttpServletRequest request, HttpServletResponse response) {
		Long studentId = getCurrentUserId(request);
		
		List<Enrollment> registeredCourses = service.browseRegisteredEnrollments(studentId);
		request.setAttribute("registeredCourses", registeredCourses);
		
		return "student/enrollments/read_enrollments";
	}
	
	private Long getCurrentUserId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("loginUser");
		return currentUser.getId();
	}
}

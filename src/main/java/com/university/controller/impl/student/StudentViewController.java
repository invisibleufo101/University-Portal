package com.university.controller.impl.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentGrade;
import com.university.model.impl.User;
import com.university.service.GradeService;
import com.university.service.StudentEnrollmentService;

public class StudentViewController extends Controller {

	public String showPortal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("loginUser");
		
		List<Enrollment> registeredCourses = new StudentEnrollmentService().browseRegisteredEnrollments(currentUser.getId());
		request.setAttribute("registeredCourses", registeredCourses);
				
		return "student/portal";
	}
	
	public String showGrades(HttpServletRequest request, HttpServletResponse response) {
		Long studentId = getStudentId(request);
		List<StudentGrade> grades = new GradeService().showGrades(studentId);
		
		request.setAttribute("grades", grades);
		
		return "student/grades";
	}
	
	private Long getStudentId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentStudent = (User) session.getAttribute("loginUser");
		return currentStudent.getId();
	}
	
}

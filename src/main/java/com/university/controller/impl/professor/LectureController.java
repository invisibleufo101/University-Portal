package com.university.controller.impl.professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.service.LectureService;

public class LectureController extends Controller {

	private LectureService service = new LectureService();
	
	public String browse(HttpServletRequest request, HttpServletResponse response) {
		Long professorId = getCurrentProfessorId(request);
		List<Enrollment> assignedLectures = service.browseAssignedLectures(professorId);
		
		request.setAttribute("assignedLectures", assignedLectures);
		
		return "professor/lectures/lectures";
	}
	
	public String showLectureAnnouncements(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		Long lectureId = Long.parseLong(idString);
		Enrollment currentLecture = service.readAssignedLecture(lectureId);
		
		HttpSession session = request.getSession();
		session.setAttribute("currentLecture", currentLecture);

		return "professor/lectures/announcement_lecture";
	}
	
	public String showLectureMaterials(HttpServletRequest request, HttpServletResponse response) {
		
		return "professor/lectures/materials_lecture";
	}
	
	public String showLectureGradeManagement(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Enrollment currentLecture = (Enrollment) session.getAttribute("currentLecture");
		
		List<User> registeredStudents = service.getEnrolledStudents(currentLecture.getId());
		request.setAttribute("registeredStudents", registeredStudents);
		
		return "professor/lectures/grade_lecture";
	}
	
	private Long getCurrentProfessorId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentProfessor = (User) session.getAttribute("loginUser");
		return currentProfessor.getId();
	}
}

package com.university.controller.impl.professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.service.LectureService;

public class ProfessorViewController extends Controller {

	private LectureService service = new LectureService();
	
	public String showPortal(HttpServletRequest request, HttpServletResponse response) {
		Long professorId = getCurrentProfessorId(request);
		List<Enrollment> assignedLectures = service.browseAssignedLectures(professorId);
		
		request.setAttribute("assignedLectures", assignedLectures);
		
		return "professor/portal";
	}
	
	private Long getCurrentProfessorId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentProfessor = (User) session.getAttribute("loginUser");
		return currentProfessor.getId();
	}
}

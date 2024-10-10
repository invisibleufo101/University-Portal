package com.university.controller.impl.professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.StudentEnrollment;
import com.university.model.impl.StudentGrade;
import com.university.model.impl.User;
import com.university.service.GradeService;
import com.university.service.LectureService;
import com.university.service.StudentEnrollmentService;

public class LectureController extends Controller {

	private LectureService service = new LectureService();
	
	/**
	 * 현재 교수자가 진행 중인 강의들의 목록을 보여주는 메소드입니다.
	 * 
	 */
	public String browse(HttpServletRequest request, HttpServletResponse response) {
		Long professorId = getCurrentProfessorId(request);
		List<Enrollment> assignedLectures = service.browseAssignedLectures(professorId);
		
		request.setAttribute("assignedLectures", assignedLectures);
		
		return "professor/lectures/lectures";
	}
	
	/**
	 * 한 교과목 강의의 공지 사항 페이지를 보여주는 메소드입니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String showLectureAnnouncements(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		Long lectureId = Long.parseLong(idString);
		Enrollment currentLecture = service.readAssignedLecture(lectureId);
		
		HttpSession session = request.getSession();
		session.setAttribute("currentLecture", currentLecture);

		return "professor/lectures/announcement_lecture";
	}
	
	/**
	 * 한 교과목 강의의 수강생 목록 페이지를 보여주는 메소드입니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String showLectureStudents(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Enrollment currentLecture = (Enrollment) session.getAttribute("currentLecture");
		
		List<StudentEnrollment> enrolledStudents = new StudentEnrollmentService().getEnrolledStudents(currentLecture.getId());
		request.setAttribute("enrolledStudents", enrolledStudents);
		
		return "professor/lectures/students_lecture";
	}
	
	/**
	 * 한 교과목 강의의 성적 관리 페이지를 보여주는 메소드입니다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String showLectureGradeManagement(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Enrollment currentLecture = (Enrollment) session.getAttribute("currentLecture");
		
		List<StudentEnrollment> studentGrades = new StudentEnrollmentService().getStudentGrades(currentLecture.getId());
		request.setAttribute("studentGrades", studentGrades);
		
		return "professor/lectures/grade_lecture";
	}
	
	public String addGrade(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AddGrade called!!!");
		
		String idString = request.getParameter("student_enrollment_id");
		Long studentEnrollmentId = Long.parseLong(idString);
		
		String grade = request.getParameter("student_grade");
		
		StudentGrade newGrade = new StudentGrade();
		newGrade.setField("studentEnrollmentId", studentEnrollmentId);
		newGrade.setField("grade", grade);
	
		new GradeService().addGrade(newGrade);
		
		return "/professor-lecture-grade.do";
	}
	
	private Long getCurrentProfessorId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentProfessor = (User) session.getAttribute("loginUser");
		return currentProfessor.getId();
	}
}

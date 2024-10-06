package com.university.controller.impl.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.controller.Controller;
import com.university.model.impl.Enrollment;
import com.university.model.impl.User;
import com.university.service.EnrollmentService;
import com.university.service.UserService;
import com.university.util.RequestParameterUtil;
import com.university.validator.EnrollmentValidator;

public class EnrollmentController extends Controller {
	
	private EnrollmentService service = new EnrollmentService();
	private EnrollmentValidator validator = new EnrollmentValidator();
	
	@Override
	public String browse(HttpServletRequest request, HttpServletResponse response) {		
		String searchCategory = request.getParameter("search_enrollment_category");
		String searchKeyword = request.getParameter("search_enrollment_keyword");
		
		if (searchCategory == null) searchCategory = "course_name";
		if (searchKeyword == null) searchKeyword = "";
		
		HttpSession session = request.getSession();
		session.setAttribute("searchEnrollmentCategory", searchCategory);
		session.setAttribute("searchEnrollmentKeyword", searchKeyword);
		
		List<Enrollment> enrollments = service.browseEnrollments(searchCategory, searchKeyword);
		
		request.setAttribute("enrollments", enrollments);
		
		return "admin/enrollments/enrollments";
	}
	
	@Override
	public String read(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		Long id = Long.parseLong(idString);
		
		Enrollment enrollment = service.readEnrollment(id);
		List<User> professors = new UserService().getProfessors();
		
		request.setAttribute("enrollment", enrollment);
		request.setAttribute("professors", professors);
		
		return "admin/enrollments/read_enrollment";
	}
	
	@Override
	public String add(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> addParams = RequestParameterUtil.mapRequestParameters(request);
		
		if (!validator.validate(addParams)) {
			Map<String, String> errors = validator.getErrors();
			
			request.setAttribute("errors", errors);
			request.setAttribute("oldInputs", addParams);
			
			return "enrollment-register.do";
		}
		
		Enrollment newEnrollment = new Enrollment();
		
		Long courseId = Long.parseLong(addParams.get("course_id"));
		newEnrollment.setField("courseId", courseId);
		
		newEnrollment.setField("courseType", addParams.get("course_type"));
		
		Long professorId = Long.parseLong(addParams.get("professor_id"));
		newEnrollment.setField("professorId", professorId);
		
		int weightedPoints = Integer.parseInt(addParams.get("weighted_points"));
		newEnrollment.setField("weightedPoints", weightedPoints);
		
		int enrollmentCapacity = Integer.parseInt(addParams.get("enrollment_capacity"));
		newEnrollment.setField("enrollmentCapacity", enrollmentCapacity);
		
		service.addEnrollment(newEnrollment);
		
		return "enrollment-management.do";
	}
	
	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> editParams = RequestParameterUtil.mapRequestParameters(request);
		Long id = Long.parseLong(editParams.get("update_id"));
		
		if (!validator.validate(editParams)) {
			Map<String, String> errors = validator.getErrors();			
			request.setAttribute("errors", errors);
			
			
			return "enrollment-read.do?id=" + id;
		}

		for (Map.Entry<String, String> entry : editParams.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
		}
		
		Enrollment updateEnrollment = new Enrollment();
		
		updateEnrollment.setField("id", id);
		
		Long professorId = Long.parseLong(editParams.get("professor_id"));
		updateEnrollment.setField("professorId", professorId);
		
		int weightedPoints = Integer.parseInt(editParams.get("weighted_points"));
		updateEnrollment.setField("weightedPoints", weightedPoints);
		
		int enrollmentCapacity = Integer.parseInt(editParams.get("enrollment_capacity"));
		updateEnrollment.setField("enrollmentCapacity", enrollmentCapacity);
		
		service.editEnrollment(updateEnrollment);
		
		return "enrollment-management.do";
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		Long id = Long.parseLong(idString);
		
		service.deleteEnrollment(id);
		
		return "enrollment-management.do";
	}
}

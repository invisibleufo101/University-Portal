<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/lecture_header.jsp" %>		
<!-- Start of Lecture Content Area -->
<div class="col-9 p-3">
	<div class="d-flex justify-content-end">
		<button type="button" class="btn" onclick="location.href='/professor-lectures.do'">
			<svg height="30" width="30" "w-25 h-25" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
				<path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12" />
			</svg>
		</button>
	</div>
	
	<div class="m-3">				
		<h2>성적 관리</h2>
	</div>
	
	<div class="row g-3 justify-content-end align-items-center mb-3">
		<div class="ms-auto me-2 col-auto d-flex align-items-center mt-3 g-2">
			
		</div>
	</div>
	<table class="table table-hover text-center w-100 overflow-y-hidden" style="table-layout: fixed;">
		<thead class="table-dark sticky-top top-0 pt-3 bg-white">
			<tr>
				<th scope="col">학번</th>
				<th scope="col">이름</th>
				<th scope="col">성적</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="studentGrade" items="${ studentGrades }">
			<tr>
				<td>${ studentGrade.schoolId }</td>
				<td>${ studentGrade.name }</td>
				<form action="/professor-add-grade.do" method="POST">
					<input type="hidden" name="student_enrollment_id" value="${ studentGrade.id }">
					<td>
						
						<select name="student_grade" id="" class="form-select form-select-sm text-center">
							<option value="" <c:if test="${ studentGrade.grade == null }">selected</c:if>>선택</option>
							<option value="A+" <c:if test="${ studentGrade.grade == 'A+' }">selected</c:if>>A+</option>
							<option value="A0" <c:if test="${ studentGrade.grade == 'A0' }">selected</c:if>>A0</option>
							<option value="A-" <c:if test="${ studentGrade.grade == 'A-' }">selected</c:if>>A-</option>
							<option value="B+" <c:if test="${ studentGrade.grade == 'B+' }">selected</c:if>>B+</option>
							<option value="B0" <c:if test="${ studentGrade.grade == 'B0' }">selected</c:if>>B0</option>
							<option value="B-" <c:if test="${ studentGrade.grade == 'B-' }">selected</c:if>>B-</option>
							<option value="C+" <c:if test="${ studentGrade.grade == 'C+' }">selected</c:if>>C+</option>
							<option value="C0" <c:if test="${ studentGrade.grade == 'C0' }">selected</c:if>>C0</option>
							<option value="C-" <c:if test="${ studentGrade.grade == 'C-' }">selected</c:if>>C-</option>
							<option value="D+" <c:if test="${ studentGrade.grade == 'D+' }">selected</c:if>>D+</option>
							<option value="D0" <c:if test="${ studentGrade.grade == 'D0' }">selected</c:if>>D0</option>
							<option value="D-" <c:if test="${ studentGrade.grade == 'D-' }">selected</c:if>>D-</option>
							<option value="F"  <c:if test="${ studentGrade.grade == 'F' }">selected</c:if>>F</option>
						</select>
					</td>
					<td>
						<button type="submit" class="btn btn-primary btn-sm">
							입력
						</button>
					</td>
				</form>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>
<!-- End of Lecture Content Area -->
<%@ include file="../layout/lecture_footer.jsp" %>
		
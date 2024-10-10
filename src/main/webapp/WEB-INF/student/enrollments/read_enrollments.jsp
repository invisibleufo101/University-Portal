<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
<!-- Start of Portal Content Area -->
<div class="col-9">
	<div class="border border-2 rounded-3 shadow">
	
		<!-- Start of Available Course Enrollments -->
		<div class="p-3">
			<div class="text-center mb-4 mx-3">			
				<h2>나의 수강 목록</h2>
			</div>
			
			<div class="d-flex align-items-center mb-3">				
				<button class="ms-1 btn btn-secondary d-flex align-items-center justify-content-between" type="button" onclick="location.href='/student-enrollment-registration.do'">
					<svg class="pe-none me-2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" height="18" width="18">
						<path fill-rule="evenodd" d="M2.625 6.75a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0Zm4.875 0A.75.75 0 0 1 8.25 6h12a.75.75 0 0 1 0 1.5h-12a.75.75 0 0 1-.75-.75ZM2.625 12a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0ZM7.5 12a.75.75 0 0 1 .75-.75h12a.75.75 0 0 1 0 1.5h-12A.75.75 0 0 1 7.5 12Zm-4.875 5.25a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0Zm4.875 0a.75.75 0 0 1 .75-.75h12a.75.75 0 0 1 0 1.5h-12a.75.75 0 0 1-.75-.75Z" clip-rule="evenodd" />
					</svg>
					전체 수강 목록
				</button>
			</div>
		
			<table class="table table-hover text-center w-100 overflow-y-hidden" style="table-layout: fixed;">
				<thead class="table-dark sticky-top top-0 pt-3 bg-white">
					<tr>
						<th scope="col">구분</th>
						<th scope="col" colspan="3">교과목명</th>
						<th scope="col">담당 교수</th>
						<th scope="col">학점</th>
						<th scope="col">현재 인원</th>
						<th scope="col">수강 인원</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${ empty registeredCourses }">
					<tr>
						<td class="p-5" colspan="8">조회할 결과가 없습니다</td>
					</tr>
					</c:if>
					<c:forEach var="registeredCourse" items="${ registeredCourses }">
					<tr class="fs-6">
						<td>${ registeredCourse.courseType }</td>
						<td colspan="3">${ registeredCourse.courseName }</td>
						<td>${ registeredCourse.name }</td>
						<td>${ registeredCourse.weightedPoints }</td>
						<td>${ registeredCourse.currentlyEnrolled }</td>
						<td>${ registeredCourse.enrollmentCapacity }</td>
<!-- 						<td class="text-center"> -->
<!-- 							<form action="#" method="POST"> -->
<%-- 								<input type="hidden" name="enrollment_id" value="${ registeredCourse.id }"/>		 --%>
<!-- 								<button type="submit" class="icon-link bg-transparent border-0"> -->
<!-- 									<svg class="text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" height="16" width="16"> -->
<!-- 										<path fill-rule="evenodd" d="M5.47 5.47a.75.75 0 0 1 1.06 0L12 10.94l5.47-5.47a.75.75 0 1 1 1.06 1.06L13.06 12l5.47 5.47a.75.75 0 1 1-1.06 1.06L12 13.06l-5.47 5.47a.75.75 0 0 1-1.06-1.06L10.94 12 5.47 6.53a.75.75 0 0 1 0-1.06Z" clip-rule="evenodd" /> -->
<!-- 									</svg> -->
<!-- 								</button> -->
<!-- 							</form> -->
<!-- 						</td> -->
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<!-- End of Available Course Enrollments -->

	</div>
</div>
<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->
</div>
	
</body>
</html>
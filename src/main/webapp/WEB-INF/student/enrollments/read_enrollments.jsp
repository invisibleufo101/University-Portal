<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
<!-- Start of Portal Content Area -->
<div class="col-9">
	<div class="border border-2 rounded-3 shadow">
	
		<!-- Start of Available Course Enrollments -->
		<div class="p-3">
			<div class="text-center m-3">			
				<h2>나의 수강 목록</h2>
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
						<th scope="col">수강 취소</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="registeredCourse" items="${ registeredCourses }">
					<tr class="fs-6">
						<td>${ registeredCourse.courseType }</td>
						<td colspan="3">${ registeredCourse.courseName }</td>
						<td>${ registeredCourse.name }</td>
						<td>${ registeredCourse.weightedPoints }</td>
						<td>${ registeredCourse.currentlyEnrolled }</td>
						<td>${ registeredCourse.enrollmentCapacity }</td>
						<td class="text-center">
							<form action="#" method="POST">
								<input type="hidden" name="enrollment_id" value="${ registeredCourse.id }"/>		
								<button type="submit" class="icon-link bg-transparent border-0">
									<svg class="text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" height="16" width="16">
										<path fill-rule="evenodd" d="M5.47 5.47a.75.75 0 0 1 1.06 0L12 10.94l5.47-5.47a.75.75 0 1 1 1.06 1.06L13.06 12l5.47 5.47a.75.75 0 1 1-1.06 1.06L12 13.06l-5.47 5.47a.75.75 0 0 1-1.06-1.06L10.94 12 5.47 6.53a.75.75 0 0 1 0-1.06Z" clip-rule="evenodd" />
									</svg>
								</button>
							</form>
						</td>
					</tr>
					</c:forEach>
					
				<!-- End of Account List -->
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
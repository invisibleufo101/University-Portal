<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
<!-- Start of Portal Content Area -->
<div class="col-9">
	<div class="border border-2 rounded-3 shadow">
	
		<!-- Start of Available Course Enrollments -->
		<div class="p-3">
			<h2 class="m-3">수강 신청</h2>
			
			<div class="text-center mb-4 mx-3">			
				<p class="fs-5">신청 가능한 교과목들</p>
			</div>
			
<!-- 			<form action="#" method="GET"> -->
				<!-- View My Registered Courses -->
				<div class="d-flex align-items-center mb-3">				
					<button class="ms-1 btn btn-success d-flex align-items-center justify-content-between" type="button" onclick="location.href='/student-enrollment-read.do'">
						<svg class="pe-none me-2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" height="18" width="18">
							<path fill-rule="evenodd" d="M2.625 6.75a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0Zm4.875 0A.75.75 0 0 1 8.25 6h12a.75.75 0 0 1 0 1.5h-12a.75.75 0 0 1-.75-.75ZM2.625 12a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0ZM7.5 12a.75.75 0 0 1 .75-.75h12a.75.75 0 0 1 0 1.5h-12A.75.75 0 0 1 7.5 12Zm-4.875 5.25a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0Zm4.875 0a.75.75 0 0 1 .75-.75h12a.75.75 0 0 1 0 1.5h-12a.75.75 0 0 1-.75-.75Z" clip-rule="evenodd" />
						</svg>
						나의 수강 목록
					</button>
					
					<div class="ms-auto col-auto">
						<div class="input-group">
							<div class="w-10">
								<select class="form-select border rounded-start border-secondary" style="border-radius: 0;" name="search_student_enrollment_category">
									<option value="course_type" <c:if test=""> selected </c:if>>구분</option>
									<option value="course_name" <c:if test=""> selected </c:if>>교과목명</option>
									<option value="professor_id" <c:if test=""> selected </c:if>>담당 교수</option>
									<option value="weighted_points" <c:if test=""> selected </c:if>>학점</option>
								</select>
							</div>

							<input type="search" class="form-control border border-secondary" 
								   id="search_student_enrollment_keyword" 
								   name="search_student_enrollment_keyword" 
								   placeholder="검색" 
								   value=""/>
						</div>
					</div>
					<div class="ms-1 col-auto">
						<button type="submit" class="btn btn-primary d-flex justify-content-center align-items-center">
							<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" height="24" width="24">
								<path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
							</svg>
						</button>
					</div>
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
						<th scope="col">신청</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${ empty availableCourses }">
					<tr>
						<td colspan="9">신청할 수 있는 교과목들이 없습니다.</td>
					</tr>
					</c:if>
					<c:forEach var="availableCourse" items="${ availableCourses }">
					<tr class="fs-6">
						<td>${ availableCourse.courseType }</td>
						<td colspan="3">${ availableCourse.courseName }</td>
						<td>${ availableCourse.name }</td>
						<td>${ availableCourse.weightedPoints }</td>
						<td>${ availableCourse.currentlyEnrolled }</td>
						<td>${ availableCourse.enrollmentCapacity }</td>
						<td class="text-center">
							<form action="/student-enrollment-add.do" method="POST">
								<input type="hidden" name="enrollment_id" value="${ availableCourse.id }"/>		
								<button type="submit" class="icon-link btn bg-primary">
									<svg class="text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" height="16" width="16">
										<path stroke-linecap="round" stroke-linejoin="round" d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L10.582 16.07a4.5 4.5 0 0 1-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 0 1 1.13-1.897l8.932-8.931Zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0 1 15.75 21H5.25A2.25 2.25 0 0 1 3 18.75V8.25A2.25 2.25 0 0 1 5.25 6H10" />
									</svg>
								</button>
							</form>
						</td>
					</tr>
					</c:forEach>
					
				<!-- End of Account List -->
				</tbody>
			</table>
<!-- 			</form> -->
		</div>
		<!-- End of Available Course Enrollments -->

	</div>
</div>
<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->
</div>

<div id="error_modal" class="modal fade" tabindex="-1">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">포털 시스템 메세지</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div> 
			<div class="modal-body text-center">
				<p class="fs-5">수강 인원 만석으로 신청할 수 없는 교과목입니다.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-secondary" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<script>
	document.addEventListener('DOMContentLoaded', () => {
		const errorModal = new bootstrap.Modal(document.getElementById("error_modal"));
		const errorStatus = '${errorStatus}' === 'true' ? 'true' : 'false';
		if (errorStatus === 'true'){
			errorModal.show();
		}
	});
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
		
	<!-- Start of Portal Content Area -->
	<div class="col-9 border border-2 rounded-3 shadow p-3">
		<h3 class="text-center">수강 관리</h3>
		
		<!-- Start of Enrollment Management -->
		<div class="p-5">
			<form action="/enrollment-management.do" method="GET">
				<div class="row g-3 justify-content-end align-items-center mb-3">
					<div class="me-auto col-auto d-flex align-items-center mt-3 g-2">
						<!-- Register Enrollment Button -->
						<button class="ms-1 btn btn-success d-flex align-items-center justify-content-between" type="button" onclick="location.href='/enrollment-register.do'">
							<svg class="pe-none me-2" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" height="18" width="18">
								<path stroke-linecap="round" stroke-linejoin="round" d="M12 9v6m3-3H9m12 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
							</svg>
							수강 등록
						</button>
					</div>

					<div class="col-auto">
						<div class="input-group">
							<div class="w-10">
								<select class="form-select border rounded-start border-secondary" style="border-radius: 0;" name="search_enrollment_category">
									<option value="course_name" <c:if test="${ searchEnrollmentCategory == 'course_name' }"> selected </c:if>>교과목명</option>
									<option value="name" <c:if test="${ searchEnrollmentCategory == 'name' }"> selected </c:if>>담당 교수</option>
									<option value="weighted_points" <c:if test="${ searchEnrollmentCategory == 'weighted_points' }"> selected </c:if>>학점</option>
								</select>
							</div>

							<input type="search" class="form-control border border-secondary" id="search_keyword" name="search_enrollment_keyword" placeholder="검색" value="${ searchEnrollmentKeyword }">
						</div>
					</div>
					<div class="col-auto">
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
							<th scope="col">교과목명</th>
							<th scope="col">구분</th>
							<th scope="col">담당 교수</th>
							<th scope="col">학점</th>
							<th scope="col">수강 인원</th>
							<th scope="col">수정 | 삭제</th>
						</tr>
					</thead>
					<tbody>
					
						<c:if test="${ empty enrollments }">
							<td colspan="6" class="p-5">조회할 결과가 없습니다</td>
						</c:if>
						
						<c:forEach var="enrollment" items="${ enrollments }">
						<tr>
							<td style="text-align: left; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${ enrollment.courseName }</td>
							<td>${ enrollment.courseType }</td>
							<td>${ enrollment.name }</td>
							<td>${ enrollment.weightedPoints }</td>
							<td>${ enrollment.enrollmentCapacity }</td>
							<td>
								<a href="/enrollment-read.do?id=${ enrollment.id }" class="me-2 icon-link icon-link-hover text-primary">
									<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" width="18" height="18">
										<path stroke-linecap="round" stroke-linejoin="round" d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L6.832 19.82a4.5 4.5 0 0 1-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 0 1 1.13-1.897L16.863 4.487Zm0 0L19.5 7.125" />
									</svg>
								</a>
								
								<a href="/enrollment-delete.do?id=${ enrollment.id }" class="me-2 icon-link icon-link-hover text-danger">
									<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" width="18" height="18">
										<path stroke-linecap="round" stroke-linejoin="round" d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0" />
									</svg>
								</a>
							</td>
						</tr>
						</c:forEach>
					<!-- End of Enrollment List -->
					</tbody>
				</table>
			</form>
		</div>
		<!-- End of Enrollment Management -->
		
	</div>
	<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->

<footer>

</footer>
</div>
</body>
</html>







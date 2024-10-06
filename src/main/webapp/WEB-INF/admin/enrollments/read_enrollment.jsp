<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
		
	<!-- Start of Portal Content Area -->
	<div class="col-9 border border-2 rounded-3 shadow p-3">
		<h3 class="text-center">수강 교과목 상세 정보</h3>
		<div class="p-5">
			<form action="/enrollment-edit.do" method="POST">
				<input type="hidden" name="update_id" value="${ enrollment.id }">
				
				<!-- Update Course Id -->
				<div class="mb-3">
					<label for="update_course_id" class="form-label">교과목명</label>					
					<span id="update_course_id" class="form-control bg-secondary-subtle">${ enrollment.courseName }</span>
				</div>
				
				<!-- Update Professor Id -->
				<div class="mb-3">
					<label for="update_professor_id" class="form-label">담당 교수</label>					
					<select class="form-select ${ !empty errors['professorId'] ? 'border border-danger' : '' }" name="professor_id" id="update_professor_id">
						<c:forEach var="professor" items="${ professors }">
							<option value="${ professor.id }" <c:if test="${ enrollment.professorId == professor.id }">selected</c:if>>${ professor.name }</option>
						</c:forEach>
					</select>
					<c:if test="${ !empty errors['professorId'] }">
						<span class="fs-6 text-danger">${ errors['professorId'] }</span>
					</c:if>
				</div>
				
				<!-- Update Weighted Points -->
  				<div class="mb-3">
					<label for="update_weighted_points" class="form-label">학점</label>
					<select name="weighted_points" class="form-select ${ !empty errors['weightedPoints'] ? 'border border-danger' : '' }" id="update_weighted_points" class="form-select">
						<option value="3" <c:if test="${ enrollment.weightedPoints == '3' }">selected</c:if>>3</option>
						<option value="2" <c:if test="${ enrollment.weightedPoints == '2' }">selected</c:if>>2</option>
						<option value="1" <c:if test="${ enrollment.weightedPoints == '1' }">selected</c:if>>1</option>
					</select>
					<c:if test="${ !empty errors['weightedPoints'] }">
						<span class="fs-6 text-danger">${ errors['weightedPoints'] }</span>
					</c:if>
  				</div>
  				
  				<!-- Update Enrollment Capacity -->
  				<div class="mb-3">
					<label for="update_enrollment_capacity" class="form-label">수강 인원</label>
					<input type="text" class="form-control ${ !empty errors['enrollmentCapacity'] ? 'border border-danger' : '' }" name="enrollment_capacity" id="update_enrollment_capacity" value="${ enrollment.enrollmentCapacity }"/>
					<c:if test="${ !empty errors['enrollmentCapacity'] }">
						<span class="fs-6 text-danger">${ errors['enrollmentCapacity'] }</span>
					</c:if>
  				</div>
  								
				<!-- Submit -->
				<div class="d-flex gap-2 justify-content-center">
					<button class="d-block w-100 btn btn-primary" type="submit">수강 교과목 수정</button>
					<button data-bs-toggle="button" class="d-block w-100 btn btn-secondary" type="reset" onclick="location.href='/enrollment-management.do'">뒤로 가기</button>
				</div>
			</form>
		</div>
	</div>
	<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->

<footer>

</footer>
</div>
</body>
</html>









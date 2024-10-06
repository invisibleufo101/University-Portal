<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
		
	<!-- Start of Portal Content Area -->
	<div class="col-9 border border-2 rounded-3 shadow p-3">
		<h3 class="text-center">수강 등록</h3>
		<div class="p-5">
			<form action="/enrollment-add.do" method="POST">
			
				<!-- Register Course Id -->
				<div class="mb-3">
					<label for="register_course_id" class="form-label">교과목명</label>		
					<select name="course_id" id="register_course_id" class="form-select ${ !empty errors['courseId'] ? 'border border-danger' : '' }"> 
						<option value="">선택</option>
						<c:forEach var="course" items="${ courses }">
							<option value="${ course.id }" <c:if test="${ oldInputs['course_id'] == course.id }">selected</c:if>>${ course.courseName }</option>
						</c:forEach>
					</select>			
					<c:if test="${ !empty errors['courseId'] }">
						<span class="fs-6 text-danger">${ errors['courseId'] }</span>
					</c:if>
				</div>
								
				<!-- Register Professor -->
				<div class="mb-3">
					<label for="register_professor_id" class="form-label">담당 교수</label>					
					<select name="professor_id" id="register_professor_id" class="form-select ${ !empty errors['professorId'] ? 'border border-danger' : '' }">
						<option value="">선택</option>
						<c:forEach var="professor" items="${ professors }">
							<option value="${ professor.id }" <c:if test="${ oldInputs['professor_id'] == professor.id }">selected</c:if> >${ professor.name }</option>
						</c:forEach>
					</select>
					<c:if test="${ !empty errors['professorId'] }">
						<span class="fs-6 text-danger">${ errors['professorId'] }</span>
					</c:if>
				</div>
				
				<!-- Register Weighted Points -->
  				<div class="mb-3">
					<label for="register_weighted_points" class="form-label">학점</label>
					<select name="weighted_points" id="register_weighted_points" class="form-select ${ !empty errors['weightedPoints'] ? 'border border-danger' : '' }">
						<option value="">선택</option>
						<option value="3" <c:if test="${ oldInputs['weighted_points'] == '3' }">selected</c:if>>3</option>
						<option value="2" <c:if test="${ oldInputs['weighted_points'] == '2' }">selected</c:if>>2</option>
						<option value="1" <c:if test="${ oldInputs['weighted_points'] == '1' }">selected</c:if>>1</option>
					</select>
					<c:if test="${ !empty errors['weightedPoints'] }">
						<span class="fs-6 text-danger">${ errors['weightedPoints'] }</span>
					</c:if>
  				</div>
  				
  				<!-- Register Enrollment Capacity -->
  				<div class="mb-3">
					<label for="register_enrollment_capacity" class="form-label">수강 인원</label>
					<input type="text" name="enrollment_capacity" id="register_enrollment_capacity" class="form-control ${ !empty errors['enrollmentCapacity'] ? 'border border-danger' : '' }"
					value="${ !empty oldInputs['enrollment_capacity'] ? oldInputs['enrollment_capacity'] : '' }"/>
					<c:if test="${ !empty errors['enrollmentCapacity'] }">
						<span class="fs-6 text-danger">${ errors['enrollmentCapacity'] }</span>
					</c:if>
  				</div>
  								
				<div class="d-flex gap-2 justify-content-center">
				  <button class="d-block w-100 btn btn-primary" type="submit">수강 등록</button>
				  <button data-bs-toggle="button" class="d-block w-100 btn btn-secondary" type="reset" onclick="location.href='/enrollment-management.do'">뒤로 가기</button>
				</div>
			</form>
		</div>
	</div>
		<!-- End of Student List -->
	<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->

<footer>

</footer>
</div>
</body>
</html>







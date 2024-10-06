<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
		
	<!-- Start of Portal Content Area -->
	<div class="col-9 border border-2 rounded-3 shadow p-3">
		<h3 class="text-center">계정 상세 정보</h3>
		<div class="p-5">
			<form action="/account-edit.do" method="POST">
				<input type="hidden" name="update_school_id" value="${ readUser.schoolId }">
				<div class="mb-3">
					<label for="register_role_id" class="form-label">계정 구분</label>					
					<span class="form-control bg-secondary-subtle">${readUser.roleName }</span>
				</div>
				
				<div class="mb-3">
					<label for="update_major_id" class="form-label">학과</label>					
					<select class="form-select " name="update_major_id">
						<c:forEach var="major" items="${ majors }">					
							<option value="${ major.id }" <c:if test="${ readUser.majorId == major.id }">selected</c:if>>${ major.majorName }</option>
						</c:forEach>
					</select>
					
					<c:if test="${ !empty errors['majorId'] }">
						<span class="fs-6 text-danger">${ errors['majorId'] }</span>
					</c:if>
				</div>
				
				<!-- Register Name -->
  				<div class="mb-3">
					<label for="register_name" class="form-label">이름</label>
					<span class="form-control bg-secondary-subtle">${ readUser.name }</span>
  				</div>
  				
  				<div class="mb-3">
					<label for="register_name" class="form-label">학번/교번</label>
					<span class="form-control bg-secondary-subtle">${ readUser.schoolId }</span>
  				</div>
  				
  				<!-- Register BirthDate -->
  				<div class="mb-3">
					<label for="register_birth_date" class="form-label">생년월일</label>
					<span class="form-control bg-secondary-subtle">${ readUser.birthDate }</span>
  				</div>
  				
  				<div class="mb-3">
					<label for="register_email" class="form-label">이메일</label>
					<span class="form-control bg-secondary-subtle">${ readUser.email }</span>
  				</div>
  				
  				<div class="mb-3">
					<label for="register_phone_number" class="form-label">전화번호</label>
					<span class="form-control bg-secondary-subtle">${ readUser.phoneNumber }</span>
  				</div>
  								
				<div class="d-flex gap-2 justify-content-center">
				  <button class="d-block w-100 btn btn-primary" type="submit">계정 수정</button>
				  <button data-bs-toggle="button" class="d-block w-100 btn btn-secondary" type="reset" onclick="location.href='/account-management.do'">뒤로 가기</button>
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









<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
		
	<!-- Start of Portal Content Area -->
	<div class="col-9 border border-2 rounded-3 shadow p-3">
		<h3 class="text-center">계정 등록</h3>
		<div class="p-5">
			<form action="/account-add.do" method="POST">
				<!-- Register Role Id -->
				<div class="mb-3">
					<label for="register_role_id" class="form-label">계정 구분</label>					
					<select class="form-select ${ !empty errors['roleId'] ? 'border border-danger' : '' }" name="register_role_id">
						<option value="1">관리자</option>
						<option value="2">학생</option>
						<option value="3">교수</option>
					</select>
					
					<c:if test="${ !empty errors['roleId'] }"> 
						<span class="fs-6 text-danger">${ errors['roleId'] }</span>
					</c:if>
				</div>
				
				<!-- Register Major Id -->
				<div class="mb-3">
					<label for="register_major_id" class="form-label">학과</label>					
					<select class="form-select ${ !empty errors['majorId'] ? 'border border-danger' : '' }" name="register_major_id">
						<c:forEach var="major" items="${ majors }">
						<option value="${ major.id }">${ major.majorName }</option>
						</c:forEach>
					</select>
					
					<c:if test="${ !empty errors['majorId'] }">
						<span class="fs-6 text-danger">${ errors['majorId'] }</span>
					</c:if>
				</div>
				
				<!-- Register Name -->
  				<div class="mb-3">
					<label for="register_name" class="form-label">이름</label>
					<input type="text" class="form-control ${ !empty errors['name'] ? 'border border-danger' : '' }" id="register_name" name="register_name" placeholder="이름 (한글 2-7 글자)" 
						value="${ !empty oldInputs['register_name'] ? oldInputs['register_name'] : ''}"/>
					<c:if test="${ !empty errors['name'] }">
						<span class="fs-6 text-danger">${ errors['name'] }</span>
					</c:if>
  				</div>
  				
  				<!-- Register BirthDate -->
  				<div class="mb-3">
					<label for="register_birth_date" class="form-label">생년월일</label>
					<input type="date" class="form-control ${ !empty errors['birthDate'] ? 'border border-danger' : '' }" id="register_birth_date" name="register_birth_date" placeholder="생년월일"
					value="${ !empty oldInputs['register_birth_date'] ? oldInputs['register_birth_date'] : '' }"/>
	  				<c:if test="${ !empty errors['birthDate'] }">
	  					<span class="fs-6 text-danger">${ errors['birthDate'] }</span>
	  				</c:if>
  				</div>
  				
  				<!-- Register Email -->
  				<div class="mb-3">
					<label for="register_email" class="form-label">이메일</label>
					<input type="text" class="form-control ${ !empty errors['email'] ? 'border border-danger' : '' } " id="register_email" name="register_email" placeholder="이메일 (example@university.edu))"
					value="${ !empty oldInputs['register_email'] ? oldInputs['register_email'] : '' }"/>
					<c:if test="${ !empty errors['email'] }">
						<span class="fs-6 text-danger">${ errors['email'] }</span>
					</c:if>
  				</div>
  				
  				<!-- Register Phone Number -->
  				<div class="mb-3">
					<label for="register_phone_number" class="form-label">전화번호</label>
					<input type="text" class="form-control ${ !empty errors['phoneNumber'] ? 'border border-danger' : '' }" id="register_phone_number" name="register_phone_number" placeholder="전화번호 (010-1234-5678)"
					value="${ !empty oldInputs['register_phone_number'] ? oldInputs['register_phone_number'] : ''}"/>
					<c:if test="${ !empty errors['phoneNumber'] }">
						<span class="fs-6 text-danger">${ errors['phoneNumber'] }</span>
					</c:if>
  				</div>
  								
  				<!-- Form Submit -->
				<div class="d-flex gap-2 justify-content-center">
				  <button class="d-block w-100 btn btn-primary" type="submit">계정 등록</button>
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





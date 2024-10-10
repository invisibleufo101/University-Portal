<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>
		
	<!-- Start of Portal Content Area -->
	<div class="col-9 border border-2 rounded-3 shadow p-3">
		<h3 class="text-center">계정 관리</h3>
		
		<!-- Start of Account Management -->
		<div class="p-5">
			<form action="#" method="GET">
				<div class="row g-3 justify-content-end align-items-center mb-3">
					<div class="me-auto col-auto d-flex align-items-center mt-3 g-2">
						<!-- Add Accounts Button -->
						<button class="ms-1 btn btn-success d-flex align-items-center justify-content-between" type="button" onclick="location.href='/account-register.do'">
							<svg class="pe-none me-2" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" height="18" width="18"> 
								<path stroke-linecap="round" stroke-linejoin="round" d="M18 7.5v3m0 0v3m0-3h3m-3 0h-3m-2.25-4.125a3.375 3.375 0 1 1-6.75 0 3.375 3.375 0 0 1 6.75 0ZM3 19.235v-.11a6.375 6.375 0 0 1 12.75 0v.109A12.318 12.318 0 0 1 9.374 21c-2.331 0-4.512-.645-6.374-1.766Z" />  
							</svg>
							계정 등록
						</button>
					</div>
				</div>
<!-- 					<div class="col-auto"> -->
<!-- 						<div class="input-group"> -->
<!-- 							<div class="w-10"> -->
<!-- 								<select class="form-select border rounded-start border-secondary" style="border-radius: 0;" name="search_category"> -->
<!-- 									<option value="search_role_id">계정 구분</option> -->
<!-- 									<option value="search_school_id">학번</option> -->
<!-- 									<option value="search_account_name">이름</option> -->
<!-- 									<option value="search_major">학과</option> -->
<!-- 								</select> -->
<!-- 							</div> -->

<!-- 							<input type="search" class="form-control border border-secondary" id="search_student_keyword" name="search_keyword" placeholder="검색" value=""> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-auto"> -->
<!-- 						<button type="submit" class="btn btn-primary d-flex justify-content-center align-items-center" name="action" value="search"> -->
<!-- 							<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" height="24" width="24"> -->
<!-- 								<path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" /> -->
<!-- 							</svg> -->
<!-- 						</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
				<table class="table table-hover text-center w-100 overflow-y-hidden" style="table-layout: fixed;">
					<thead class="table-dark sticky-top top-0 pt-3 bg-white">
						<tr>
							<th scope="col">계정 구분</th>
							<th scope="col">학번/교번</th>
							<th scope="col">이름</th>
							<th scope="col">학과</th>
							<th scope="col">수정</th>
						</tr>
					</thead>
					<tbody>
	
						<c:if test="${ empty users }">
							<td colspan="6" class="p-5">조회할 결과가 없습니다</td>
						</c:if>				
						<!-- Start of Account List -->
						<c:forEach var="account" items="${users}">
						<tr>
							<td>${ account.roleName }</td>
							<td>${ account.schoolId }</td>
							<td>${ account.name }</td>
							<td>${ account.majorName }</td>
							<td>
								<a href="/account-read.do?schoolId=${ account.schoolId }" class="me-2 icon-link icon-link-hover text-primary">
									<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" width="18" height="18">
										<path stroke-linecap="round" stroke-linejoin="round" d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L6.832 19.82a4.5 4.5 0 0 1-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 0 1 1.13-1.897L16.863 4.487Zm0 0L19.5 7.125" />
									</svg>
								</a>
							</td>
						</tr>
						</c:forEach>
					<!-- End of Account List -->
					</tbody>
				</table>
			</form>
		</div>
		<!-- End of Account Management -->
		
	</div>
	<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->

<footer>

</footer>
</div>
</body>
</html>







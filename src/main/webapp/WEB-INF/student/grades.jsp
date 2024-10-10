<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp" %>
<%@ include file="./layout/sidebar.jsp" %>
<!-- Start of Portal Content Area -->
<div class="col-9">
	<div class="border border-2 rounded-3 shadow">
		
		<div class="p-3">
			<h2 class="m-3 mb-3">성적 조회</h2>
			
			<table class="table table-hover text-center w-100 overflow-y-hidden" style="table-layout: fixed;">
					<thead class="table-dark sticky-top top-0 pt-3 bg-white">
						<tr>
							<th scope="col">구분</th>
							<th scope="col">교과목명</th>
							<th scope="col">담당 교수</th>
							<th scope="col">성적</th>
						</tr>
					</thead>
					<tbody>
	
						<c:if test="${ empty grades }">
						<tr>
							<td colspan="4" class="p-5">등록된 성적이 없습니다</td>
						</tr>
						</c:if>
						
						<!-- Start of Student Grades List -->
						<c:forEach var="grade" items="${ grades }">						
						<tr>
							<td>${ grade.courseType }</td>
							<td>${ grade.courseName }</td>
							<td>${ grade.name }</td>
							<td>${ grade.grade }</td>
						</tr>
						</c:forEach>
						
					<!-- End of Student Grades List -->
					</tbody>
				</table>
		</div>
		
	</div>
</div>
<!-- End of Portal Content Area -->
</main>
<!-- End of Portal Dashboard -->
</div>
	
</body>
</html>
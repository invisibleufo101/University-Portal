<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/lecture_header.jsp" %>
<!-- Start of Lecture Content Area -->
<div class="col-9 p-3">
	<div class="d-flex justify-content-end">
		<button type="button" class="btn" onclick="location.href='/professor-lectures.do'">
			<svg height="30" width="30" "w-25 h-25" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
				<path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12" />
			</svg>
		</button>
	</div>
	<div class="m-3">				
		<h2>공지 사항</h2>
	</div>
	
	<div class="row g-3 justify-content-end align-items-center mb-3">
		<div class="ms-auto me-2 col-auto d-flex align-items-center mt-3 g-2">
			
		</div>
	</div>
	<table class="table table-hover text-center w-100 overflow-y-hidden" style="table-layout: fixed;">
		<thead class="table-dark sticky-top top-0 pt-3 bg-white">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">수정</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>수업 필수 품목들</td>
				<td>
				
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- End of Lecture Content Area -->
<%@ include file="../layout/lecture_footer.jsp" %>
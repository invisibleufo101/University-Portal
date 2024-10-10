<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/lecture_header.jsp" %>
<!-- Start of Lecture Content Area -->
<div class="col-9 p-3">
	<div class="m-3">				
		<h2>성적 관리</h2>
	</div>
	
	<div class="row g-3 justify-content-end align-items-center mb-3">
		<div class="ms-auto me-2 col-auto d-flex align-items-center mt-3 g-2">
			
		</div>
	</div>
	<table class="table table-hover text-center w-100 overflow-y-hidden" style="table-layout: fixed;">
		<thead class="table-dark sticky-top top-0 pt-3 bg-white">
			<tr>
				<th scope="col">학번</th>
				<th scope="col">이름</th>
				<th scope="col">성적</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2024123412</td>
				<td>홍길동</td>
				<form action="" method="">
					<td>
						
						<select name="" id="" class="form-select form-select-sm text-center">
							<option value="">선택</option>
							<option value="">A+</option>
							<option value="">A0</option>
							<option value="">A-</option>
							<option value="">B+</option>
							<option value="">B0</option>
							<option value="">B-</option>
							<option value="">C+</option>
							<option value="">C0</option>
							<option value="">C-</option>
							<option value="">D+</option>
							<option value="">D0</option>
							<option value="">D-</option>
							<option value="">F</option>
						</select>
					</td>
					<td>
						<button type="submit" class="btn btn-primary btn-sm">
							입력
						</button>
					</td>
				</form>
			</tr>
		</tbody>
	</table>
</div>
<!-- End of Lecture Content Area -->
<%@ include file="../layout/lecture_footer.jsp" %>
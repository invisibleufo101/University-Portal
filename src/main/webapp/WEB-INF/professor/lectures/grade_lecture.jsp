<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script defer src="js/bootstrap.bundle.min.js"></script>
	<title>교수자 포털</title>
</head>
<body class="vh-100 d-flex justify-content-center align-items-center bg-dark">
	<main>
		<!-- Start of Lecture Page -->
		<div class="row bg-white" style="height: 75vh; width: 80vw;">
			<!-- Start of Lecture Sidebar -->
			<div class="col-3">
				<div class="h-100 d-flex flex-column p-3 border-end bg-body-tertiary">
					<div class="fw-bold fs-4 text-center border-bottom border-2">
						교과목 이름
					</div>
					<ul class="nav nav-pills flex-column mt-2 mb-auto fs-6" >
						<!-- Announcements -->
						<li class="nav-item mb-2">
							<a href="#" class="nav-link link-body-emphasis">
								<span class="d-flex align-items-center">								
									<svg class="pe-none me-2" height="20" width="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
										<path stroke-linecap="round" stroke-linejoin="round" d="M10.34 15.84c-.688-.06-1.386-.09-2.09-.09H7.5a4.5 4.5 0 1 1 0-9h.75c.704 0 1.402-.03 2.09-.09m0 9.18c.253.962.584 1.892.985 2.783.247.55.06 1.21-.463 1.511l-.657.38c-.551.318-1.26.117-1.527-.461a20.845 20.845 0 0 1-1.44-4.282m3.102.069a18.03 18.03 0 0 1-.59-4.59c0-1.586.205-3.124.59-4.59m0 9.18a23.848 23.848 0 0 1 8.835 2.535M10.34 6.66a23.847 23.847 0 0 0 8.835-2.535m0 0A23.74 23.74 0 0 0 18.795 3m.38 1.125a23.91 23.91 0 0 1 1.014 5.395m-1.014 8.855c-.118.38-.245.754-.38 1.125m.38-1.125a23.91 23.91 0 0 0 1.014-5.395m0-3.46c.495.413.811 1.035.811 1.73 0 .695-.316 1.317-.811 1.73m0-3.46a24.347 24.347 0 0 1 0 3.46" />
									</svg>
									공지 사항
								</span>
							</a>
						</li>
						
						<!-- Lecture Materials -->
						<li class="nav-item mb-2">
							<a href="#" class="nav-link link-body-emphasis">
								<span class="d-flex align-items-center">								
									<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
										<path stroke-linecap="round" stroke-linejoin="round" d="M2.25 12.75V12A2.25 2.25 0 0 1 4.5 9.75h15A2.25 2.25 0 0 1 21.75 12v.75m-8.69-6.44-2.12-2.12a1.5 1.5 0 0 0-1.061-.44H4.5A2.25 2.25 0 0 0 2.25 6v12a2.25 2.25 0 0 0 2.25 2.25h15A2.25 2.25 0 0 0 21.75 18V9a2.25 2.25 0 0 0-2.25-2.25h-5.379a1.5 1.5 0 0 1-1.06-.44Z" />
									</svg>
									강의 자료
								</span>
							</a>
						</li>
						
						<!-- Manage Student Grades -->
						<li class="nav-item mb-2">
							<a href="#" class="nav-link link-body-emphasis">
								<span class="d-flex align-items-center">								
									<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
										<path stroke-linecap="round" stroke-linejoin="round" d="M9 12h3.75M9 15h3.75M9 18h3.75m3 .75H18a2.25 2.25 0 0 0 2.25-2.25V6.108c0-1.135-.845-2.098-1.976-2.192a48.424 48.424 0 0 0-1.123-.08m-5.801 0c-.065.21-.1.433-.1.664 0 .414.336.75.75.75h4.5a.75.75 0 0 0 .75-.75 2.25 2.25 0 0 0-.1-.664m-5.8 0A2.251 2.251 0 0 1 13.5 2.25H15c1.012 0 1.867.668 2.15 1.586m-5.8 0c-.376.023-.75.05-1.124.08C9.095 4.01 8.25 4.973 8.25 6.108V8.25m0 0H4.875c-.621 0-1.125.504-1.125 1.125v11.25c0 .621.504 1.125 1.125 1.125h9.75c.621 0 1.125-.504 1.125-1.125V9.375c0-.621-.504-1.125-1.125-1.125H8.25ZM6.75 12h.008v.008H6.75V12Zm0 3h.008v.008H6.75V15Zm0 3h.008v.008H6.75V18Z" />
									</svg>
									성적 관리
								</span>
							</a>
						</li>
						
					</ul>
				</div>
			</div>
			<!-- End of Lecture Sidebar -->
		
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
		</div>
		<!-- End of Lecture Main Page -->
	</main>
</body>
</html>
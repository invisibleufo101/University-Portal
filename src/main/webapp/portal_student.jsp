<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script defer src="js/bootstrap.bundle.min.js"></script>
	<title>포털 메인</title>
</head>
<body>

	<!-- style="max-width: 1800px;" -->
	<div class="container" style="max-width:80vw;">
		<!-- Start of Profile Banner Section -->
			<header>
				<div class="row banner-img">
					<div class="col-lg-12">
						<div class="profile-banner" >
							<div class="profile-intro">
								<div class="profile-area">				
									<!-- Profile Picture -->			
									<div class="profile-picture"></div>
									
									<!-- Profile Info -->
									<div class="d-flex profile-info">
										<h1 class="profile-name">홍길동</h1>
	
										<div class="icon-text ms-2">
											<svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
	  											<path stroke-linecap="round" stroke-linejoin="round" d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z" />
											</svg>
											<span>학부생</span>
										</div>
										
										<div class="icon-text ms-2">
											<svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
	  											<path stroke-linecap="round" stroke-linejoin="round" d="M12 21v-8.25M15.75 21v-8.25M8.25 21v-8.25M3 9l9-6 9 6m-1.5 12V10.332A48.36 48.36 0 0 0 12 9.75c-2.551 0-5.056.2-7.5.582V21M3 21h18M12 6.75h.008v.008H12V6.75Z" />
											</svg>
											<span>경영학과</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<!-- End of Profile Banner Section -->
			<!-- Start of Portal Dashboard -->
			<main class="row" style="margin-top: 7rem; margin-bottom: 7rem;">
				<!-- Start of Portal Navbar -->
				<div class="col-3" >
					<div class="d-flex flex-column p-3 bg-body-tertiary border border-2 rounded-3 shadow">
						<ul class="nav nav-pills flex-column mb-auto fs-5" >
							<!-- Home -->
							<li class="nav-item mb-2 border-bottom border-secondary-subtle">
								<a href="#" class="nav-link active">
									<span class="d-flex align-items-center">								
										<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
			  								<path stroke-linecap="round" stroke-linejoin="round" d="m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
										</svg>
										홈
									</span>
								</a>
							</li>
							
							<!-- Enrolled Courses -->
							<li class="nav-item mb-2">
								<a href="#" class="nav-link link-body-emphasis">
									<span class="d-flex align-items-center">								
										<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
			  								<path stroke-linecap="round" stroke-linejoin="round" d="M12 6.042A8.967 8.967 0 0 0 6 3.75c-1.052 0-2.062.18-3 .512v14.25A8.987 8.987 0 0 1 6 18c2.305 0 4.408.867 6 2.292m0-14.25a8.966 8.966 0 0 1 6-2.292c1.052 0 2.062.18 3 .512v14.25A8.987 8.987 0 0 0 18 18a8.967 8.967 0 0 0-6 2.292m0-14.25v14.25" />
										</svg>
										수업
									</span>
								</a>
							</li>
							
							<!-- Grades -->
							<li class="nav-item mb-2">
								<a href="#" class="nav-link link-body-emphasis">
									<span class="d-flex align-items-center">
										<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
											<path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
										</svg>
										성적 조회								
									</span>
								</a>
							</li>
							
							<!-- Messages -->
							<li class="nav-item mb-2">
								<a href="#" class="nav-link link-body-emphasis">
									<span class="d-flex align-items-center">
										<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
											<path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z" />
										</svg>
										메세지
									</span>
								</a>
							</li>
							
							<!-- Account -->
							<li class="nav-item mb-2">
								<a href="#" class="nav-link link-body-emphasis">
									<span class="d-flex align-items-center">							
										<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
											<path stroke-linecap="round" stroke-linejoin="round" d="M17.982 18.725A7.488 7.488 0 0 0 12 15.75a7.488 7.488 0 0 0-5.982 2.975m11.963 0a9 9 0 1 0-11.963 0m11.963 0A8.966 8.966 0 0 1 12 21a8.966 8.966 0 0 1-5.982-2.275M15 9.75a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
										</svg>
										내 계정
									</span>
								</a>
							</li>
							
							<!-- Logout -->
							<li class="nav-item mb-2">
								<a href="#" class="nav-link link-body-emphasis">
									<span class="d-flex align-items-center">
										<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
											<path stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0 0 13.5 3h-6a2.25 2.25 0 0 0-2.25 2.25v13.5A2.25 2.25 0 0 0 7.5 21h6a2.25 2.25 0 0 0 2.25-2.25V15M12 9l-3 3m0 0 3 3m-3-3h12.75" />
										</svg>
										로그아웃
									</span>
								</a>
							</li>
							
						</ul>
					</div>
				</div>
				<!-- End of Portal Navbar -->
				
				<!-- Start of Portal Content Area -->
				<div class="col-9">
					<div class="border border-2 rounded-3 shadow">
						<!-- Start of Currently Enrolled Classes -->
						<div class="p-3">
							<h2 class="m-3">나의 강좌</h2>
							<ul class="list-unstyled">
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-info fs-6" style="width: 4rem;">전공</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold m-2">교과목 이름</p>
												<p class="m-2">교수 이름</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-info fs-6" style="width: 4rem;">전공</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold m-2">교과목 이름</p>
												<p class="m-2">교수 이름</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-info fs-6" style="width: 4rem;">전공</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold m-2">교과목 이름</p>
												<p class="m-2">교수 이름</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-warning fs-6" style="width: 4rem;">교양</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold m-2">교과목 이름</p>
												<p class="m-2">교수 이름</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-warning fs-6" style="width: 4rem;">교양</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold m-2">교과목 이름</p>
												<p class="m-2">교수 이름</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-warning fs-6" style="width: 4rem;">교양</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold m-2">교과목 이름</p>
												<p class="m-2">교수 이름</p>
											</div>
										</div>
									</a>
								</li>
								
								
							</ul>
						</div>
						<!-- End of Currently Enrolled Classes -->
						
						<!-- Start of Global Announcements -->
						<div class="p-3">
							<h2 class="m-3">전체 공지</h2>
							<ul class="list-unstyled">
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-primary fs-6" style="width: 4rem;">전체</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold fs-5 m-2">공지 제목</p>
												<p class="m-2">공지 작성자</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-primary fs-6" style="width: 4rem;">전체</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold fs-5 m-2">공지 제목</p>
												<p class="m-2">공지 작성자</p>
											</div>
										</div>
									</a>
								</li>
								
								<li class="border border-secondary-subtle p-2 mb-2">
									<a href="#" class="course-link text-decoration-none text-black">									
										<div class="d-flex align-items-center" style="column-gap: 1rem;">
											<span class="badge text-bg-primary fs-6" style="width: 4rem;">전체</span>
											<div class="d-flex flex-column justify-content-start align-items-start">
												<p class="fw-bold fs-5 m-2">공지 제목</p>
												<p class="m-2">공지 작성자</p>
											</div>
										</div>
									</a>
								</li>
								
							</ul>
						</div>
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
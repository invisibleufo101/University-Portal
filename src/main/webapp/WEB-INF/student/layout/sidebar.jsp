<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Start of Portal Dashboard -->
<main class="row" style="margin-top: 7rem; margin-bottom: 7rem;">
	<!-- Start of Portal Navbar -->
	<div class="col-3" >
		<div class="d-flex flex-column p-3 bg-body-tertiary border border-2 rounded-3 shadow">
			<ul class="nav nav-pills flex-column mb-auto fs-5" >
				<!-- Home -->
				<li class="nav-item mb-2">
					<a href="/student-portal.do" class="nav-link link-body-emphasis">
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
					<a href="/student-enrollment-registration.do" class="nav-link link-body-emphasis">
						<span class="d-flex align-items-center">								
							<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
  								<path stroke-linecap="round" stroke-linejoin="round" d="M12 6.042A8.967 8.967 0 0 0 6 3.75c-1.052 0-2.062.18-3 .512v14.25A8.987 8.987 0 0 1 6 18c2.305 0 4.408.867 6 2.292m0-14.25a8.966 8.966 0 0 1 6-2.292c1.052 0 2.062.18 3 .512v14.25A8.987 8.987 0 0 0 18 18a8.967 8.967 0 0 0-6 2.292m0-14.25v14.25" />
							</svg>
							수강 신청
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
				
<!-- 				Messages -->
<!-- 				<li class="nav-item mb-2"> -->
<!-- 					<a href="#" class="nav-link link-body-emphasis"> -->
<!-- 						<span class="d-flex align-items-center"> -->
<!-- 							<svg class="pe-none me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"> -->
<!-- 								<path stroke-linecap="round" stroke-linejoin="round" d="M8.625 9.75a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H8.25m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0H12m4.125 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm0 0h-.375m-13.5 3.01c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.184-4.183a1.14 1.14 0 0 1 .778-.332 48.294 48.294 0 0 0 5.83-.498c1.585-.233 2.708-1.626 2.708-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0 0 12 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018Z" /> -->
<!-- 							</svg> -->
<!-- 							메세지 -->
<!-- 						</span> -->
<!-- 					</a> -->
<!-- 				</li> -->
				
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
					<a href="/logout.do" class="nav-link link-body-emphasis">
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp" %>
<%@ include file="./layout/sidebar.jsp" %>
<!-- Start of Portal Content Area -->
<div class="col-9">
	<div class="border border-2 rounded-3 shadow">
		<!-- Start of Currently Enrolled Classes -->
		<div class="p-3">
			<h2 class="m-3">진행 중인 강의</h2>
			<ul class="list-unstyled">
			
				<c:if test="${ empty assignedLectures }">
				<li class="border border-secondary-subtle p-2 mb-2">
					<div class="text-decoration-none text-black">									
						<span class="d-flex justify-content-center align-items-center p-5">
							진행 중인 강의가 없습니다.
						</span>
					</div>
				</li>
				</c:if>
				
				<c:forEach var="assignedLecture" items="${ assignedLectures }">
				<li class="border border-secondary-subtle p-2 mb-2">
					<a href="/professor-lecture.do?id=${ assignedLecture.id }" class="course-link text-decoration-none text-black">									
						<div class="d-flex align-items-center" style="column-gap: 1rem;">
						
							<c:if test="${ assignedLecture.courseType == '전공' }">
								<span class="badge text-bg-info fs-6" style="width: 4rem;">${ registeredCourse.courseType }</span>
							</c:if>
							<c:if test="${ assignedLecture.courseType == '교양' }">
								<span class="badge text-bg-warning fs-6" style="width: 4rem;">교양</span>
							</c:if>
							
							<div class="d-flex flex-column justify-content-start align-items-start">
								<p class="fw-bold m-2">${ assignedLecture.courseName }</p>
							</div>
						</div>
					</a>
				</li>
				</c:forEach>
				
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
</div>
	
</body>
</html>
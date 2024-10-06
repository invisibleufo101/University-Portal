<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script defer src="js/bootstrap.bundle.min.js"></script>
	<title>학사 포털 로그인</title>
</head>
<body>
	<section class="vh-100 gradient-form" style="background-image: url('images/university_login.jpg'); background-size: cover; background-repeat: no-repeat;">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black border border-2 border-light-subtle">
						<div class="row g-0">
							<div class="col-lg-6">
								<img class="h-100 w-100 object-fit-cover rounded-3" src="images/university_login.jpg" alt="Univeristy Campus"/>
							</div>
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">
									<div class="text-center">
										<img src="images/university_logo.png" 
										style="width: 185px;" alt="University Logo">
										<h4 class="w-100 mt-1 mb-5 pb-1">학사 포털 로그인</h4>
									</div>

									<form action="/login.do" method="POST">
										<div data-mdb-input-init class="form-outline mb-3">
											<label class="form-label text-muted" for="school_id">학번(교번)</label>
											<input type="text" class="form-control ${!empty errors ? 'border border-danger' : '' }" placeholder="학번(교번) (ID No.)" id="school_id" name="school_id"/> 
										</div>

										<div data-mdb-input-init class="form-outline mb-3">
											<label class="form-label text-muted" for="password">비밀번호</label>
											<input type="password" class="form-control ${!empty errors ? 'border border-danger' : '' }" placeholder="비밀번호(Password)"id="password" name="password"/> 
										</div>

										<c:if test="${ !empty errors }">
										<span class="text-danger fs-6">${ errors['LoginError'] }</span>
										</c:if>
										
										<div class="text-center pt-1 mb-5 pb-1">
											<div class="d-grid gap-2">
											 	<button data-mdb-button-init data-mdb-ripple-init class="btn btn-primary fa-lg gradient-custom-2 mb-3" type="submit">로그인(Login)</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script defer src="js/bootstrap.bundle.min.js"></script>
	<title>교수자 포털</title>
</head>
<body>
	<!-- style="max-width: 1800px;" -->
	<div class="container" style="max-width: 80vw;">
		<!-- Start of Profile Banner Section -->
		<header>
			<div class="row banner-img">
				<div class="col-lg-12">
					<div class="profile-banner">
						<div class="profile-intro">
							<div class="profile-area">
								<!-- Profile Picture -->
								<div class="profile-picture"></div>

								<!-- Profile Info -->
								<div class="d-flex profile-info">
									<h1 class="profile-name">${ loginUser.name }</h1>
									<div class="icon-text ms-2">
										<svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
	  										<path stroke-linecap="round" stroke-linejoin="round" d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z" />
										</svg>
										<span>${ loginUser.roleName }</span>
									</div>

									<div class="icon-text ms-2">
										<svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
	  										<path stroke-linecap="round" stroke-linejoin="round" d="M12 21v-8.25M15.75 21v-8.25M8.25 21v-8.25M3 9l9-6 9 6m-1.5 12V10.332A48.36 48.36 0 0 0 12 9.75c-2.551 0-5.056.2-7.5.582V21M3 21h18M12 6.75h.008v.008H12V6.75Z" />
										</svg>
										<span>${ loginUser.majorName }</span>
									</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- End of Profile Banner Section -->
		
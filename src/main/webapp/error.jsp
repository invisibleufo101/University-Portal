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
	<title>Error Page</title>
</head>
<body>
	<h1>Oops! You made a null routing error!</h1>
	<ul class="text-primary fs-3">
		<li>Check if your DB is connected.</li>
		<li>Check if your controller has any Null Parameters</li>
		<li>If not, then check if there's something wrong with the Service class!</li>
	</ul>
	<h4>Have fun!</h4>
</body>
</html>
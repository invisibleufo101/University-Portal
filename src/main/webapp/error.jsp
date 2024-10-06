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
	<h2 class="text-primary">Check if your controller has any NullPointExceptions</h2>
	<h2 class="text-primary">Or, check if your INPUT PARAMETERS are not NULL!</h2>
	<h3 class="text-primary>">If not, then check if there's something wrong with the Service class!</h3>
	<h4>Have fun!</h4>
</body>
</html>
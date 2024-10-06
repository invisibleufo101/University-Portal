<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Temporary Registration page</title>
</head>
<body>

	<form action="/tempRegister.do" method="POST">	
		role_id:
		<select name="role_id">
			<option value="1">admin</option>
			<option value="2">student</option>
			<option value="3">professor</option>
		</select>
		
		major_id:
		<select name="major_id">
			<option value="1">국문</option>
			<option value="2">영문</option>
			<option value="3">독문</option>
			<option value="4">불문</option>
			<option value="5">중문</option>
			<option value="6">노문</option>
			<option value="7">사학</option>
			<option value="8">철학</option>
			<option value="9">문헌</option>
			<option value="10">심리</option>
			<option value="12">화공</option>
			<option value="13">전전</option>
			<option value="14">기공</option>
			<option value="15">사회환경</option>
			<option value="16">건축</option>
			<option value="17">신소재</option>
			<option value="18">도시공학</option>
			<option value="19">산업</option>
			<option value="20">시스템반도</option>
			<option value="21">디스플레이</option>
			<option value="22">경제</option>
			<option value="23">경영</option>
			<option value="24">응용통계</option>
			<option value="25">수학</option>
			<option value="26">물리</option>
			<option value="27">화학</option>
			<option value="28">지구시스템</option>
			<option value="29">천문</option>
			<option value="30">대기</option>
			<option value="11">system</option>
		</select>
		
		school_id:
		<input type="text" name="school_id"/>
		
		name:
		<input type="text" name="name"/>
		
		email:
		<input type="text" name="email"/>
		
		phone_number:
		<input type="text" name="phone_number"/>
		
		birthdate:
		<input type="date" name="birth_date"/>
		
		password:		
		<input type="text" name="password"/>
	
		<button type="submit">Submit</button>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>폼 태그</h1>
	
	req_quiz_ok페이지에서는 값을 받아 출력해주세요.
	
	<form action="???" method="post">
		<h3>회원가입 양식</h3>	
		<hr>
		아이디:<input type = "text" size = "10" placeholder = "8글자" name="id"><br>
		비밀번호:<input type = "password" size = "10" placeholder = "5글자" name="pw"><br>

		
		관심분야 
		<input type="checkbox" name = "inter">JAVA
		<input type="checkbox" name = "inter">DB
		<input type="checkbox" name = "inter">JSP
		<input type="checkbox" name = "inter">SPRING
		<input type="checkbox" name = "inter">응용소프트웨어
		
		<br>
		
		전공분야
		<input type="radio" name = "major" value="경영"> 경영학과
		<input type="radio" name = "major" value="컴공"> 컴퓨터공학과
		<input type="radio" name = "major" value="수학"> 수학과
		<input type="radio" name = "major" value="기공"> 기계공학과
		
		<br>
		
		지역 
		<select name = "region">
			<option>서울시</option>
			<option>경기도</option>
			<option>부산시</option>
			<option>제주시</option>
		</select>
		
		<br>
		
		자신을 소개해보세요!<br> 
		<textarea rows="10" cols="50" name="hello"></textarea>
		
		<br>

		<input type = "submit" value = "전송하기">
	
	</form>
</body>
</html>
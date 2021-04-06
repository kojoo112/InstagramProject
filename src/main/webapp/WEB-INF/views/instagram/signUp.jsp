<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUp</title>
</head>
<body>
	<form action="/signUp" method="post">
		<input type="text" name="email" placeholder="이메일 주소">
		<input type="text" name="username" placeholder="사용할 이름">
		<input type="text" name="password" placeholder="비밀번호">
		<input type="submit" value="가입">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/instagram/saveImage" enctype="multipart/form-data" method="post">
		<!-- <input type="text" name="email" placeholder="이메일">
					<input type="text" name="username" placeholder="사용자 이름">
					<input type="password" name="password" placeholder="비밀번호"> -->
	    <input type="file" name="uploadFile" />
	    <input type="submit" value="이미지저장"/>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<style type="text/css">
html, body{
	height:100%;
}

body{
	background-color: #FAFAFA;
	margin: 0;
}

#wrap{
	width:350px;
	height:500px;
	margin:auto;
	left: 50%;
	top: 50%;
}
.signUpForm{
	width: 350px;
	text-align: center;
	background-color: #ffffff;
	overflow: hidden;
	height: fit-content;
	padding: 0 10px;
	border: 1px solid #EAEAEA;
	margin: auto;
}

input[type="text"],
input[type="password"] {
	border: 1px solid #DBDBDB;
	background-color: #FAFAFA;
	border-radius: 5px;
}

input[type="submit"]{
	width: 260px;
}

input[type="submit"]:active{
	background-color: #48a9fe;
	}
	
input[type="submit"]{
	width: 100%;
	height: fit-content;
	background-color:#0095F6; 
	/* onClick background-color:#48a9fe; */
	outline:none;
	color:#FFFFFF;
	border: none;
	border-radius: 5px;
}

input {
	width: 250px;
	height: 30px;
	padding: 8px;
	margin: 5px 0px;
	outline: none;
}

#instagram-logo{
	width: 175px;
	height: 51px;
	margin: 22px auto;
}

a {
	text-decoration: none;
	color: #0095f6;
	font-weight: 600;
}
	
#signUpForm-table{
	margin: auto;
}

.description{
	color: #8E8E8E;
	font-size: 17px;
}

.signUpRecommend{
	padding: 20px 0;
}


</style>
<title>signUp</title>
</head>
<body>
	<div id="wrap">
		<div class="signUpForm">
			<div>
				<img src="/resources/img/logo.png" id="instagram-logo">
				<div class="description">친구들의 사진과 동영상을 보려면 가입하세요.</div>
			</div>
			<div class="signUpForm-form">
				<form action="/instagram/signUp" method="post" name="signUpForm">
					<table id="signUpForm-table">
					<tr><td><input type="text" name="email" placeholder="이메일">
					<tr><td><input type="text" name="userName" placeholder="사용자 이름">
					<tr><td><input type="password" name="password" placeholder="비밀번호">
					<tr><td><input type="submit" value="로그인">
					<tr><td>
						<div class="signUpRecommend">
							계정이 있으신가요? <a href="/instagram/index">로그인</a>
						</div>
					</table> 
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#submit").on("click", function(){
		
		if(document.signUpForm.email.value == ""){
			alert("이메일을 입력하세요.");
			return false;
		}
		
		if(document.signUpForm.username.value == ""){
			alert("이름을 입력하세요.");
			return false;
		}
		
		if(document.signUpForm.password.value == ""){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
	});
	
});


</script>
</html>
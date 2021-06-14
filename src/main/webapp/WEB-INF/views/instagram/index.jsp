<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<style type="text/css">

html, body{
	height: 100%;
	margin: 0;
}
.section{
	display: flex;
	margin: auto;
	height: 100%;
	background-color: #FAFAFA;
}
	
input{
	width: 250px;
	height: 30px;
	padding: 8px;
	margin: 5px 0px;
	outline: none;
}
	
input[type="text"],
input[type="password"]{
	border: 1px solid #DBDBDB;
	background-color: #FAFAFA;
	border-radius: 5px;
}

#mainPhoto{
	width:450px;
}
	
#instagram-logo{
	width: 175px;
	height: 51px;
	margin: 22px auto;
}
	
.loginForm{
	width: 350px;
	text-align: center;
	background-color: #ffffff;
	overflow: hidden;
	height: fit-content;
	padding: 0 10px;
	border: 1px solid #EAEAEA;
	margin: auto;
}
	input[type="submit"]:active{
	background-color: #48a9fe;
}

.loginForm-form{
	height: 260px;
}
	
input[type="submit"]{
	width: 100%;
	height: 30px;
	background-color:#0095F6; 
	/* onClick background-color:#48a9fe; */
	outline:none;
	color:#FFFFFF;
	border: none;
	border-radius: 5px;
}
	
a{
	text-decoration: none;
	color: #0095f6;
	font-weight: 600;
}
	
#loginForm-table{
	margin: auto;
}
	
.section-div{
	display:flex;
	margin:auto;
}
	
.description{
	color: #8E8E8E;
	font-size: 17px;
	font-weight: 600;
}

.signUpRecommend{
	padding: 20px 0;
}

</style>
<link rel="shortcut icon" type="imgage/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/200px-Instagram_logo_2016.svg.png">
<title>Instagram</title>
</head>
<body>
	<section class="section">
		<div class="section-div">
			<div class="mainPhoto">
				<img src="/resources/img/instagramMainPhoto.png" id="mainPhoto">
			</div>
			<div class="loginForm">
				<div>
					<img src="/resources/img/logo.png" id="instagram-logo">
					<div class="description">친구들의 사진과 동영상을 보려면 가입하세요.</div>
				</div>
				<div class="loginForm-form">
					<form action="/instagram/login" method="post" name="login">
						<table id="loginForm-table">
						<tr><td><input type="text" name="userName" placeholder="사용자 이름">
						<tr><td><input type="password" name="password" placeholder="비밀번호">
						<tr><td><input type="submit" value="로그인">
						<tr><td>
							<div class="signUpRecommend">
								계정이 없으신가요? <a href="/instagram/signUp">가입하기</a>
							</div>
						</table> 
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
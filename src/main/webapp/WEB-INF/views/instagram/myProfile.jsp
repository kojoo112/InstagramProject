<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<link rel="shortcut icon" type="imgage/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/200px-Instagram_logo_2016.svg.png">
<link rel="stylesheet" href="/resources/css/styles.css" location="/css/"/>
<style type="text/css">
#emptyImage{
	width:380px;
}

#wrap{
	width:350px;
	height:500px;
	margin:auto;
	left: 50%;
	top: 50%;
}
.postingForm{
	width: 350px;
	text-align: center;
	background-color: #ffffff;
	overflow: hidden;
	height: fit-content;
	padding: 20px;
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
	
#postingForm-table{
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
<title>Instagram</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	
	<div class="wrapper">
        <div class="profileWrapper">
                <div class="profileWrapper-left">
                    <div class="profileWrapper-profileImage">
                    <img src="${member.imageName }" alt="empty photo" id="profilePhoto"/>
                    </div>
                </div>
                <div class="profileWrapper-right">
                    <div class="profileWrapper-info">
                        <div class="profileWrapper-info-myInfo">
                            <div class="profileWrapper-info-myInfo-username">
                            ${member.userName}
                            </div>
                            <div class="profileWrapper-info-myInfo-profileEdit">
                                <input class="profileEditBtn"type="button" value="프로필 편집" />
                            </div>
                            <div class="profileWrapper-info-myInfo-setting">
                                <button class="settingBtn"><i class="fas fa-cog"></i></button>
                            </div>
                        </div>
                    </div>
                
                    <div class="profileWrapper-info-snsInfo">
                        <span class="posts">
                        게시물<span class="postsCount">${posts.count }</span>
                        </span>
                        <span class="follower">
                        팔로워<span class="followerCount">${follower }</span>
                        </span>
                        <span class="follow">
                        팔로우<span class="followCount">${follow }</span>
                        </span>
                    </div>
                </div>
        </div>
		<div class="main">
			<input type="radio" id="tab-1" name="show" checked/>
			<input type="radio" id="tab-2" name="show" />
			<input type="radio" id="tab-3" name="show" />
			<div class="tab">
		    	<label for="tab-1">게시물</label>
		    	<label for="tab-2">저장됨</label>
		    	<label for="tab-3">글쓰기</label>
			</div>
			<div class="contents">
				<div class="content-dis">
					<div class="posts">
						<c:choose>
							<c:when test="${post.imageName == null}">
				      			<img id="emptyImage" src="/resources/img/emptyImage.jpeg">
				      		</c:when>
				      	</c:choose>
				    </div>
			    </div>
			    <div class="content-dis">
				      saved
				</div>
				<div id="wrap">
					<div class="postingForm">
						<div>
							<img src="/resources/img/logo.png" id="instagram-logo"/>
							<div class="description">친구와의 사진을 공유해보세요.</div>
						</div>
						<div class="postingForm-form">
							<form action="/instagram/posting" method="post" name="postingForm" enctype="multipart/form-data">
								<table id="postingForm-table">
									<tr><td><input type="file" name="imageName" multiple/>										
									<tr><td><textarea rows="5" cols="33" name="comment" placeholder="사진에 대해 설명해주세요."></textarea>
									<tr><td><input type="hidden" name="memberNo" value="${member.memberNo }"/>
									<tr><td><button type="submit">작성</button>
								</table> 
							</form>
						</div>
					</div>
				</div>
			</div>
	    </div>
    </div>
  </body>
</html>
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
<title>Instagram</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	
	<div class="wrapper">
        <div class="profileWrapper">
                <div class="profileWrapper-left">
                    <div class="profileWrapper-profileImage">
                    <img src="/resources/img/cat.jpg" alt="empty photo" id="profilePhoto"/>
                    </div>
                </div>
                <div class="profileWrapper-right">
                    <div class="profileWrapper-info">
                        <div class="profileWrapper-info-myInfo">
                            <div class="profileWrapper-info-myInfo-username">
                            ${member.userName}ddd
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

        <div class="info-tab">
            <div class="postsTab">게시물</div>
            <div class="postsIGTV">tv</div>
            <div class="postsSaved">saved</div>
            <div class="postsTaged">taged</div>
        </div>
        <div class="changedScreen">
            <div class="posting">
            	<form action="/instagram/postingForm" method="post" enctype="multipart/form-data">
            		<input type="file" name="uploadFile">
            		<input type="submit" value="게시">
            	</form>
            </div>
        </div>
    </div>
  </body>
</html>
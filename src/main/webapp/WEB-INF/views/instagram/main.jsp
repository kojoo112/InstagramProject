<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css" location="/css/"/>
    <link rel="shortcut icon" type="imgage/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/200px-Instagram_logo_2016.svg.png">
    <title>Instagram</title>
</head>
<body>
   <jsp:include page="/WEB-INF/views/header.jsp"/>
    <div class="view">
        <section class="section">
            <div class="content">
                <div class="content-profile">
                    <div><img src="${member.imagePath }" alt="" class="content-profilePhoto"></div>
                    <div class="content-more">
                        <div class="content-id">super_cat</div>
                        <div class="content-moreIcon"><i class="fas fa-ellipsis-h"></i></div>
                    </div>
                </div>
                <div class="content-contents">
                    <img src="/resources/img/brightCat.jpg" class="content-contents" alt="">
                </div>
                <div class="content_bottom">
                    <div class="content-menuDiv">
                        <ul class="content-menuLeft">
                            <li class="content-menuIcon"><i class="far fa-heart"></i></li>
                            <li class="content-menuIcon"><i class="far fa-comment"></i></li>
                            <li class="content-menuIcon"><i class="far fa-paper-plane"></i></li>
                        </ul>
                        <ul class="content-menuRight">
                            <li class="content-menuIcon"><i class="far fa-bookmark"></i></li>
                        </ul>
                    </div>
                    <div class="views">조회 2,331,635회</div>
                    <div class="content-contents-contents">
                        <div class="contents-id">super_cat</div>
                        <div class="contents-contents">it's my friend !!</div>
                        <div class="contents-contents-hashtag">#bright_cat112</div>
                        <div class="comment">
                            <div class="comment-id">bright_cat112</div>
                            <div class="comment-content">it's my photo haha</div>
                            <div class="comment-heart"><i class="far fa-heart"></i></div>
                        </div>
                    </div>
                    <div class="comment-registration">
                        <input type="text" class="input-comment" placeholder="댓글 달기...">
                        <div class="regist">게시</div>
                    </div>
                </div>
            </div>
        </section>
        <aside class="aside">
            <div class="myProfile">
                <div><img src="${member.imagePath }" alt="" class="myProfile-photo"></div>
                <div>
                    <div class="myProfile-id">${member.email }</div>
                    <div class="myProfile-name">${member.userName }</div>
                </div>
                <div class="myProfile-idChange">전환</div>
            </div>
            <div class="recommendId">
                <div class="recommendId-notice">회원님을 위한 추천</div>
                <div class="recommendId-total">모두 보기</div>
            </div>
            <div class="recommend-elementBox">
                <div class="recommend-element">
                    <div class="recommendedProfile">
                        <img src="/resources/img/nero.png" alt="" class="recommendedPhoto">
                    </div>
                    <div class="recommendedBox">
                        <div class="recommendedAccount">
                            <div class="recommendedId">meow94</div>
                            <div class="recommendedFollower">bright_cat님이 팔로우 합니다.</div>
                        </div>
                        <div class="followButton">팔로우</div>
                    </div>
                </div>
                <div class="recommend-element">
                    <div class="recommendedProfile">
                        <img src="/resources/img/burnoutCat.jpg" alt="" class="recommendedPhoto">
                    </div>
                    <div class="recommendedBox">
                        <div class="recommendedAccount">
                            <div class="recommendedId">burnout_Cat</div>
                            <div class="recommendedFollower">bright_cat님이 팔로우 합니다.</div>
                        </div>
                    	<div class="followButton">팔로우</div>
                    </div>
                </div>
                <div class="recommend-element">
                    <div class="recommendedProfile">
                        <img src="/resources/img/GymPT.jpeg" alt="" class="recommendedPhoto">
                    </div>
                    <div class="recommendedBox">
                        <div class="recommendedAccount">
                            <div class="recommendedId">MuscleCat</div>
                            <div class="recommendedFollower">bright_cat님이 팔로우 합니다.</div>
                        </div>
                    	<div class="followButton">팔로우</div>
                    </div>
                </div>
                <div class="fileUpload">
                    	<input type="file">
                </div>
                <div>
                	<a href="logtout">로그아웃</a>
                	${member.regDate }
                </div>
            </div>
        </aside>
    </div>

</body>
</html>
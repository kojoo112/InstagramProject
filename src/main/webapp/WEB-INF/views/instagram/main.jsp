<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css" location="/css/"/>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <link rel="shortcut icon" type="imgage/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/200px-Instagram_logo_2016.svg.png">
    <style type="text/css">
    .fa-heart:before{
    	cursor: pointer;
    }
    
    button{
    	border: 0;
    	padding: 0;
    	background-color: #ffffff;
    }
    </style>
    <title>Instagram</title>
</head>
<body>
   <jsp:include page="/WEB-INF/views/header.jsp"/>
    <div class="view">
        <section class="section">
        <c:forEach var="post" items="${postList }">
            <div class="content">
                <div class="content-profile">
                    <div><img src="/resources/img/${post.profileImageName}" alt="" class="content-profilePhoto"></div>
                    <div class="content-more">
                        <div class="content-id">${post.userName}</div>
                        <div class="content-moreIcon"><i class="fas fa-ellipsis-h"></i></div>
                    </div>
                </div>
                <div class="content-contents">
                    <img src="/resources/images/${post.postImageName}" class="content-contents" alt="">
                </div>
                <div class="content_bottom">
                    <div class="content-menuDiv">
                        <ul class="content-menuLeft">
                            <li class="content-menuIcon"><button class="postLikeButton" onClick="likeClick(${post.postNo})"><i id="postHeart${post.postNo }" class="far fa-heart"></i></button></li>
                            <c:if test="${post.likeYn eq 'y' }">
				        		<script type="text/javascript">
				        			$("#postHeart${post.postNo}").css("color", "red");
				        		</script>
				        	</c:if>
                            <li class="content-menuIcon"><i class="far fa-comment"></i></li>
                            <li class="content-menuIcon"><i class="far fa-paper-plane"></i></li>
                        </ul>
                        <ul class="content-menuRight">
                            <li class="content-menuIcon"><i class="far fa-bookmark"></i></li>
                        </ul>
                    </div>
                    <div class="views" id="likeCount${post.postNo}">????????? ${post.likeCount }???</div>
                    <div class="content-contents-contents">
                        <div class="contents-id">${post.userName }</div>
                        <div class="contents-contents">${post.comment}</div>
                        <div class="contents-contents-hashtag">#bright_cat112</div>
                        <div class="comment">
                            <div class="comment-id">bright_cat112</div>
                            <div class="comment-content">it's my photo haha</div>
                            <div class="comment-heart"><i class="far fa-heart"></i></div>
                        </div>
                    </div>
                    <div class="comment-registration">
                        <input type="text" class="input-comment" placeholder="?????? ??????...">
                        <div class="regist">??????</div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </section>
        <aside class="aside">
            <div class="myProfile">
                <div><img src="${member.imageName }" alt="" class="myProfile-photo"></div>
                <div>
                    <div class="myProfile-id">${member.email }</div>
                    <div class="myProfile-name">${member.userName }</div>
                </div>
                <div class="myProfile-idChange">??????</div>
            </div>
            <div class="recommendId">
                <div class="recommendId-notice">???????????? ?????? ??????</div>
                <div class="recommendId-total">?????? ??????</div>
            </div>
            <div class="recommend-elementBox">
                <div class="recommend-element">
                    <div class="recommendedProfile">
                        <img src="/resources/img/nero.png" alt="" class="recommendedPhoto">
                    </div>
                    <div class="recommendedBox">
                        <div class="recommendedAccount">
                            <div class="recommendedId">meow94</div>
                            <div class="recommendedFollower">bright_cat?????? ????????? ?????????.</div>
                        </div>
                        <div class="followButton">?????????</div>
                    </div>
                </div>
                <div class="recommend-element">
                    <div class="recommendedProfile">
                        <img src="/resources/img/burnoutCat.jpg" alt="" class="recommendedPhoto">
                    </div>
                    <div class="recommendedBox">
                        <div class="recommendedAccount">
                            <div class="recommendedId">burnout_Cat</div>
                            <div class="recommendedFollower">bright_cat?????? ????????? ?????????.</div>
                        </div>
                    	<div class="followButton">?????????</div>
                    </div>
                </div>
                <div class="recommend-element">
                    <div class="recommendedProfile">
                        <img src="/resources/img/GymPT.jpeg" alt="" class="recommendedPhoto">
                    </div>
                    <div class="recommendedBox">
                        <div class="recommendedAccount">
                            <div class="recommendedId">MuscleCat</div>
                            <div class="recommendedFollower">bright_cat?????? ????????? ?????????.</div>
                        </div>
                    	<div class="followButton">?????????</div>
                    </div>
                </div>
                <div>
                	<a href="/instagram/logout">????????????</a>
                	<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd HH:mm"/>
                </div>
            </div>
        </aside>
    </div>

</body>
<script>

var isClicked = false;

function likeClick(postNo){
	console.log(postNo);
	
	if(isClicked == false){
		/* $("#postHeart"+postNo).css("color", "red"); */
		isClicked = true;
		console.log("#postHeart"+postNo)
	} else {
		/* $("#postHeart"+postNo).css("color", "black"); */
		isClicked = false;
		console.log("#postHeart"+postNo)
	}
	
	var params = {
			'memberIndex' : ${member.memberNo},
			'postIndex' : postNo
	}
	
	console.log(params);
	
	$.ajax({
		url:'/instagram/like',
		type: 'POST',
		/* dataType: 'json', */
		data: params,
		success: function(data) {
			
			if(data.likeYn == "y"){
				$("#postHeart"+postNo).css("color", "red");
				$("#likeCount"+postNo).text("?????????" + data.count + " ???");
			} else {
				$("#postHeart"+postNo).css("color", "black");
				$("#likeCount"+postNo).text("?????????" + data.count + " ???");
			}
			/* alert('????????????'); */
		},
		error: function(params){
			console.log(params);
			/* alert('????????????'); */
		}
		
	});
	
	
}


</script>
</html>
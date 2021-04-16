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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
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

button[type="submit"]{
	width: 260px;
}

button[type="submit"]:active{
	background-color: #48a9fe;
	}
	
button[type="submit"]{
	width: 100%;
	height: fit-content;
	background-color:#0095F6; 
	/* onClick background-color:#48a9fe; */
	outline:none;
	color:#FFFFFF;
	border: none;
	border-radius: 5px;
}

button{
	width: 250px;
	height: 30px;
	padding: 8px;
	margin: 5px 0px;
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

.posts{
	width:100%;
}

.posts-image{
	max-width: 290px;
	width: 290px;
	height: 290px
}

.content-dis{
	display: block;
}
.modal{ 
  position:absolute; 
  width:100%; 
  height:100%; 
  background: rgba(0,0,0,0.8); 
  top:0; 
  left:0; 
  display:none;
}

.modal_content{
  width:400px; 
  height:200px;
  background:#fff; 
  border-radius:10px;
  position:relative; 
  top:50%; 
  left:50%;
  margin-top:-100px; 
  margin-left:-200px;
  text-align:center;
  box-sizing:border-box; 
  padding:74px 0;
  line-height:23px;  
}
/* */
.imgList {
	width: 100%;
	display: flex;
	justify-content: space-around;
	align-items: center;
}

.imgC p {
	text-align: center;
}

.modal {
	display: none;
	z-index: 500;
	width: 100%;
	height: 100vh;
	position: fixed;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.8);
}

.modal button {
	position: absolute;
	top: 3rem;
	right: 3rem;
	background: transparent;
	border: 0;
	color: #ffffff;
	font-size: 3rem;
}

.modalBox {
	position: relative;
	top: 20%;
	left: 50%;
	transform: translate(-50%, -20%);
	background-color: #ffffff;
	width: 30%;
	height: 30%;
	text-align: center;
}

.modalBox img {
	width: 100%;
}

.modalBox p {
	color: #ffffff;
	background-color: #000;
	font-size: 2rem;
	padding: .2rem;
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
					
					 <c:forEach var="list" items="${lists}" >
					
						<img alt="${list.imageName }" class="posts-image" src="/resources/images/${list.imageName}">
						
						
					</c:forEach>
						<%--<c:choose> 
							<c:when test="${post.imageName == null}">
				      			<img id="emptyImage" src="/resources/img/emptyImage.jpeg">
				      		</c:when>
				      	</c:choose> --%>
				    </div>
				    <div class="posts">
				    	<img alt="" src="/resources/images/logo.png">
				    	<img alt="" src="/resources/images/logo.png">
				    	<img alt="" src="/resources/images/logo.png">
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
									<tr><td><input type="file" name="imageFile" multiple/>										
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
    
    <!-- 모달창 -->
    <div class="modal">
		<button>&times;</button>
		<div class="modalBox">
			<img src="" alt="">
			<p></p>
		</div>
	</div>

<script type="text/javascript">

$(function(){
// 	이미지 클릭시 해당 이미지 모달
	$(".posts").click(function(){
		$(".modal").show();
		// 해당 이미지 가겨오기
		var imgSrc = $(this).children("img").attr("src");
		var imgAlt = $(this).children("img").attr("alt");
		$(".modalBox img").attr("src", imgSrc);
		$(".modalBox img").attr("alt", imgAlt);
		
		// 해당 이미지 텍스트 가져오기
		// var imgTit =  $(this).children("p").text();
		// $(".modalBox p").text(imgTit);
		
   // 해당 이미지에 alt값을 가져와 제목으로
		$(".modalBox p").text(imgAlt);
	});
	
	//.modal안에 button을 클릭하면 .modal닫기
	$(".modal button").click(function(){
		$(".modal").hide();
	});
	
	//.modal밖에 클릭시 닫힘
	$(".modal").click(function (e) {
    if (e.target.className != "modal") {
      return false;
    } else {
      $(".modal").hide();
    }
  });
});



$(function(){ 
	
	$(".posts-image").click(function(){ 
		$(".modal").fadeIn(); 
	}); 
	
	$("#modal").click(function(){ 
		$(".modal").fadeOut(); 
	}); 
});


</script>
    
  </body>
</html>
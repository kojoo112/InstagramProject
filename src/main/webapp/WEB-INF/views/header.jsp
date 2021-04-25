\<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<header class="appBarw">
        <div class="appBar">
            <div class="instagram-logo">
                <a href="/instagram/main"><img src="/resources/img/logo.png" class="logo"></a>
            </div>
            <div class="inputText">
                <input type="text" class="search" placeholder="&#xf002 검색">
            </div>
            <div class="appBarMenuDiv">
                <ul class="appBarMenu">
                    <li class="menuIcon"><i class="fas fa-home"></i></li>
                    <li class="menuIcon"><i class="far fa-paper-plane"></i></li>
                    <li class="menuIcon"><i class="far fa-compass"></i></li>
                    <li class="menuIcon"><i class="far fa-heart"></i></li>
                    <li class="menuIcon"><a href="/instagram/myProfile"><img src="${member.imageName }" alt="" class="appBarProfile"></a></li>
                </ul>
            </div>
        </div>
</header>
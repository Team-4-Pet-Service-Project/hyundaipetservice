<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/thepet/resources/basic/css/menu.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<!-- <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous" ></script> -->
<style>
.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48
}
</style>
</head>
<body>
	<header class="top_container">
		<div class="header_container">
			<!-- <div class="header_container"> -->
			<div class="logo_container">
				<a class="logo" href="/thepet/main">
					<img class="logo" src="/thepet/resources/basic/img/thehyundai.png" alt="">
				</a>
				<div class="user_box">
					<c:set var="email" value="${member.email}" />
					<c:set var="admin" value="${member.admin}" />
					<c:choose>
						<c:when test="${empty email}">
							<a href="/thepet/member/login_bt" class="login_main">로그인 </a>
							<a href="/thepet/member/register_bt" class="register_main">회원가입</a>
						</c:when>
						<c:when test="${admin eq 1}">
							<a href="admin/main">관리자 페이지</a>
						</c:when>
						<c:otherwise>
							<p class="name_main">${member.name}님 </p>
							<a href="/thepet/mypage/reservlist" class="mypage_main">마이페이지</a>
							<p class="name_main">로그아웃 </p>
							<div class="bell1">
								<span class="material-symbols-outlined">notifications </span>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- </div> -->
			</div>
			<div class="menu_container">
				<div class="menu_bar">
					<a class="menu-trigger" href="#"> <span></span> <span></span> <span></span>
					</a> <span>Gift</span> <span>New</span> <span>Store In</span> <span>Show-Room</span><span>Re.Green</span>
					<span>Event</span>
				</div>
				<div class="user_box1"></div>
			</div>
		</div>
	</header>
	<script src="/thepet/resources/basic/js/rotate.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/side.css">
</head>
<body>
	<div class="side_bar">
		<h1 class="side_title">마이현대</h1>
		<h2 class="side_h2">MY HYUNDAI</h2>
		<hr class="side_hr" align="left">
		<div class="category_container">
			<p class="my_category">관리 현황</p>
			<div class="check_menu">
				<a href="/thepet/admin/main" class="detail_category">예약 관리</a> 
				<a onclick="reviewClickEvent()" class="detail_category">리뷰 관리</a>
			</div>
		</div>
	</div>
</body>
</html>
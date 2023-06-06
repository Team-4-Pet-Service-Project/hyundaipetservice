<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/thepet/resources/reservation/css/reservation_beauty.css?<%= System.currentTimeMillis() %>">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
</head>
<body>
	<div class="beauty_container">
		<div class="reservation_input">
			<jsp:include page="./dogInput.jsp" />
			<jsp:include page="./beautyAddOption.jsp" />
		</div>
		<div class="select_datetime_container">
			<jsp:include page="./calender.jsp" />
		</div>
		<div class="reservation_info_container">
			<jsp:include page="./reservationInfoResult.jsp" />
		</div>
	</div>
</body>
</html>
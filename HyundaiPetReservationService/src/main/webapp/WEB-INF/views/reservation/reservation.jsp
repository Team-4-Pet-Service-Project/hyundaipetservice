<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/reservation/css/reservation.css?<%= System.currentTimeMillis() %>">
<link rel="stylesheet" href="/thepet/resources/reservation/css/care_add_option.css?<%= System.currentTimeMillis() %>">
<link rel="stylesheet" href="/thepet/resources/reservation/css/playground_add_option.css?<%= System.currentTimeMillis() %>">
<link rel="stylesheet" href="/thepet/resources/reservation/css/beauty_add_option.css?<%= System.currentTimeMillis() %>">
<!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" /> -->

<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script type="text/javascript" src="/thepet/resources/reservation/js/reservation.js"></script>
<!-- <script type="text/javascript" src="/thepet/resources/reservation/js/playground_add_option.js"></script> -->
<!-- <script type="text/javascript" src="/thepet/resources/reservation/js/beauty_add_option.js"></script> -->
<title>Insert title here</title>
</head>
<body style="display: flex; justify-content: center;">
<jsp:include page="./modal.jsp" />
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<jsp:include page="../mainform/menubar.jsp" />
	<main>
		<div class="reservation_container">
			<div class="reservation_form">
				<div class="reservation_category">
					<div class="category_box care select_category">
						<img alt="" src="/thepet/resources/reservation/img/care.png">
						<p class="category_text">케어</p>
					</div>
					<div class="category_box playground">
						<img alt="" src="/thepet/resources/reservation/img/playground.png">
						<p class="category_text">놀이터</p>
					</div>
					<div class="category_box beauty">
						<img alt="" src="/thepet/resources/reservation/img/beauty.png">
						<p class="category_text">미용</p>
					</div>
				</div>
				<div style="position: relative;">
					<jsp:include page="./reservationCare.jsp" />
					<%-- <jsp:include page="./reservationPlayground.jsp" />
					<jsp:include page="./reservationBeauty.jsp" /> --%>
				</div>
			</div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/reservation/css/reservation.css?<%= System.currentTimeMillis() %>">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script type="text/javascript" src="/thepet/resources/reservation/js/reservation.js"></script>
<title>Insert title here</title>
</head>
<body style="display: flex; justify-content: center">
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<main>
		<div class="reservation_container">
			<div class="reservation_form">
				<div class="reservation_category">
					<div class="category_box care select_category">케어</div>
					<div class="category_box playground">놀이터</div>
					<div class="category_box beauty">미용</div>
				</div>
				<div style="position: relative;">
					<jsp:include page="./reservationCare.jsp" />
					<jsp:include page="./reservationPlayground.jsp" />
					<jsp:include page="./reservationBeauty.jsp" />
				</div>
			</div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
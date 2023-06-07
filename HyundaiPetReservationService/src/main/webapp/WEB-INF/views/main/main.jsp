<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/mainpage/css/mainPage.css">

<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous" ></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<script type="text/javascript" src="/thepet/resources/mainpage/js/main_slide.js"></script>
<title>The Hyundai : 메인</title>
</head>
<body class="container_body">
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<jsp:include page="../mainform/menubar.jsp" />
	<div class="gap"></div>
	<main>
		<div class="main_container">
            <div class="slide_main_container variable-width">
            	<img alt="" src="/thepet/resources/mainpage/img/main1.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main2.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main3.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main4.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main5.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main6.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main7.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main8.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main9.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main10.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main11.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main12.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main13.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main14.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main15.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main16.jpg">
            </div>		
		</div>
	</main>
	<hr>
	<jsp:include page="../mainform/footer.jsp"/>
</div>

</body>
</html>
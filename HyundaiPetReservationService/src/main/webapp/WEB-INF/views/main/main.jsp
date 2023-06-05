<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/mainpage/css/mainPage.css">
<title>Insert title here</title>
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
			<%-- <jsp:include page="../mainform/side.jsp"/>
			<div class="main_info">
                    <!-- 여기다가 구현 -->
            </div> --%>
            <div class="slide_main_container">
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
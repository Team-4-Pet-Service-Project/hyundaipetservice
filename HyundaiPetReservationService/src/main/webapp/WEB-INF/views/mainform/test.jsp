<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<jsp:include page="./header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<div class="gap"></div>
	<main>
		<div class="main_container">
			<jsp:include page="./side.jsp"/>
			<div class="main_info">
                    <!-- 여기다가 구현 -->
            </div>		
		</div>
	</main>
	<jsp:include page="./footer.jsp"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/container.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/login.css?<%=System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<div class="main_info">
					<!-- 여기다가 구현 -->
					<div class="login-wrap">
						<div class="login-container">
							<form id="loginForm" name="loginForm" action="/member/login">
								<div class="login-id">
									<p class="form-title">아이디*</p>
									<input id="member_id" name="mem_id" class="login-id"
										placeholder="아이디*" value="email" type="text">
								</div>
								<div class="login-password">
									<p class="form-title">비밀번호*</p>
									<input id="passwd" name="mem_pwd" autocomplete="off"
										class="login-pw" maxlength="16" value="password"
										type="password" placeholder="비밀번호*">
								</div>
								<button type="button" class="btn">로그인</button>
							</form>
						</div>
					</div>
				</div>
		</main>
		<jsp:include page="../mainform/footer.jsp" />
	</div>
</body>
</html>
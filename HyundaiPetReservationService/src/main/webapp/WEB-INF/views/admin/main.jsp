<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/reset.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/container.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/admin/css/main.css?<%=System.currentTimeMillis()%>">
<title>관리자 페이지</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<jsp:include page="../mainform/side.jsp" />
				<div class="main_info">
					<div class="admin_main">
						<div class="admin_title">
							<h1>관리화면</h1>
							<h2>ADMIN HYUNDAI</h2>
						</div>
						<div class="admin_menu_bar">
							<h3>메뉴바</h3>
						</div>
						<div class="information_summary">
							<h3>요약 정보</h3>
						</div>
						<div class="reservation_confirm">
							<div class="reservation_confirm_title">
								<h3>예약 조회</h3>
							</div>
							<div class="calender">
								<h3>캘린더</h3>
							</div>
							<div class="reservation_confirm_check">
								<h3>체크한 예약 조회</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../mainform/footer.jsp" />
	</div>
</body>
</html>
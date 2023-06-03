<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet"
	href="/thepet/resources/basic/css/reset.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/container.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/admin/css/main.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/admin/css/admin_calender.css?<%=System.currentTimeMillis()%>">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"
	integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="/thepet/resources/admin/js/admin_calender.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

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
					<div class="admin_container">
						<div class="admin_title">
							<h1 class="side_title">관리화면</h1>
							<h2 class="side_h2" style="padding: 3px 0px 3px 0px;">ADMIN
								HYUNDAI</h2>
						</div>
						<div class="admin_menu_bar">
							<div class="reservation_tab admin_tab select_form">예약 관리</div>
							<div class="review_tab admin_tab non_select_form">리뷰 관리</div>
						</div>
						<div class="location_container" style="display: flex;">
							<div class="">
								<h2 class="select_location">지점 선택</h2>
							</div>
							<select class="myDropdown">
								<option value="">선택하세요</option>
								<option value="option1">더 현대 서울</option>
								<option value="option2">더 현대 대구</option>
							</select>
							<div class="information_summary">
								<h2 class="information_summary_title">요약 정보</h2>
								<table class="reservation_table">
									<tbody>
										<tr>
											<td class="today_reservation">오늘 예약</td>
											<td class="reservation_table_cell"></td>
											<td class="today_sales">오늘 매출</td>
											<td class="reservation_table_cell"></td>
										</tr>
										<tr>
											<td class="month_reservation">이번달 예약</td>
											<td class="reservation_table_cell "></td>
											<td class="month_sales">이번달 매출</td>
											<td class="reservation_table_cell"></td>
										</tr>
										<tr>
											<td class="last_month_reservation">지난달 예약</td>
											<td class="reservation_table_cell"></td>
											<td class="last_month_sales">지난달 매출</td>
											<td class="reservation_table_cell"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<h3 class="reservation_confirm_title">예약 조회</h3>
						<div class="reservation_confirm_contents">
							<div class="calender_container">
								<div
									style="display: flex; justify-content: flex-start; width: 490px; margin-top: 20px; margin-left: 10px;">
									<div class="calender">
										<div class="date_header">
											<span
												class="material-symbols-rounded arrow active_arrow left"
												onclick="prevMonth()">chevron_left</span> <span class="ym"></span>
											<span
												class="material-symbols-rounded arrow active_arrow right"
												onclick="nextMonth()">chevron_right</span>
										</div>
										<div class="main">
											<div class="days">
												<div class="day sun">SUN</div>
												<div class="day">MON</div>
												<div class="day">TUE</div>
												<div class="day">WED</div>
												<div class="day">THE</div>
												<div class="day">FRI</div>
												<div class="day sat">SAT</div>
											</div>
											<div class="main_date"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="reservation_confirm_check">
								<h3 class="reservation_confirm_check_title">날짜 예약 상세 조회</h3>
								<table class="total_check">

								</table>
								<table class="total_check_detail">

								</table>
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
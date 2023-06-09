<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	href="/thepet/resources/mainpage/css/mainPage.css">
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

<title>The Hyundai : 관리자</title>
</head>
<body class="container_body">
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<jsp:include page="../mainform/menubar.jsp" />
		<div class="gap"></div>
		<main style="margin-bottom: 15px;">
			<div class="main_container">
				<jsp:include page="../mainform/admin_side.jsp" />
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
							<div class="remain_menu_bar"></div>
						</div>

						<div class="reservation_management_container">
							<div class="information_summary_container">
								<div class="location_select">
									<h2 class="location_select_title">지점 선택</h2>
									<select class="myDropdown">
										<option value="">선택하세요</option>
										<option value="더현대 서울">더현대 서울 </option>
										<option value="더현대 대구">더현대 대구</option>
									</select>
								</div>
								<div class="information_summary">
									<h2 class="information_summary_title">요약 정보</h2>
									<table class="reservation_table">
										<tbody>
											<tr class="reservation_table_row reservation_table_common_row">
												<td class="this_month_reservation td_title">이번달 예약</td>
												<td class="this_month_reservation_data td_class information_data"></td>
												<td class="last_month_reservation td_title">지난달 예약</td>
												<td class="last_month_reservation_data td_class information_data"></td>
											</tr>
											<tr class="reservation_table_row reservation_table_common_row">
												<td class="this_month_sales td_title">이번달 매출</td>
												<td class="this_month_sales_data information_data"></td>
												<td class="last_month_sales td_title">지난달 매출</td>
												<td class="last_month_sales_data information_data"></td>
											</tr>
											<tr class="reservation_table_row reservation_table_common_row">
												<td class="this_month_customers td_title">이번달 이용 고객 수</td>
												<td class="this_month_customers_data information_data"></td>
												<td class="last_month_customers td_title">지난달 이용 고객 수</td>
												<td class="last_month_customers_data information_data"></td>
											</tr>
											<tr class="reservation_table_common_row">
												<td class="this_month_puppies td_title">이번달 이용 강아지 수</td>
												<td class="this_month_puppies_data information_data"></td>
												<td class="last_month_puppies td_title">지난달 이용 강아지 수</td>
												<td class="last_month_puppies_data information_data"></td>
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
												<!-- <span
													class="material-symbols-rounded arrow active_arrow left"
													onclick="prevMonth()">chevron_left</span> <span class="ym"></span> -->
												<span class="arrow active_arrow left"> <svg
														xmlns="http://www.w3.org/2000/svg" height="40"
														viewBox="0 -960 960 960" width="40">
														<path
															d="M561-240 320-481l241-241 43 43-198 198 198 198-43 43Z"
															style="fill:rgb(255, 255, 255);" /></svg>
												</span>
												<span class="ym"></span> 
												<span
													class="arrow active_arrow right"> <svg
														xmlns="http://www.w3.org/2000/svg" height="40"
														viewBox="0 -960 960 960" width="40">
														<path
															d="m375-240-43-43 198-198-198-198 43-43 241 241-241 241Z"
															style="fill:rgb(255, 255, 255);" /></svg>
												</span>
												<!-- <span
													class="material-symbols-rounded arrow active_arrow right"
													onclick="nextMonth()">chevron_right</span> -->
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
						
						
						<!-- 여기 아래부터는 리뷰 관리 클릭 시 나오는 영역 -->
						<div class="review_management_container">
							<div class="review_no_comment_container">
								<p class="review_no_comment_p">답변하지 않은 고객 리뷰</p>
								<table class="review_no_comment_table">
									<tr class="review_comment_table_head">
										<th class="review_comment_table_cell">구분</th>
										<th class="review_comment_table_cell">이용일자</th>
										<th class="review_comment_table_cell">평점</th>
										<th class="review_comment_table_cell">서비스 만족도</th>
										<th class="review_comment_table_cell">공간</th>
										<th class="review_comment_table_cell">청결도</th>
										<th class="review_comment_table_cell">재방문 의사</th>
										<th class="review_comment_table_cell">답변 등록</th>
									</tr>
									
<!-- 									<tr class="review_comment_table_row">
										<td class="review_comment_table_cell">케어</td>
										<td class="review_comment_table_cell">2023-05-24</td>
										<td class="review_comment_table_cell">4</td>
										<td class="review_comment_table_cell">친절해요</td>
										<td class="review_comment_table_cell">넓어요</td>
										<td class="review_comment_table_cell">쾌적해요</td>
										<td class="review_comment_table_cell">무조건이죠</td>
										<td class="review_comment_table_cell"><button type="submit">답변 등록</button></td>
									</tr> -->
								</table>
							
							</div>
							<br><br>
							<div class="review_commented_container">
								<p class="review_commented_p">답변한 고객 리뷰</p>
								<table class="review_commented_table">
									<tr class="review_comment_table_head">
										<th class="review_comment_table_cell">구분</th>
										<th class="review_comment_table_cell">이용일자</th>
										<th class="review_comment_table_cell">평점</th>
										<th class="review_comment_table_cell">서비스 만족도</th>
										<th class="review_comment_table_cell">공간</th>
										<th class="review_comment_table_cell">청결도</th>
										<th class="review_comment_table_cell">재방문 의사</th>
										<th class="review_comment_table_cell">답변 보기</th>
									</tr>
									
<!-- 									<tr class="review_comment_table_row">
										<td class="review_comment_table_cell">케어</td>
										<td class="review_comment_table_cell">2023-05-24</td>
										<td class="review_comment_table_cell">4</td>
										<td class="review_comment_table_cell">친절해요</td>
										<td class="review_comment_table_cell">넓어요</td>
										<td class="review_comment_table_cell">쾌적해요</td>
										<td class="review_comment_table_cell">무조건이죠</td>
										<td class="review_comment_table_cell"><button type="submit">답변 등록</button></td>
									</tr> -->
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
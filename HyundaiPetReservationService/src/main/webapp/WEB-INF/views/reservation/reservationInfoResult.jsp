<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/reservation/css/reservation_info_result.css?<%= System.currentTimeMillis() %>">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="information_container">
		<h1 class="info_h1">
			예약정보
		</h1>
		<h2 class="info_h2">
			예약자 정보
		</h2>
		<table class="member_info_table">
			<tr class="info_table_row">
				<td class="row_head common_cell">이름</td>
				<td class="row_content common_cell">홍길동</td>
			</tr>
			<tr class="info_table_row">
				<td class="row_head common_cell">연락처</td>
				<td class="row_content common_cell">010-1234-5678</td>
			</tr>
			<tr class="info_table_row">
				<td class="row_head common_cell">이메일주소</td>
				<td class="row_content common_cell">test123@test.com</td>
			</tr>
			<tr class="info_table_row">
				<td class="row_head common_cell">추가 인원</td>
				<td class="row_content common_cell">1</td>
			</tr>
		</table>
		<h2 class="info_h2 dog_info_h2">
			예약견 정보
		</h2>
		<table class="dog_info_table">
			<tr class="dog_table_head">
				<td class="dog_table_common_cell">이름</td>
				<td class="dog_table_common_cell">나이</td>
				<td class="dog_table_common_cell">견종</td>
				<td class="dog_table_common_cell">크기</td>
			</tr>
			<tr class="dog_table_row">
				<td class="dog_table_common_cell">마루</td>
				<td class="dog_table_common_cell">12</td>
				<td class="dog_table_common_cell">말티즈</td>
				<td class="dog_table_common_cell">소형</td>
			</tr>
			<tr class="dog_table_row">
				<td class="dog_table_common_cell">베아트리스</td>
				<td class="dog_table_common_cell">3</td>
				<td class="dog_table_common_cell">포메라니안</td>
				<td class="dog_table_common_cell">소형</td>
			</tr>
		</table>
	</div>
	<div class="information_detail_container">
		<h2 class="info_h2 dog_info_h2">
			이용 정보
		</h2>
		<table class="member_info_table">
			<tr class="info_table_row">
				<td class="row_head common_cell">이용일자</td>
				<td class="row_content common_cell">2023-05-11 15:00 ~ 17:00</td>
			</tr>
			<tr class="info_table_row">
				<td class="row_head common_cell">연락처</td>
				<td class="row_content common_cell">케어</td>
			</tr>
			<tr class="info_table_row">
				<td class="row_head common_cell">이메일 주소</td>
				<td class="row_content common_cell">더현대 서울 7층</td>
			</tr>
		</table>
	</div>
	<div class="total_price_box">
		<p class="total_price_text">결제 예정 금액</p>
		<p class="total_price">80,000원</p>
	</div>
	<div class="result_button_box">
		<button class="reservation_reset_button">초기화</button>
		<button class="do_reservation_button">예약하기</button>	
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/thepet/resources/reservation/css/dog_input.css?<%= System.currentTimeMillis() %>">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script type="text/javascript" src="/thepet/resources/reservation/js/dog_input.js"></script>
<meta charset="UTF-8">
</head>
<body>
	<div class="branch_office">
			<p class="input_title">지점선택</p>
			<div class="radio-container">
				<label class="radio-label"> <input class="radio-input"
					type="radio" name="experience" value="서울"> <span
					class="radio-custom">서울</span>
				</label> <label class="radio-label"> <input class="radio-input"
					type="radio" name="experience" value="대구"> <span
					class="radio-custom">대구</span>
				</label>
			</div>
		</div>
		<div class="dog_form_container">
			<p class="input_title">반려견 정보 입력</p>
			<div class="tab_container">
				<div class="new_dog dog_tab select_form">새로운 반려견 입력</div>
				<div class="exist_dog dog_tab non_select_form">내 반려견 불러오기</div>
			</div>
			
			<form class="dog_form" action="/thepet/addDog" method="POST">
				<div class="input_div">
					<p class="input_name">이름</p>
					<input type="text" name="name" class="input_set">
				</div>
				<div class="input_div">
					<p class="input_name">나이</p>
					<input type="number" name="age" class="input_set">
				</div>
				<div class="input_div">
					<p class="input_name">견종</p>
					<input type="text" name="breed" class="input_set">
				</div>
				<div class="input_div">
					<p class="input_name">분류</p>
					<div class="input_radio_container">
						<label> 
							<input class="radio-input" type="radio" name="dogSize" value="소형"> 
							<span class="dog_radio_custom">소형</span>
						</label> 
						<label> 
						<input class="radio-input" type="radio" name="dogSize" value="중형"> 
							<span class="dog_radio_custom">중형</span>
							</label> 
						<label> 
							<input class="radio-input" type="radio" name="dogSize" value="대형"> 
							<span class="dog_radio_custom">대형</span>
						</label>
					</div>
				</div>
				<div class="significant_container">
					<p class="significant_name">특이사항</p>
					<textarea class="significant" name="specialNote"></textarea>
				</div>
				<div class="dog_form_btn_box">
					<input type="button" class="dog_form_btn" value="정보 저장">
				</div>
			</form>
			<div class="mypet">
				<table class="mypet_table">
					<tr class="mypet_table_h">
						<th class="mypet_table_cell">선택</th>
						<th class="mypet_table_cell">이름</th>
						<th class="mypet_table_cell">나이</th>
						<th class="mypet_table_cell">견종</th>
						<th class="mypet_table_cell">크기</th>
					</tr>
				</table>
			</div>		
		</div>
</body>
</html>
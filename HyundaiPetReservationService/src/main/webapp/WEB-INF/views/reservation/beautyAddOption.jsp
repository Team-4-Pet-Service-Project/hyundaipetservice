<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/reservation/css/beauty_add_option.css?<%= System.currentTimeMillis() %>">
</head>
<body>
	<div class="add_option_container">
		<h1 class="add_option_h1">추가 옵션</h1>
		<div class="add_option_radio_box">
			<div class="radoi_button_box">
				<input type="radio" name="beauty_service_type" id="beauty" value="미용" class="add_option_radio_input"/>
				<label for="beauty" class="add_option_radio_label">미용</label>
			</div>
			<div class="radoi_button_box">
				<input type="radio" name="beauty_service_type" id="spar" value="스파" class="add_option_radio_input"/>
				<label for="spar" class="add_option_radio_label">스파</label>
			</div>
		</div>
		<div class="add_style_button_box">
			<button class="add_dog_style_button">스타일 추가하기</button>
		</div>
	</div>
</body>
</html>
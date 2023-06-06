<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/reservation/css/playground_add_option.css?<%= System.currentTimeMillis() %>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/thepet/resources/reservation/js/playground_add_option.js"></script>
</head>
<body>
	<div class="add_option_container">
		<h1 class="add_option_h1">추가 옵션</h1>
		<div class="add_option_counter_box">
			<div class="customer_counter_box">
				<p class="customer_text">보호자</p>
				<div class="customer_counter">
					<span class="material-symbols-outlined count_decrese">do_not_disturb_on</span>
					<input type="number" value="1" class="customer_counter_input" min="1"/><span class="customer_span">명</span>
					<span class="material-symbols-outlined count_increse">add_circle</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
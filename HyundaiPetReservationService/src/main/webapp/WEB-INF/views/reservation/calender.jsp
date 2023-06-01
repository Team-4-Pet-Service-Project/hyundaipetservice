<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	<link rel="stylesheet" href="/thepet/resources/reservation/css/calender.css?<%= System.currentTimeMillis() %>">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/thepet/resources/reservation/js/calender.js">
<!--

//-->
</script>
</head>
<body>
	<div class="calender_container">
		<div class="date_box">
			<h1 style="font-size: 30px; font-weight: bold; margin-left: 50px; margin-top: 30px;">날짜</h1>
		</div>
		<div style="display:flex; justify-content: center; width: 490px; margin-top: 20px;">		
			<div class="calender">
	        	<div class="date_header">
	            	<span class="material-symbols-rounded arrow active_arrow left" onclick="prevMonth()">chevron_left</span>
	            	<span class="ym"></span>
	            	<span class="material-symbols-rounded arrow active_arrow right" onclick="nextMonth()">chevron_right</span>
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
	            	<div class="main_date">
						
	            	</div>
	        	</div>
	    	</div>
		</div>
    </div>
    <div class="calender_detail_container">
    	
    </div>
   	<div class="add_button_box" style="display: none;">
   		<input type="button" value="추가" class="add_btn" onclick="addReservation()"/>
   	</div>
</body>
</html>
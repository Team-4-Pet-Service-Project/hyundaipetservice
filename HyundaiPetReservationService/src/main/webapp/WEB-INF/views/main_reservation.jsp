<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 예약 페이지</title>
</head>
<body>
<br><br><br>
<form action="smstest/submit" method="POST">
	<input type="hidden" name="reservationId" value="5"/>

	<button type="submit">예약하기</button>
</form>


<form action="smstest/cancel" method="POST">
	<input type="hidden" name="reservationId" value="5"/>
	<button type="submit">예약취소</button>
</form>

</body>
</html>
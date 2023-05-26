<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/reservation/css/reservation.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<main>
		<div class="reservation_container">
			<div class="notification">
			
			</div>
			<form class="reservation_form">
				<div class="reservation_category">
					<div class="select_category">케어</div>
					<div class="select_category">놀이터</div>
					<div class="select_category">미용</div>
				</div>
				<div class="reservation_input">
						<div class="branch_office">
							<p>지점선택</p>
							<div class="radio-container">
								<label class="radio-label"> 
									<input class="radio-input" type="radio" name="experience" value="서울">
									<span class="radio-custom">서울</span>
								</label>
								<label class="radio-label"> 
									<input class="radio-input" type="radio" name="experience" value="대구"> 
									<span class="radio-custom">대구</span>
								</label> 
							</div>
						</div>
						<div class="dog_form">
							
						</div>
					</div>
			</form>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
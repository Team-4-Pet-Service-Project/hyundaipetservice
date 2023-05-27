<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/reservation/css/reservation.css?<%= System.currentTimeMillis() %>">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<main>
		<div class="reservation_container">
			<div class="reservation_form">
				<div class="reservation_category">
					<div class="select_category">케어</div>
					<div class="select_category">놀이터</div>
					<div class="select_category">미용</div>
				</div>
				<div class="reservation_input">
						<div class="branch_office">
							<p class="input_title">지점선택</p>
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
						<div class="dog_form_container">
							<p class="input_title">반려견 정보 입력</p>
							<div class="tab_container">
								<div class="new_dog dog_tab">새로운 반려견 입력</div>
								<div class="exist_dog dog_tab">내 반려견 불러오기</div>
							</div>
							<form class="dog_form">
								<div class="input_div">
									<p class="input_name">이름</p>
									<input type="text" name="dogName" class="input_set">
								</div>
								<div class="input_div">
									<p class="input_name">나이</p>
									<input type="text" name="dogName" class="input_set">
								</div>
								<div class="input_div">
									<p class="input_name">견종</p>
									<input type="text" name="dogName" class="input_set">
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
									<textarea class="significant"></textarea>
								</div>
							</form>
						</div>
					</div>
			</div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
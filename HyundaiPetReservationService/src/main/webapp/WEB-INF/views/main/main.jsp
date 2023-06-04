<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/mainpage/css/mainPage.css">
<title>Insert title here</title>
</head>
<body style="display: flex; justify-content: center;">
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/>
	</jsp:include>
	<div class="menu_detail_box">
		<div class="menu_detail_main">
			<div class="menu_detail_main_category">
				<p>화장품</p>
				<p>명품/잡화</p>
				<p>여성패션</p>
				<p>영캐주얼</p>
				<p>남성패션</p>
				<p>진/이지</p>
				<p>유아동/문화</p>
				<p>스포츠/레저</p>
				<p>리빙/가전</p>
				<p>식품</p>
				<p class="selected_detail_main_category">반려동물 ></p>
			</div>
			<div class="menu_detail_sub_category">
				<p>THE PET</p>
				<p>티셔츠</p>
				<p>아우터</p>
				<p>드레스</p>
				<p>올인원</p>
				<p>Acc</p>
				<p>리빙</p>
				<p>케어</p>
				<p>푸드</p>
				<p>예약</p>
			</div>
			<div class="menu_detail_sub_category" style="height: 200px;">
				<p>몽슈슈</p>
				<p>위드토리</p>
				<p>비쇼네</p>
				<p>하글앤넬로</p>
				<p>코코스퀘어</p>
				<p>코니도기</p>
				<p>펫컴</p>
			</div>
		</div>
	</div>
	<div class="gap"></div>
	<main>
		<div class="main_container">
			<%-- <jsp:include page="../mainform/side.jsp"/>
			<div class="main_info">
                    <!-- 여기다가 구현 -->
            </div> --%>
            <div class="slide_main_container">
            	<img alt="" src="/thepet/resources/mainpage/img/main1.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main2.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main3.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main4.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main5.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main6.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main7.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main8.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main9.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main10.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main11.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main12.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main13.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main14.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main15.jpg">
            	<img alt="" src="/thepet/resources/mainpage/img/main16.jpg">
            </div>		
		</div>
	</main>
	<hr>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
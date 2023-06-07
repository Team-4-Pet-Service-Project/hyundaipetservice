<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/mainpage/css/mainPage.css">
<link rel="stylesheet" href="/thepet/resources/mypage/css/mypage.css">
<title>The Hyundai : 예약확인</title>

 <!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
 <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
 <script src="/thepet/resources/mypage/js/mypage.js"></script>
     
</head>
<body class="container_body">
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/> 
	</jsp:include>
	<jsp:include page="../mainform/menubar.jsp" />
	<div class="gap"></div>
	<main>
		<div class="main_container">
			<jsp:include page="../mainform/side.jsp"/>
			<div class="main_info">
                    <!-- 여기다가 구현 -->
                    
                    <span style="font-weight: bold;">예약확인</span><br><br>
                    <div class="button-container">
        				<button id="buttonA" name="buttonA" class="active" style="width: 100px;">예약목록</button>
        				<button id="buttonB" name="buttonB" class="non_active" style="width: 100px;">지난예약</button>
        				<div class="side"></div>
    				</div><br><br>
    				<div>
    				<input type="hidden" id ="loginId" name="id" value="${member.id}">
    				</div>
 					<div class = "cntt">총 ${cnt}건</div>
                 	<!--테이블-->
                 	<div class="table-container">
	                 	<table class="board-table">
							<thead id="theadA">
							    <tr>
							        <th>위치</th>
							        <th>구분</th>
							        <th>이용인원</th>
							        <th>예약견</th>
							        <th>이용일자</th>
							        <th>이용금액</th>
							        <th>예약 상세</th>
							    </tr>
							</thead>
								
							<thead id="theadB">
							    <tr>
							        <th>위치</th>
							        <th>구분</th>
							        <th>이용인원</th>
							        <th>예약견</th>
							        <th>이용일자</th>
							        <th>이용금액</th>
							        <th>리뷰 작성</th>
							    </tr>
							</thead>
							<tbody>
								<c:forEach var="reserv" items="${Reserv}">
									<tr>
										<td>${reserv.address} ${reserv.addressDetail}</td>
										<td>${reserv.dogFacilities}</td>
										<td>${reserv.customerCount}</td>
										<td>${reserv.dogName}</td>
										<td>${reserv.reservationDate}  ${reserv.reservationStartTime} ~ ${reserv.reservationEndTime}</td>
										<td><fmt:formatNumber value="${reserv.price}" pattern="#,###"/>원</td>
										<td>
											<form action="/thepet/reservation/detail" method="GET">
												<input type="hidden" name="id" value="${reserv.id}">
												<input type="hidden" name="reservationId" value="${reserv.reservationId}">
  												<button type="submit" class="reservation_detail_button">예약상세</button>
											</form>
										</td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
                 	</div>
                 	
            </div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/mypage/css/mypage.css">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/mypage/js/mypage.js"></script>
 <!-- 예약목록 지냔예약 css -->
  <style>
        
    </style>
     
</head>
<body>
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/> 
	</jsp:include>
	<div class="gap"></div>
	<main>
		<div class="main_container">
			<jsp:include page="../mainform/side.jsp"/>
			<div class="main_info">
                    <!-- 여기다가 구현 -->
                    
                    <span>예약확인</span><br><br>
                    
                    <div class="button-container">
        				<button id="buttonA" name="buttonA">예약목록</button>
        				<button id="buttonB" name="buttonB">지난예약</button>
    				</div><br><br>
 					<div class = "cntt">총 ${cnt}건</div>
                 	<!--테이블-->
                 	<div class="table-container">
	                 	<table class="board-table">
							<thead id="theadA">
								    <tr>
								        <th>위치</th>
								        <th>구분</th>
								        <th>이용인원</th>
								        <th>이용일자</th>
								        <th>이용금액</th>
								        <th>예약 상세</th>
								        <th>예약 취소</th>
								    </tr>
								</thead>
								
								<thead id="theadB">
								    <tr>
								        <th>위치</th>
								        <th>구분</th>
								        <th>이용인원</th>
								        <th>이용일자</th>
								        <th>이용금액</th>
								        <th>리뷰작성</th>
								    </tr>
								</thead>
							<tbody>
								<c:forEach var="reserv" items="${Reserv}">
									<tr>
										<td>${reserv.address} ${reserv.address_detail}</td>
										<td>${reserv.dog_facilities}</td>
										<td>${reserv.customer_count}</td>
										<td>${reserv.reservation_date}  ${reserv.reservation_start_time} ~ ${reserv.reservation_end_time}</td>
										<td>${reserv.price_total}원</td>
										<td>
											<form action="/reservation/detail?dog_id=${reserv.dog_id}" method="GET">
  												<button type="submit">예약상세</button>
											</form>
										</td>
										<td>
											<form action="/reservation/cancel" method="GET">
  												<button type="submit">예약취소</button>
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
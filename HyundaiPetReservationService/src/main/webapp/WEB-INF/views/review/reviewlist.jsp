<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/review/css/reviewlist.css">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     
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
                    
                    <span>리뷰확인</span><br><br>
                    <div class="first">
                    	<div class="first_1">리뷰목록</div>
                    	<div class="first_2"></div>
                    </div>
                    
                    <br><br>            
                 	<div class = "cntt">총 ${cnt}건</div>
                 	<!--테이블-->
                 	<div class="table-container">
	                 	<table class="board-table">
							<thead>
								    <tr>
								        <th>위치</th>
								        <th>구분</th>
								        <th>이용인원</th>
								        <th>예약견</th>
								        <th>이용일자</th>
								        <th>이용금액</th>
								        <th>리뷰상세</th>
								        <th>리뷰삭제</th>
								    </tr>
								</thead>
							<tbody>
								<c:forEach var="review" items="${Review}">
									<tr>
										<td>${review.address} ${review.address_detail}</td>
										<td>${review.dog_facilities}</td>
										<td>${review.customer_count}</td>
										<td>${review.dog_name}</td>
										<td>${review.reservation_date}  ${review.reservation_start_time} ~ ${review.reservation_end_time}</td>
										<td>${review.price}원</td>
										<td>
											<form action="/thepet/review/datail2" method="GET">
												<input type="hidden" name="review_id" value="${review.review_id}">
												<input type="hidden" name="reservation_id" value="${review.reservation_id}">
												<input type="hidden" name="id" value="${review.id}">
												<button type="submit">리뷰상세</button>
											</form>
										</td>
										<td>
											<form action="/reservation/cancel" method="GET">
  												<button type="submit">리뷰삭제</button>
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
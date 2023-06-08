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
<link rel="stylesheet" href="/thepet/resources/review/css/reviewlist.css">
<title>The Hyundai : 리뷰 확인</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     
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
                    
                    <span>리뷰확인</span><br><br>
                    <div class="first">
                    	<div class="first_1">리뷰목록</div>
                    	<div class="first_2"></div>
                    </div>
                    
                    <br><br>            
                 	<div class = "cntt">총 ${cnt}건</div>
                 	<!--테이블-->
                 	<div class="table-container">
	                 	<table class="board-table" style="border-bottom : 1px solid #666666;">
							<thead>
								    <tr class="board-table_head_row">
								        <th class="board-table_common_cell">위치</th>
								        <th class="board-table_common_cell">구분</th>
								        <th class="board-table_common_cell">이용인원</th>
								        <th class="board-table_common_cell">예약견</th>
								        <th class="board-table_common_cell">이용일자</th>
								        <th class="board-table_common_cell">이용금액</th>
								        <th class="board-table_common_cell">리뷰상세</th>
								    </tr>
								</thead>
							<tbody>
								<c:forEach var="review" items="${Review}">
									<tr class="board-table_common_row">
										<td class="board-table_common_cell">${review.address} ${review.addressDetail}</td>
										<td class="board-table_common_cell">${review.dogFacilities}</td>
										<td class="board-table_common_cell">${review.customerCount}</td>
										<td class="board-table_common_cell">${review.dogName}</td>
										<td class="board-table_common_cell">${review.reservationDate}  ${review.reservationStartTime} ~ ${review.reservationEndTime}</td>
										<td class="board-table_common_cell"><fmt:formatNumber value="${review.price}" pattern="#,###"/>원</td>
										<td class="board-table_common_cell">
											<form action="/thepet/review/detail2" method="GET">
												<input type="hidden" name="reviewId" value="${review.reviewId}">
												<input type="hidden" name="reservationId" value="${review.reservationId}">
												<input type="hidden" name="id" value="${review.id}">
												<button type="submit" class="board-table_review_detail_button">리뷰상세</button>
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
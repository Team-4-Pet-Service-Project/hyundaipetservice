<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/reservationdetail/css/reservationdetail.css">
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
                    <div class="reservdetail">예약상세</div>
                    
                    <div class="reservinfo">예약자 정보</div>
                    
                    <table>
                    	<tr>
						    <th>이름</th>
						    <th>핸드폰</th>
						    <th>이메일</th>
					    </tr>
					    <tr>
					      <td>${Reservationdetail.name}</td>
					      <td>${Reservationdetail.phone}</td>
					      <td>${Reservationdetail.email}</td>
					    </tr>
                    </table>
                    
                    
                    <div class="reservdog">예약견 정보</div>
                    <table>
                    	<tr>
						    <th>이름</th>
						    <th>나이</th>
						    <th>분류</th>
							<th>견종</th>
							<th>특이사항</th>
					    </tr>
					    <tr>
					      <td>${Reservationdetail.dogName}</td>
					      <td>${Reservationdetail.dogAge}</td>
					      <td>${Reservationdetail.dogSize}</td>
						  <td>${Reservationdetail.breed}</td>
						  <td>${Reservationdetail.specialNote}</td>
					    </tr>
                    </table>
                    
                    <div class="reservlist">예약내역</div>
                    <div class="reservlist_1">
                    	<div class="num">
                    		<div>예약번호</div>
                    		<div>${Reservationdetail.reservationId}</div>
                    		<input type="hidden" id="reservationId" name="reservationId" value="${Reservationdetail.reservationId}">
                    	</div>
                    	<div class="loc">
                    		<div>위치</div>
                    		<div>${Reservationdetail.address} ${Reservationdetail.addressDetail}</div>
                    	</div>
                    	<div class="classfication">
                    		<div>구분</div>
                    		<div>${Reservationdetail.dogFacilities}</div>
                    	</div>
                    	<div class="date">
                    		<div>이용일자</div>
                    		<div>${Reservationdetail.reservationDate} ${Reservationdetail.reservationStartTime} ~ ${Reservationdetail.reservationEndTime}</div>
                    	</div>
                    	<div class="plus">
                    		<div>추가인원</div>
                    		<div>${Reservationdetail.customerCount}</div>
                    	</div>
                    </div>
                 	
                 	<div class="total">총 이용금액</div>
                 	<div class="total_1">
                 		<div class="price1">결제완료 금액</div>
                 		
                 		<div class="price2"><fmt:formatNumber value="${Reservationdetail.price}" pattern="#,###"/>원</div>
                 	</div>
                 	
                 	<div class="last">
                 		<input type="button" class="list-button" value="목록">
                 		<input type="button" class="cancel-button" value="예약 취소">
                 	</div>
                 	<div id="modal" class="modal-overlay">
								        <div class="modal-window">
								        	<div class="modal-topwindow">
								        		<div class="close-area1"></div>
								        		<div class="title">예약삭제</div>
								            	<div class="close-area">X</div>
								        	</div>
								        	<span class="material-symbols-outlined" style="font-size:80px; margin-left : 160px;">check_circle</span>
								            <div class="reviewmodal">예약을 삭제하시겠습니까?</div>
								            <div class="content">
								                <button id="cancelButton">취소</button>
												<button id="confirmButton">확인</button>
								            </div>
								        </div>
								    </div> 
            </div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
<script src="/thepet/resources/reservationdetail/js/reservationdetail.js"></script>
</body>
</html>
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
<link rel="stylesheet" href="/thepet/resources/reservationdetail/css/reservationdetail.css">
<title>The Hyundai : 예약 상세</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 
     
</head>
<body class="container_body">
<div class="container">
	<jsp:include page="../mainform/header.jsp">
		<jsp:param value="석진" name="userName"/> 
	</jsp:include>
	<jsp:include page="../mainform/menubar.jsp" />
	<div class="gap"></div>
	<main style="margin-bottom: 20px;">
		<div class="main_container">
			<jsp:include page="../mainform/side.jsp"/>
			<div class="main_info">
                    <!-- 여기다가 구현 -->
                    <div class="reservdetail">예약상세</div>
                    
                    <div class="reservinfo">예약자 정보</div>
                    
                    <table class="reservation_info_detail_table">
                    	<tr class="reservation_info_detail_table_head">
						    <th class="reservation_info_detail_head_cell">이름</th>
						    <th class="reservation_info_detail_head_cell">핸드폰</th>
						    <th class="reservation_info_detail_head_cell">이메일</th>
					    </tr>
					    <tr class="reservation_info_detail_table_row">
					      <td class="reservation_info_detail_row_cell">${Reservationdetail.name}</td>
					      <td class="reservation_info_detail_row_cell">${Reservationdetail.phone}</td>
					      <td class="reservation_info_detail_row_cell">${Reservationdetail.email}</td>
					    </tr>
                    </table>
                    
                    
                    <div class="reservdog">예약견 정보</div>
                    <table class="reservation_info_detail_table">
                    	<tr class="reservation_info_detail_table_head">
						    <th class="reservation_info_detail_head_cell">이름</th>
						    <th class="reservation_info_detail_head_cell">나이</th>
						    <th class="reservation_info_detail_head_cell">분류</th>
							<th class="reservation_info_detail_head_cell">견종</th>
							<th class="reservation_info_detail_head_cell">특이사항</th>
					    </tr>
					    <tr class="reservation_info_detail_table_row">
					      <td class="reservation_info_detail_row_cell">${Reservationdetail.dogName}</td>
					      <td class="reservation_info_detail_row_cell">${Reservationdetail.dogAge}</td>
					      <td class="reservation_info_detail_row_cell">${Reservationdetail.dogSize}</td>
						  <td class="reservation_info_detail_row_cell">${Reservationdetail.breed}</td>
						  <td class="reservation_info_detail_row_cell">${Reservationdetail.specialNote}</td>
					    </tr>
                    </table>
                    
                    <div class="reservlist">예약내역</div>
                    
                    <table class="reservation_history_table">
                    	<tr class="reservation_history_table_row">
                    		<td class="reservation_history_table_head_cell">예약번호</td>
                    		<td class="reservation_history_table_cell">${Reservationdetail.reservationId}</td>
                    		<td style="display: none;" class="reservationId">${Reservationdetail.reservationId}</td>
                    	</tr>
                    	<tr class="reservation_history_table_row">
                    		<td class="reservation_history_table_head_cell">위치</td>
                    		<td class="reservation_history_table_cell">${Reservationdetail.address} ${Reservationdetail.addressDetail}</td>
                    	</tr>
                    	<tr class="reservation_history_table_row">
                    		<td class="reservation_history_table_head_cell">구분</td>
                    		<td class="reservation_history_table_cell">${Reservationdetail.dogFacilities}</td>
                    	</tr>
                    	<tr class="reservation_history_table_row">
                    		<td class="reservation_history_table_head_cell">이용일자</td>
                    		<td class="reservation_history_table_cell">${Reservationdetail.reservationDate} ${Reservationdetail.reservationStartTime} ~ ${Reservationdetail.reservationEndTime}</td>
                    	</tr>
                    	<tr class="reservation_history_table_row" style="border-bottom: 1px solid #666666;">
                    		<td class="reservation_history_table_head_cell">추가인원</td>
                    		<td class="reservation_history_table_cell">${Reservationdetail.customerCount}</td>
                    	</tr>
                    </table>
                 	
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
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="/thepet/resources/review/css/reviewdetail.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>리뷰 상세 페이지</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>   
 
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
                    <input type="hidden" id="hidList" value="${Review.rate}" />
                    <span>리뷰상세</span><br><br>
                    <div class="line"></div>
                   
                    <div class="first">
                    	<div class="first_1">[${name}]님</div>
                    	<div class="rating">
                    		<div>평점 :</div>
    						<i class="far fa-star" data-rate="1"></i>
    						<i class="far fa-star" data-rate="2"></i>
    						<i class="far fa-star" data-rate="3"></i>
    						<i class="far fa-star" data-rate="4"></i>
    						<i class="far fa-star" data-rate="5"></i>
  						</div>
                    	<div class="first_3">${Review.createdTime}</div>
                    </div>
                    
                    <div class="second">
                    	<div class="service">
                    		<div class="service_1">서비스</div>
                    		<div class="service_2">${Review.serviceBt}</div>
                    	</div>
                    	<div class="space">
                    		<div class="space_1">공간</div>
                    		<div class="space_2">${Review.spaceBt}</div>
                    	</div>
                    	<div class="environment">
                    		<div class="environment_1">환경</div>
                    		<div class="environment_2">${Review.cleanBt}</div>
                    	</div>
						<div class="revisit">
							<div class="revisit_1">재방문의사</div>
							<div class="revisit_2">${Review.revisitBt}</div>
						</div>                    	
                    	
                    </div>
                    
                    	
                 	<div class="four">
                 		<div class="four_1">
                 			<c:choose>
		         				<c:when test="${Review1 eq null}">
		                			<img src="/thepet/resources/review/img/no.png">
		            			</c:when>
					            <c:otherwise>
					                <img src='/thepet/image/display?fileName=${path}' style="width: 230px; height: 220px;">
					            </c:otherwise>
        					</c:choose>
                 		</div>
                 		<div class="four_2">${Review.userContents}</div>
                 	</div>
                 	
                 	<div class="line1"></div>
                 	<br>
                 	
                 	<!-- 여기에 관리자 답글 영역 추가 -->
                 	<div class="font-bold">관리자 답변</div>
                 	<div>
                 	<input class="admin-contents" type="text" readonly value="${empty Review.adminContents ? '관리자 답변이 존재하지 않습니다.' : Review.adminContents}"/>
                 	</div>
                 	
                 	<br>
                 	<%-- <form action="/thepet/review/delete" method="GET">
				                    <input type="submit" value="삭제">
				                    <input type="hidden" name="reservationId" value="${Review.reservationId}">
				                </form> --%>
                 	<!-- 수정삭제나오는 부분(여기서 관리자 조건 걸어주면 됨 -->
                 	<!--  나중에 조건 넣어준다  ${Id} eq 세션아이디 같은 조건 걸어주기-->
                 	 <c:choose>
	            			<c:when test="${Id eq 0}"> <!-- member Id가 현재 로그인한 사용자 Id라면 아래 내용 보이도록 수정 -->
	            				<div class="five">
	            					<div class="five_1">
			                			<form action="/thepet/review/update" method="GET">
			                    			<input type="hidden" name="serviceBt" value="${Review.serviceBt}">
			                    			<input type="hidden" name="spaceBt" value="${Review.spaceBt}">
			                    			<input type="hidden" name="cleanBt" value="${Review.cleanBt}">
			                    			<input type="hidden" name="revisitBt" value="${Review.revisitBt}">
			                    			<input type="hidden" name="rate" value="${Review.rate}">
			                    			<input type="hidden" name="reservationId" value="${Review.reservationId}">
			                    			<input type="hidden" name="userContents" value="${Review.userContents}">
			                    			<input type="hidden" name="filename" value="${path}">
			                    			<input type="hidden" name="uuid" value="${Review1.uuid}">
			                    			<input type="hidden" id="reviewId" name="reviewId" value="${Review.reviewId}">
			                    			<input type="hidden" name="uploadpath" value="${Review1.uploadpath}">
			                    			<input type="hidden" name="name" value="${name}">
			                    			<input type="submit" value="수정">
			                			</form>
	                				</div>
	                				
	                				<div id="container">
								        <button id="btn-modal">삭제</button>
								    </div>
								    <div id="modal" class="modal-overlay">
								        <div class="modal-window">
								        	<div class="modal-topwindow">
								        		<div class="close-area1"></div>
								        		<div class="title">리뷰삭제</div>
								            	<div class="close-area">X</div>
								        	</div>
								        	<span class="material-symbols-outlined" style="font-size:80px; margin-left : 160px;">check_circle</span>
								            <div class="reviewmodal">리뷰를 삭제하시겠습니까?</div>
								            <div class="content">
								                <button id="cancelButton">취소</button>
												<button id="confirmButton">확인</button>
								            </div>
								        </div>
								    </div>
	                			</div>
				            </c:when>
				            
				            
				            
				            <c:when test="${admin eq 1}"> <!-- 관리자 -->
				            	<input type="hidden" id="reviewId" name="reviewId" value="${Review.reviewId}">
						        <c:choose>
						            <c:when test="${empty Review.adminContents}"> <!-- 답변이 없는 경우 -->
							            <div class="five">
							                <div class="five_1">
							                	<input type="button" class="add-button" value="답변 등록">
							                	<input type="hidden" class="cancel-button" value="답변 취소">
							                </div>
							                <div class="five_1">
							                	
							               		<input type="hidden" class="update-button" value="답변 등록">
							                </div>
							                
						                </div>
						            </c:when>
						            <c:otherwise> <!-- 답변이 있는 경우 -->
						            	<div class="five">
						            		<div class="five_1">
							                	<input type="button" class="modify-button" value="답변 수정">
							                	<input type="hidden" class="cancel-button" value="답변 취소">
							                </div>
							                <div class="five_1">
							                	<input type="button" class="delete-button" value="답변 삭제">
							                	<input type="hidden" class="update-button" value="답변 등록">
							                </div>
						                </div>
						            </c:otherwise>
						        </c:choose>
						    </c:when>
        			</c:choose>
            </div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
<script src="/thepet/resources/review/js/reviewdetail.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/review/css/reviewdetail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/review/js/reviewdetail.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>   
 
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
                    <input type="hidden" id="hidList" value="${Review.rate}" />
                    <span>리뷰상세</span><br><br>
                    <div class="line"></div>
                   
                    <div class="first">
                    	<div class="first_1">[name]님</div>
              
                    	<div class="rating">
                    		<div>평점 :</div>
    						<i class="far fa-star" data-rate="1"></i>
    						<i class="far fa-star" data-rate="2"></i>
    						<i class="far fa-star" data-rate="3"></i>
    						<i class="far fa-star" data-rate="4"></i>
    						<i class="far fa-star" data-rate="5"></i>
  						</div>
                    	<div class="first_3">${Review.created_time}</div>
                    </div>
                    
                    <div class="second">
                    	<div>서비스</div>
                    	<div>공간</div>
                    	<div>환경</div>
                    	<div>재방문의사</div>
                    </div>
                    
                    <div class = "three">
                    	<div>${Review.service_bt}</div>
                    	<div>${Review.space_bt}</div>
                    	<div>${Review.clean_bt}</div>
                    	<div>${Review.revisit_bt}</div>
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
                 		<div class="four_2">${Review.user_contents}</div>
                 	</div>
                 	
                 	<div class="line1"></div>
                 	
                 	
                 	<!-- 수정삭제나오는 부분(여기서 관리자 조건 걸어주면 됨 -->
                 	<!--  나중에 조건 넣어준다  ${Id} eq 세션아이디 같은 조건 걸어주기-->
                 	 <c:choose>
                 	 	
	            			<c:when test="${Id eq 1}">
	            				<div class="five">
	            					<div class="five_1">
			                			<form action="/thepet/review/update" method="GET">
			                    			<input type="hidden" name="service_bt" value="${Review.service_bt}">
			                    			<input type="hidden" name="space_bt" value="${Review.space_bt}">
			                    			<input type="hidden" name="clean_bt" value="${Review.clean_bt}">
			                    			<input type="hidden" name="revisit_bt" value="${Review.revisit_bt}">
			                    			<input type="hidden" name="rate" value="${Review.rate}">
			                    			<input type="hidden" name="reservation_id" value="${Review.reservation_id}">
			                    			<input type="hidden" name="user_contents" value="${Review.user_contents}">
			                    			<input type="hidden" name="filename" value="${path}">
			                    			<input type="hidden" name="uuid" value="${Review1.uuid}">
			                    			<input type="hidden" name="uploadpath" value="${Review1.uploadpath}">
			                    			<input type="submit" value="수정">
			                			</form>
	                				</div>
				                <form action="/thepet/review/delete" method="GET">
				                    <input type="submit" value="삭제">
				                    <input type="hidden" name="reservation_id" value="${Review.reservation_id}">
				                </form>
	                			</div>
				            </c:when>
				            <c:otherwise>
				               
				            </c:otherwise>
        				</c:choose>
            </div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/mainpage/css/mainPage.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="/thepet/resources/review/css/reviewtotallist1.css">
<title>The Hyundai : 전체 리뷰</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/review/js/reviewtotallist1.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>       
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
                    
                    <div class="location">
                    	<div class="location_1">지점 선택</div>
	                    	<div class="radio-container">
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="address" value="서울" checked>
                           			<span class="radio-custom">서울</span>
                        		</label>
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="address" value="대구"> 
                          			<span class="radio-custom">대구</span>
                        		</label> 
                     		</div>
                    </div>
                    
                    <div class="facility">
                    	<div class="facility_1">시설 선택</div>
                    	<div class="radio-container1">
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="dogFacilities" value="케어" checked>
                           			<span class="radio-custom1">케어</span>
                        		</label>
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="dogFacilities" value="놀이터"> 
                           			<span class="radio-custom1">놀이터</span>
                        		</label> 
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="dogFacilities" value="미용">
          							<span class="radio-custom1">미용</span>
          						</label>
          						<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="dogFacilities" value="스파">
          							<span class="radio-custom1">스파</span>
          						</label>
                     	</div>
                    </div>
                    
                 	<div class="spec" >서울 > 케어</div>
                 	<div class="total">
                 		<c:forEach var="review" items="${Review}">
                 			<div class="list1">
                 			<input type="hidden" name="id" value="${review.id}">
		                 	<input type="hidden" name="reservationId" value="${review.reservationId}">
		                 	
		                 	<div class = "review">
		                 		
		                 		<div class = "review_1">
		                 			<div class = "name">[${review.name}]님</div>
		                 			<div class="rating">
		                    			<div class="rating_1">평점 : </div>
		                    			<div class="star-group">
			                    			<input type="hidden" id="hidList" value="${review.rate}" />
				    						<i class="fa-solid fa-star fas zero_star" data-rate="1"></i>
				    						<i class="fa-solid fa-star fas zero_star" data-rate="2"></i>
				    						<i class="fa-solid fa-star fas zero_star" data-rate="3"></i>
				    						<i class="fa-solid fa-star fas zero_star" data-rate="4"></i>
				    						<i class="fa-solid fa-star fas zero_star" data-rate="5"></i>
			  							</div>
			  						</div>
			  						<div class="date">작성날짜 : ${review.createdTime}</div>
		                 		</div>
		                 		<div class = "review_2">
		                 			<div class = "image">
		                 				<c:choose>
					         				<c:when test="${review.uuid eq null}">
					                			<img src="/thepet/resources/review/img/no.png">
					            			</c:when>
								            <c:otherwise>
								            <img src="/thepet/image/display?fileName=${fn:replace(review.uploadpath, '\\', '/')}/${review.filename}" style="width: 210px; height: 220px;">
								            </c:otherwise>
		        						</c:choose>
		                 			</div>
		                 			<div class="contents">${review.userContents}</div>
		                 		</div>
		                 	</div>
		                 	
		                 	<div class="admin">
		                 		<div class="admin_1">관리자 답글</div>
		                 			<c:choose>
			                 			<c:when test="${review.adminContents eq null}">
			                 				<div class="admin_2">관리자 답변이 존재하지 않습니다.</div>
			                 			</c:when>
			                 			<c:otherwise>
			                 				<div class="admin_2">${review.adminContents}</div>
			                 			</c:otherwise>
			                 		</c:choose>
		                 	</div>
		                 </div>
		                 </c:forEach>
		                <script>
							  document.addEventListener('DOMContentLoaded', function() {
							    const starGroups = document.querySelectorAll('.star-group');
							    for (const group of starGroups) {
							      const initial = group.querySelector('#hidList');
							      if (initial) {
							        const initialRate = parseInt(initial.value);
							        const stars = group.querySelectorAll('i');
							        for (let i = 0; i < initialRate; i++) {
							          stars[i].classList.add('full_star'); // fas 클래스 추가
							          stars[i].classList.remove('zero_star'); // far 클래스 제거
							        }
							      }
							    }
							  });
						</script>
						
						<div class="pageInfo_wrap" >
					        <div class="pageInfo_area">
					        	<ul id="pageInfo" class="pageInfo no_dot" >
					 			 <!-- 이전페이지 버튼 -->
					                <c:if test="${pageMaker.prev}">
					                    <li class="pageInfo_btn previous"><a href="/thepet/review/totallist1?locationId=1&pageNum=${pageMaker.startPage-1}">Previous</a></li>
					                </c:if>
					 			 
					 			 <!-- 각 번호 페이지 버튼 -->
				                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				                    <li class="pageInfo_btn"><a href="/thepet/review/totallist1?locationId=1&pageNum=${num}" onclick="handleClick(this);">${num}</a></li>
				                </c:forEach>
				                
				                	 <!-- 다음페이지 버튼 -->
					                <c:if test="${pageMaker.next}">
					                    <li class="pageInfo_btn next"><a href="/thepet/review/totallist1?locationId=1&pageNum=${pageMaker.endPage + 1 }">Next</a></li>
					                </c:if> 
					                </ul>
					        </div>
					    </div>
						
						
		                
        				    
		           
		           
		           </div>
		      </div>
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
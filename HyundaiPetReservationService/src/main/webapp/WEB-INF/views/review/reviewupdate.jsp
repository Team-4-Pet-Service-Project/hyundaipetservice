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
<link rel="stylesheet" href="/thepet/resources/review/css/reviewupdate.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/review/js/reviewupdate.js"></script>
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
                    <form id="myForm"action="/thepet/review/updatecom" method="post">
                    	<input type="hidden" name="reservationId" value="${Review.reservationId}">
	                   	<input type="hidden" id="uuid" name="uuid" value="${Review.uuid}">
	                   	<input type="hidden" name="reviewId" value="${Review.reviewId}">
	                   	<input type="hidden" id="uploadpath" name="uploadpath" value="${Review.uploadpath}">
	                   <div class="start">
	                    <div class="one">리뷰수정</div>
	                    <div class="two">
	                    	<div class="two_1">[${name}님] 시설은 어떠셨나요??</div>
	                    	<div class="rating">
	    						<i class="far fa-star" data-rate="1"></i>
	    						<i class="far fa-star" data-rate="2"></i>
	    						<i class="far fa-star" data-rate="3"></i>
	    						<i class="far fa-star" data-rate="4"></i>
	    						<i class="far fa-star" data-rate="5"></i>
	  						</div>
	                    	  <input type="hidden" id="selected-rate" name="rate" value="${Review.rate}">
	                    </div>
	                    <div class="three">
	                    	<div class="three_1">
	                    		<div >서비스</div>
	                    		<div class="radio-container">
	                        		<label class="radio-label" >
	                        			<input class="radio-input" type="radio" name="serviceBt" value="친절해요" ${Review.serviceBt == '친절해요' ? 'checked' : ''}>
	                           			<span class="radio-custom">친절해요</span>
	                        		</label>
	                        		<label class="radio-label"> 
	                           			<input class="radio-input" type="radio" name="serviceBt" value="그저 그래요" ${Review.serviceBt == '그저 그래요' ? 'checked' : ''}> 
	                           			<span class="radio-custom">그저 그래요</span>
	                        		</label> 
	                        		<label class="radio-label"> 
	                           			<input class="radio-input" type="radio" name="serviceBt" value="불친절해요" ${Review.serviceBt == '불친절해요' ? 'checked' : ''}>
	          							<span class="radio-custom">불친절해요</span>
	          							</label>
	                     		</div>
	                    </div>
	                    	
	                    	<div class="three_2">
	                    		<div>공간</div>
	                    		<div class="radio-container1">
	                        		<label class="radio-label1"> 
	                           			<input class="radio-input" type="radio" name="spaceBt" value="넓어요" ${Review.spaceBt == '넓어요' ? 'checked' : ''}>
	                           			<span class="radio-custom1">넓어요</span>
	                        		</label>
	                        		<label class="radio-label1"> 
	                           			<input class="radio-input" type="radio" name="spaceBt" value="적당해요" ${Review.spaceBt == '적당해요' ? 'checked' : ''}> 
	                           			<span class="radio-custom1">적당해요</span>
	                        		</label> 
	                        		<label class="radio-label1"> 
	                           			<input class="radio-input" type="radio" name="spaceBt" value="좁아요" ${Review.spaceBt == '좁아요' ? 'checked' : ''}>
	          							<span class="radio-custom1">좁아요</span>
	          							</label>
	                     		</div>
	                    	</div>
	                    	
	                    	<div class="three_3">
	                    		<div>청결도</div>
	                    		<div class="radio-container">
	                        		<label class="radio-label1"> 
	                           			<input class="radio-input" type="radio" name="cleanBt" value="쾌적해요" ${Review.cleanBt == '쾌적해요' ? 'checked' : ''}>
	                           			<span class="radio-custom1">쾌적해요</span>
	                        		</label>
	                        		<label class="radio-label1"> 
	                           			<input class="radio-input" type="radio" name="cleanBt" value="적당해요" ${Review.cleanBt == '적당해요' ? 'checked' : ''}> 
	                           			<span class="radio-custom1">적당해요</span>
	                        		</label> 
	                        		<label class="radio-label1"> 
	                           			<input class="radio-input" type="radio" name="cleanBt" value="더러워요" ${Review.cleanBt == '더러워요' ? 'checked' : ''}>
	          							<span class="radio-custom1">더러워요</span>
	          							</label>
	                     		</div>
	                    	</div>
	                    	
	                    	<div class="three_4">
	                    		<div>재방문의사</div>
	                    		<div class="radio-container2">
	                        		<label class="radio-label"> 
	                           			<input class="radio-input" type="radio" name="revisitBt" value="무조건이죠" ${Review.revisitBt == '무조건이죠' ? 'checked' : ''}>
	                           			<span class="radio-custom">무조건이죠</span>
	                        		</label>
	                        		<label class="radio-label"> 
	                           			<input class="radio-input" type="radio" name="revisitBt" value="애매해요" ${Review.revisitBt == '애매해요' ? 'checked' : ''}> 
	                           			<span class="radio-custom">애매해요</span>
	                        		</label> 
	                        		<label class="radio-label"> 
	                           			<input class="radio-input" type="radio" name="revisitBt" value="없어요" ${Review.revisitBt == '없어요' ? 'checked' : ''}>
	          							<span class="radio-custom">없어요</span>
	          							</label>
	                     		</div>
	                    	</div>
	                    </div>
	                    <div class="four">
	                    	<div class="four_1">이미지</div>
	                    	
	                    		<c:choose>
	                    			<c:when test="${Review.filename eq ''}">
	                    				<div class="four_2"><input type="file" id="uploadFile" name="uploadFile"></div>
	                    				<div id="uploadResult">
                    						
										</div>
	                    			</c:when>
	                    			
	                    			<c:otherwise>
	                    				<div id="uploadResult">
                    						<div id='result_card1'>
												<img src='/thepet/image/display?fileName=${Review.filename}' style="width: 130px; height: 130px; margin-left: 200px;">
												<div class='imgDeleteBtn1' data-file='" + fileCallPath + "'>X</div>
											</div>
										</div>
	                    				
	                    			</c:otherwise>
	                    		</c:choose>
							</div>
	                    </div>
	                    <div class="five">
	                    	<div>이용시설</div>
	                    	<div class="five_1">${Location.dogFacilities}</div>
	                    </div>
	                    <div class="six">
	                    	<div>이용일자</div>
	                    	<div class="six_1">${Location.reservationDate} ${Location.reservationStartTime} ~ ${Location.reservationEndTime}</div>
	                    </div>
	                    <div class="seven">
	                    	<div>리뷰작성</div>
	                    	<div class="seven_1"><textarea class="seven_1" name="userContents" rows="8" cols="60" required>${Review.userContents}</textarea></div>
	                    	<div class="eight"><input type="submit" value="리뷰 수정" onclick="validateForm(event)"></div>
	                    </div> 
                   
                    </form>    
 
                </div>
            </div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
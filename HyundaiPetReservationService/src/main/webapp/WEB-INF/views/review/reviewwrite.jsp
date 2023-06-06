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
<link rel="stylesheet" href="/thepet/resources/review/css/reviewwrite.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>The Hyundai : 리뷰 작성</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/review/js/reviewwrite.js"></script>
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
                    
                    <form id="myForm"action="/thepet/review/writecheck" method="post">
                    	<input type="hidden" name="reservationId" value="${Reserv.reservationId}">
                    <div class="start">
                    <div class="one">리뷰작성</div>
                    <div class="two">
                    	<div class="two_1">[${member.name}님] 시설은 어떠셨나요??</div>
                    	<div class="rating">
    						<i class="far fa-star" data-rate="1"></i>
    						<i class="far fa-star" data-rate="2"></i>
    						<i class="far fa-star" data-rate="3"></i>
    						<i class="far fa-star" data-rate="4"></i>
    						<i class="far fa-star" data-rate="5"></i>
  						</div>
                    	  <input type="hidden" id="selected-rate" name="rate" value="0">
                    </div>
                    <div class="three">
                    	<div class="three_1">
                    		<div >서비스</div>
                    		<div class="radio-container">
                        		<label class="radio-label" > 
                           			<input class="radio-input" type="radio" name="serviceBt" value="친절해요" checked>
                           			<span class="radio-custom">친절해요</span>
                        		</label>
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="serviceBt" value="그저 그래요"> 
                           			<span class="radio-custom">그저 그래요</span>
                        		</label> 
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="serviceBt" value="불친절해요">
          							<span class="radio-custom">불친절해요</span>
          							</label>
                     		</div>
                    </div>
                    	
                    	<div class="three_2">
                    		<div>공간</div>
                    		<div class="radio-container1">
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="spaceBt" value="넓어요" checked>
                           			<span class="radio-custom1">넓어요</span>
                        		</label>
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="spaceBt" value="적당해요"> 
                           			<span class="radio-custom1">적당해요</span>
                        		</label> 
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="spaceBt" value="좁아요">
          							<span class="radio-custom1">좁아요</span>
          							</label>
                     		</div>
                    	</div>
                    	
                    	<div class="three_3">
                    		<div>청결도</div>
                    		<div class="radio-container">
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="cleanBt" value="쾌적해요" checked>
                           			<span class="radio-custom1">쾌적해요</span>
                        		</label>
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="cleanBt" value="적당해요"> 
                           			<span class="radio-custom1">적당해요</span>
                        		</label> 
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="cleanBt" value="더러워요">
          							<span class="radio-custom1">더러워요</span>
          							</label>
                     		</div>
                    	</div>
                    	
                    	<div class="three_4">
                    		<div>재방문의사</div>
                    		<div class="radio-container2">
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="revisitBt" value="무조건이죠" checked>
                           			<span class="radio-custom">무조건이죠</span>
                        		</label>
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="revisitBt" value="애매해요"> 
                           			<span class="radio-custom">애매해요</span>
                        		</label> 
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="revisitBt" value="없어요">
          							<span class="radio-custom">없어요</span>
          							</label>
                     		</div>
                    	</div>
                    </div>
                    <div class="four">
                    	<div class="four_1">이미지</div>
                    	<div class="four_2">
                    		<input type="file" id="uploadFile" name="uploadFile">
                    		<div id="uploadResult"></div>
                    	</div>
                    	
                    </div>
                    
                    <div class="five">
                    	<div>이용시설</div>
                    	<div class="five_1">${Reserv.dogFacilities}</div>
                    </div>
                    <div class="six">
                    	<div>이용일자</div>
                    	<div class="six_1">${Reserv.reservationDate} ${Reserv.reservationStartTime} ~ ${Reserv.reservationEndTime}</div>
                    </div>
                    <div class="seven">
                    	<div>리뷰작성</div>
                    	<div class="seven_1"><textarea class="seven_1" name="userContents" rows="8" cols="60" required></textarea></div>
                    	<div class="eight"><input type="submit" value="리뷰 작성" onclick="validateForm(event)"></div>
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
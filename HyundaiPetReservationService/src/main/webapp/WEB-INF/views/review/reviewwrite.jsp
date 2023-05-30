<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/review/css/reviewwrite.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/review/js/reviewwrite.js"></script>
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
                    
                    <form id="myForm"action="/thepet/review/writecheck" method="post">
                    	<input type="hidden" name="reservation_id" value="${Reserv.reservation_id}">
                    <div class="start">
                    <div class="one">리뷰작성</div>
                    <div class="two">
                    	<div class="two_1">[Name님] 시설은 어떠셨나요??</div>
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
                           			<input class="radio-input" type="radio" name="service_bt" value="친절해요" checked>
                           			<span class="radio-custom">친절해요</span>
                        		</label>
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="service_bt" value="그저 그래요"> 
                           			<span class="radio-custom">그저 그래요</span>
                        		</label> 
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="service_bt" value="불친절해요">
          							<span class="radio-custom">불친절해요</span>
          							</label>
                     		</div>
                    </div>
                    	
                    	<div class="three_2">
                    		<div>공간</div>
                    		<div class="radio-container1">
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="space_bt" value="넓어요" checked>
                           			<span class="radio-custom1">넓어요</span>
                        		</label>
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="space_bt" value="적당해요"> 
                           			<span class="radio-custom1">적당해요</span>
                        		</label> 
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="space_bt" value="좁아요">
          							<span class="radio-custom1">좁아요</span>
          							</label>
                     		</div>
                    	</div>
                    	
                    	<div class="three_3">
                    		<div>청결도</div>
                    		<div class="radio-container">
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="clean_bt" value="쾌적해요" checked>
                           			<span class="radio-custom1">쾌적해요</span>
                        		</label>
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="clean_bt" value="적당해요"> 
                           			<span class="radio-custom1">적당해요</span>
                        		</label> 
                        		<label class="radio-label1"> 
                           			<input class="radio-input" type="radio" name="clean_bt" value="더러워요">
          							<span class="radio-custom1">더러워요</span>
          							</label>
                     		</div>
                    	</div>
                    	
                    	<div class="three_4">
                    		<div>재방문의사</div>
                    		<div class="radio-container2">
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="revisit_bt" value="무조건이죠" checked>
                           			<span class="radio-custom">무조건이죠</span>
                        		</label>
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="revisit_bt" value="애매해요"> 
                           			<span class="radio-custom">애매해요</span>
                        		</label> 
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="revisit_bt" value="없어요">
          							<span class="radio-custom">없어요</span>
          							</label>
                     		</div>
                    	</div>
                    </div>
                    <div class="four">
                    	<div class="four_1">이미지</div>
                    	<div class="four_2"><input type="file" id="uploadFile" name="uploadFile"></div>
                    	<div id="uploadResult">
                    		<!-- <div id="result_card">
								<div class="imgDeleteBtn">x</div>

							</div> -->
						</div>
                    </div>
                    <div class="five">
                    	<div>이용시설</div>
                    	<div class="five_1">${Reserv.dog_facilities}</div>
                    </div>
                    <div class="six">
                    	<div>이용일자</div>
                    	<div class="six_1">${Reserv.reservation_date} ${Reserv.reservation_start_time} ~ ${Reserv.reservation_end_time}</div>
                    </div>
                    <div class="seven">
                    	<div>리뷰작성</div>
                    	<div class="seven_1"><textarea class="seven_1" name="user_contents" rows="8" cols="60" required></textarea></div>
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
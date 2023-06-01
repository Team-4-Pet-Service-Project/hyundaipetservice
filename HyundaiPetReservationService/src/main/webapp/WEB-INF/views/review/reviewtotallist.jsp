<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/container.css">
<link rel="stylesheet" href="/thepet/resources/review/css/reviewtotallist.css">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="/thepet/resources/mypage/js/mypage.js"></script>
     
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
                    
                    <div class="location">
                    	<div class="location_1">지점 선택</div>
	                    	<div class="radio-container">
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="experience" value="서울">
                           			<span class="radio-custom">서울</span>
                        		</label>
                        		<label class="radio-label"> 
                           			<input class="radio-input" type="radio" name="experience" value="대구"> 
                          			<span class="radio-custom">대구</span>
                        		</label> 
                     	</div>
                    </div>
                    
                 
                 	
            </div>		
		</div>
	</main>
	<jsp:include page="../mainform/footer.jsp"/>
</div>
</body>
</html>
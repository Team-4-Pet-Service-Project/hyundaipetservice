<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/reset.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/container.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/admin/css/review.css?<%=System.currentTimeMillis()%>">
<title>관리자 페이지</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<jsp:include page="../mainform/side.jsp" />
				<div class="main_info">
					<div class="admin_main">
						<div class="admin_title">
							<h1>관리화면</h1>
							<h2>ADMIN HYUNDAI</h2>
						</div>
						<div class="admin_menu_bar">
							<h3>메뉴바</h3>
						</div>
						<br>
						<div class="review_no_comment">
							<div class="cnt"><h3>답변하지 않은 고객 리뷰 총 ${cnt} 건</h3></div>
		                 	<!--테이블-->
		                 	<div class="table-container">
			                 	<table class="board-table">
									<thead>
										    <tr>
										        <th>구분</th>
										        <th>이용일자</th>
										        <th>평점</th>
										        <th>서비스 만족도</th>
										        <th>공간</th>
										        <th>청결도</th>
										        <th>재방문 의사</th>
										        <th>답변 등록</th>
										    </tr>
										</thead>
									<tbody>
										<c:forEach var="reviewNoComment" items="${ReviewNoComment}">
											<tr>
												<td>${reviewNoComment.dogFacilities}</td>
												<td>${reviewNoComment.reservationDate}</td>
												<td>${reviewNoComment.rate}</td>
												<td>${reviewNoComment.serviceBt}</td>
												<td>${reviewNoComment.spaceBt}</td>
												<td>${reviewNoComment.cleanBt}</td>
												<td>${reviewNoComment.revisitBt}</td>
												<td>
													<form action="/thepet/admin/review/detail" method="GET">
														<input type="hidden" name="reservationId" value="${reviewNoComment.reviewId}">
														<input type="hidden" name="reservationId" value="${reviewNoComment.reservationId}">
														<input type="hidden" name="id" value="${reviewNoComment.memberId}">
														<button type="submit">답변 등록</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
		                 	</div>
						</div>
						<br><br>
						<div class="review_commented">
							<div class="cnt"><h3>답변한 고객 리뷰 총 ${cnt2} 건</h3></div>
		                 	<!--테이블-->
		                 	<div class="table-container">
			                 	<table class="board-table">
									<thead>
										    <tr>
										        <th>구분</th>
										        <th>이용일자</th>
										        <th>평점</th>
										        <th>서비스 만족도</th>
										        <th>공간</th>
										        <th>청결도</th>
										        <th>재방문 의사</th>
										        <th>답변 보기</th>
										    </tr>
										</thead>
									<tbody>
										<c:forEach var="reviewCommented" items="${ReviewCommented}">
											<tr>
												<td>${reviewCommented.dogFacilities}</td>
												<td>${reviewCommented.reservationDate}</td>
												<td>${reviewCommented.rate}</td>
												<td>${reviewCommented.serviceBt}</td>
												<td>${reviewCommented.spaceBt}</td>
												<td>${reviewCommented.cleanBt}</td>
												<td>${reviewCommented.revisitBt}</td>
												<td>
													<form action="/thepet/admin/review/detail" method="GET">
														<input type="hidden" name="reservationId" value="${reviewNoComment.reviewId}">
														<input type="hidden" name="reservationId" value="${reviewNoComment.reservationId}">
														<input type="hidden" name="id" value="${reviewNoComment.memberId}">
														<button type="submit">답변 등록</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
		                 	</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../mainform/footer.jsp" />
	</div>
</body>
</html>
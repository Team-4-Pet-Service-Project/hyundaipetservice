<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/reset.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/container.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/register.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/registerResult.css?<%=System.currentTimeMillis()%>">

<title>The Hyundai : 회원 등록 완료</title>
</head>
<body class="container_body">
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<div class="main_info">
					<div class="join-complete-wrap">
						<div class="header-block">
							<h2>더현대닷컴 회원가입을 축하합니다.</h2>
							<h3>고객님께서는 더현대닷컴에 아이디 : <c:out value="${member.email}"/>로 가입해주셨습니다. 가입하신 아이디와 비밀번호로 안전하게 로그인
								하실 수 있습니다.</h3>
						</div>
						<div class="title-block">
							<h3> &#8251 이메일, 카카오톡, 페이스북, 구글 계정을 통해 간편가입시 개인정보(이메일, 아이디, 성명, 휴대폰 번호 등)을 간접 수집합니다.</h3>
							<h3> &#8251 고객님은 개인정보보호법 제 37조에 따라 개인정보 처리의 정지를 요구할 권리가 있습니다.</h3>
						</div>
						<div class="detail-block">
							<table class="table-simple">
								<colgroup>
									<col style="width: 100px;">
									<col style="width: auto;">
								</colgroup>
							</table>
						</div>
						<div class="btn-group mt40">
							<a href="/thepet/main" class="btn btn-lg btn-white"> <span>더 현대닷컴 메인으로 > </span>
							</a>
						</div>
					</div>
					<div class="bottom-line" style="border-bottom: 1px solid grey">
					
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../mainform/footer.jsp" />
	</div>
</body>
</html>
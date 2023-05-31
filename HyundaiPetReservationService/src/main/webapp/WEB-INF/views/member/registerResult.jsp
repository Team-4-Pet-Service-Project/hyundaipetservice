<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/thepet/resources/basic/css/reset.css">
<link rel="stylesheet"
	href="/thepet/resources/basic/css/container.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/register.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/registerResult.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/registerResult2.css?<%=System.currentTimeMillis()%>">
<title>The Hyundai 회원 등록 완료</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<div class="main_info">
					<div class="join-complete-wrap">
						<div class="xans-element- xans-member xans-member-joincomplete ">
							<div class="header-block">
								<h2>더현대닷컴 회원가입을 축하합니다.</h2>
								<p>고객님께서는 더현대닷컴에 아이디 - 로 가입해주셨습니다.
								   가입하신 아이디와 비밀번호로 안전하게 로그인 하실 수 있습니다.</p>
							</div>
							<div class="title-block">
								<h2>회원가입이 완료되었습니다.</h2>
							</div>
							<div class="detail-block">
								<table class="table-simple">
									<colgroup>
										<col style="width: 100px;">
										<col style="width: auto;">
									</colgroup>
									<tbody>
										<tr>
											<th>아이디</th>
											<td><span><c:out value="${member.email}" /></span></td>
										</tr>
										<tr>
											<th>이름</th>
											<td><span><c:out value="${member.name}" /></span></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="btn-group mt40">
								<a href="/" class="btn btn-lg btn-white"> <span>완료</span>
								</a>
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
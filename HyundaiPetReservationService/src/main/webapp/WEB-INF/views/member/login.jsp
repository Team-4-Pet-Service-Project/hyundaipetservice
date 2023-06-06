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
	href="/thepet/resources/member/css/login1.css?<%=System.currentTimeMillis()%>">
<link rel="stylesheet"
	href="/thepet/resources/member/css/login2.css?<%=System.currentTimeMillis()%>">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="/thepet/resources/member/js/login.js?<%=System.currentTimeMillis()%>"></script>
<title>The Hyundai : 로그인</title>
</head>
<body style="display: flex; justify-content: center;">
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<jsp:include page="../mainform/menubar.jsp" />
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<div class="main_info">
					<div id="wrap">
						<div id="container">
							<div id="contents">
								<div class="login-wrap page">
									<form id="loginForm">
										<div class="xans-element-xans-member xans-member-login">
											<div class="login">
												<div class="title">
													<h1>Log in</h1>
												</div>
												<fieldset>
													<div class="form-block">
														<label class="id ePlaceholderEach required" title="아이디*">
															<p class="form-title">아이디*</p> <input id="member_id"
															name="email" class="inputTypeText" placeholder="아이디*"
															value="" type="text" />
														</label>
														<div class="err-msg" id="idMsg" style="display: none;">아이디
															항목은 필수 입력값입니다.</div>
													</div>
													<div class="form-block">
														<label class="password ePlaceholderEach required"
															title="패스워드*">
															<p class="form-title">패스워드*</p> <input id="member_passwd"
															name="password" autocomplete="off" value=""
															type="password" placeholder="패스워드*" />
														</label>
														<div class="err-msg" id="pwMsg" style="display: none;">패스워드
															항목은 필수 입력값입니다.</div>
													</div>
													<button class="btnLogin btn btn-lg btn-dark btn-full"
														type="button">
														<span>로그인</span>
													</button>
													<div class="find-block">
														<ul>
															<li><a href="/member/findId">아이디찾기</a></li>
															<li><a href="/member/findPwd">비밀번호찾기</a></li>
														</ul>
													</div>
													<div class="err-msg" id="loginMsg" style="display: none;">아이디
														또는 비밀번호 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.</div>
													<div class="join-block ">
														<div class="util">
															<p>아직 회원이 아니신가요?</p>
															<p></p>
														</div>
														<a href="/thepet/member/register_bt"
															class="btn btn-lg btn-white btn-full"> <span>회원가입
																후 혜택받기</span>
														</a>
													</div>
												</fieldset>
											</div>
										</div>
									</form>
								</div>
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
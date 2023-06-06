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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="/thepet/resources/member/js/register.js?<%=System.currentTimeMillis()%>"></script>
<title>The Hyundai : 회원 등록</title>
</head>
<body class="container_body">
	<div class="container">
		<jsp:include page="../mainform/header.jsp">
			<jsp:param value="석진" name="userName" />
		</jsp:include>
		<jsp:include page="../mainform/menubar.jsp" />
		<div class="gap"></div>
		<main>
			<div class="main_container">
				<div class="join-wrap">
					<form id="joinForm" name="joinForm"
						action="/thepet/member/register" method="post">
						<div class="xans-element- xans-member xans-member-join">
							<div class="page-title">
								<h1>회원가입</h1>
							</div>
							<div class="title-block">
								<h2>기본정보</h2>
							</div>
							<div class="join-block">
								<fieldset>
									<div class="member-id-block">
										<div class="form-block">
											<label class="ePlaceholderEach required" title="아이디*">
												<p class="form-title">아이디*</p> <input id="member_id"
												name="email" class="inputTypeText" placeholder="아이디*"
												value="" type="text">
												<div class="err-msg-system" id="idMsg"></div>
											</label>
										</div>
										<button type="button" class="btn btn-sm btn-dark btn-id-check"
											id="id-check-btn" onclick="checkId();">
											<span>중복확인</span>
										</button>
									</div>
									<div>
										<div class="form-block">
											<label class="ePlaceholderEach required" title="비밀번호*">
												<p class="form-title">비밀번호*</p> <input id="passwd" name=""
												autocomplete="off" maxlength="16" value="" type="password"
												placeholder="비밀번호*">
												<div class="info-msg">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합,
													10자~16자)</div>
												<div class="err-msg" id="pwMsg">비밀번호 항목은 필수 입력값입니다.</div>
											</label>
										</div>

										<div class="form-block">
											<label class="ePlaceholderEach required" title="비밀번호 확인*">
												<p class="form-title">비밀번호 확인*</p> <input
												id="user_passwd_confirm" name="password" autocomplete="off"
												maxlength="16" value="" type="password"
												placeholder="비밀번호 확인*">
												<div class="err-msg" id="pwCheckMsg">비밀번호 확인 항목은 필수
													입력값입니다.</div>
											</label>
										</div>
									</div>

									<div>
										<div class="form-block">
											<label class="ePlaceholderEach required" title="이름*">
												<p class="form-title">이름*</p> <input id="name" name="name"
												placeholder="이름*" maxlength="30" value="" type="text">
												<div class="err-msg" id="nameMsg">이름 항목은 필수 입력값입니다.</div>
											</label>
										</div>
									</div>

									<div class=" ePlaceholderGroup" style="width: 100%;"
										title="휴대전화*" data-required="">
										<div class="form-block phone-block flex-column-2">
											<label class="ePlaceholder required">
												<p class="form-title active">휴대전화*</p>
												<div class="phone" id="phone">
													<input id="mobile1" name="mobile1" maxlength="4" value=""
														type="text" oninput="combinePhone()"> - <input
														id="mobile2" name="mobile2" maxlength="4" value=""
														type="text" oninput="combinePhone()"> - <input
														id="mobile3" name="mobile3" maxlength="4" value=""
														type="text" oninput="combinePhone()">
												</div>
											</label>
											<div class="err-msg-system" id="phoneMsg"></div>
											<button type="button"
												class="btn btn-sm btn-dark btn-id-check" id="id-check-btn"
												onclick="checkPhone();">
												<span>중복확인</span>
											</button>
										</div>
									</div>
									<div class="">
										<div class="form-block birthday-block">
											<div class="birthday">
												<!-- <div class="day">
													<label title="생년*" class="ePlaceholderEach">
														<p class="form-title">생년*</p> <input id="birth_year"
														name="birth_year" class="inputTypeText" placeholder="생년"
														maxlength="4" value="" type="text"
														oninput="combineBirth()">
													</label> <label title="월*" class="ePlaceholderEach">
														<p class="form-title">월*</p> <input id="birth_month"
														name="birth_month" class="inputTypeText" placeholder="월"
														maxlength="2" value="" type="text"
														oninput="combineBirth()">
													</label> <label title="일*" class="ePlaceholderEach">
														<p class="form-title">일*</p> <input id="birth_day"
														name="birth_day" class="inputTypeText" placeholder="일"
														maxlength="2" value="" type="text"
														oninput="combineBirth()">
													</label>
												</div> -->
												<div class="day">
													<p class="form-title active" style="margin-top: 23px;">생년월일*</p>
													<label title="생년*" class="ePlaceholderEach">
														<p class="form-title">생년*</p> <input id="birth"
														name="birth" class="inputTypeText" placeholder="생년"
														type="date" oninput="clickBirth()">
													</label>
												</div>
											</div>
											<div class="form-err-msg birthday-msg" id="birthMsg">생년월일
												항목은 필수 입력값입니다.</div>
										</div>
									</div>
									<div hidden class="hidden_form"
										style="border: 2px solid black;">
										<input hidden id="phoneInput" name="phone"> <input
											hidden id="birthInput" name="birth">
									</div>
								</fieldset>
							</div>
							<button type="button"
								class="js-join-btn btn btn-lg btn-dark btn-full"
								onclick="frmSubmit();">
								<span>가입하기</span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</main>
		<jsp:include page="../mainform/footer.jsp" />
	</div>
</body>
</html>
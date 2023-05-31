// 로그인 form submit
$(function() {
	$('.btnLogin').on('click', loginSubmit);
})

function loginSubmit(e) {
	e.preventDefault();
	
	var mem_id = $("#member_id").val();
	var member_passwd = $("#member_passwd").val();
		
	let flag = true;
	
	$("#idMsg").css("display", "none");
	$("#pwMsg").css("display", "none");
	$("#loginMsg").css("display", "none");

	
	console.log(mem_id);
	console.log(member_passwd);
	
	if (mem_id === '') {
		$("#idMsg").css("display", "block");
		$("#idMsg").css("color", "red");
		
		console.log("아이디 유효성 검사");
		
		flag = false;
	}
	if (member_passwd === '') {
		$("#pwMsg").css("display", "block");
		$("#pwMsg").css("color", "red");

		console.log("비밀번호 유효성 검사");
		
		flag = false;
	}
	if (flag === false){
		return;
	}

	jQuery.ajax({
		url  : "/thepet/member/login",
		type : "POST",
		data : $("#loginForm").serialize(),
		success : function(result){
			if(result){
				console.log(result);
			}
		},
		error : function(request, status, error){
			console.log(error);
			$("#loginMsg").css("display", "block");
			$("#loginMsg").css("color", "red");
		}
	})
}

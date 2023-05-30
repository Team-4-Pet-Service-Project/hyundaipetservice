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
	
	console.log(mem_id);
	console.log(member_passwd);
	
	
	if (mem_id === '') {
		$("#idMsg").css("display", "block");
		$("#idMsg").css("color", "red");
		$("#loginMsg").css("display", "none");

		flag = false;
		return;
	}
	if (member_passwd === '') {
		$("#pwMsg").css("display", "block");
		$("#pwMsg").css("color", "red");
		$("#pwMsg").css("display", "none");

		flag = false;
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

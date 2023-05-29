function loginSubmit() {
	var mem_id = $("member_id").val();
	var member_passwd = $("member_passwd").val();
	
	if (mem_id == '') {
		alert("아이디를 입력해주세요.");
		$("#member_id").focus();
		return;
	}
	if (member_passwd == '') {
		alert("비밀번호를 입력해주세요.");
		$("#member_passwd").focus();
		return;
	}else{
		$.ajax({
			url : '/thepet/member/login',
			data : {
				email : mem_id,
				password : member_passwd
			},
			type : 'post',
			success : function(result) {
				if(result != ){
					$("#idMsg").text("이미 사용중인 아이디입니다.");
					$("#idMsg").css("color", "red");
				}else{
				}
			},
			error : function(error){
				console.log(error);
			}
		});
	}
	$("#loginForm").submit();
}

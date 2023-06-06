$(document).ready(function() {
	var mobile1 = $("#mobile1");
	var mobile2 = $("#mobile2");
	var mobile3 = $("#mobile3");

	mobile1.on("input", combinePhone);
	mobile2.on("input", combinePhone);
	mobile3.on("input", combinePhone);

	/*var birth_year = $("#birth_year");
	var birth_month = $("#birth_month");
	var birth_day = $("#birth_day");

	birth_year.on("input", combineBirth);
	birth_month.on("input", combineBirth);
	birth_day.on("input", combineBirth);*/
});

function clickBirth() {
	var birth = $('#birth').val();
	console.log(birth);
	console.log(typeof(birth));
}

function combinePhone() {
	var mobile1 = $("#mobile1").val();
	var mobile2 = $("#mobile2").val();
	var mobile3 = $("#mobile3").val();
	var phoneNumber = mobile1 + mobile2 + mobile3;
	$("#phoneInput").val(phoneNumber);
}

function SendCombinePhone() {
	var mobile1 = $("#mobile1").val();
	var mobile2 = $("#mobile2").val();
	var mobile3 = $("#mobile3").val();
	var phoneNumber = mobile1 + mobile2 + mobile3;
	return phoneNumber;
}

/*function combineBirth() {
	var birth_year = $("f#birth_year").val();
	var birth_month = $("#birth_month").val();
	var birth_day = $("#birth_day").val();
	var birth = birth_year + "-" + birth_month + "-" + birth_day;

	$("#birthInput").val(birth);
}*/

function checkEmail(str) {
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if (!reg_email.test(str)) {
		return false;
	} else {
		return true;
	}
}

function checkPw(str) {
	var reg_pw = /^(?=.*[A-Za-z0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{10,16}$/;
	if (!reg_pw.test(str)) {
		return false;
	} else {
		return true;
	}
}

// 회원가입 form submit

var idPass = false;

function frmSubmit() {

	let pw = $("#passwd").val();
	let birth = $("#birth").val();

	if (idPass == false) {
		alert("아이디 중복 확인을 해주세요.");
		return;
	}

	if ($("#passwd").val() == '') {
		alert("비밀번호를 입력해주세요.");
		$("#passwd").focus();
		if (!checkPw(pw)) {
			alert("비밀번호 형식이 올바르지 않습니다.");
		}
		return;
	}
	if ($("#user_passwd_confirm").val() == '') {
		alert("비밀번호 확인 칸을 입력해주세요.");
		$("#user_passwd_confirm").focus();
		return;
	}
	var pwdCheck = $("#user_passwd_confirm");
	if ($("#passwd").val() != pwdCheck.val()) {
		alert("비밀번호가 일치하지 않습니다.");
		pwdCheck.focus();
		return;
	}
	if ($("#name").val() == '') {
		alert("이름을 입력해주세요.");
		$("#name").focus();
		return;
	}
	/*if ($("#birth_year").val() == '' || $("#birth_month").val() == ''
			|| $("#birth_day").val() == '') {
		alert("생년월일을 입력해주세요.");
		if ($("#birth_year").val() == '') {
			$("#birth_year").focus();
		}
		if ($("#birth_month").val() == '') {
			$("#birth_month").focus();
		}
		if ($("#birth_day").val() == '') {
			$("#birth_day").focus();
		}
		return;
	}*/
	
	if($('#birth').val() == ''){
		alert("생년 월일을 입력해주세요.");
	}
	
	console.log(birth);
	
	$("#joinForm").submit();
}

// 아이디 중복 확인
function checkId() {

	var mem_id = $("#member_id").val();

	console.log(mem_id);

	if (mem_id == '') {
		$("#idMsg").text("아이디를 입력해주세요.");
		$("#idMsg").css("color", "red");
	} else if (!checkEmail(mem_id)) {
		$("#idMsg").text("아이디 형식이 올바르지 않습니다.");
		$("#idMsg").css("color", "red");
	} else {
		$.ajax({
			url : '/thepet/member/checkId',
			data : {
				email : mem_id
			},
			type : 'post',
			success : function(result) {
				if (result != '') {
					$("#idMsg").text("이미 사용중인 아이디입니다.");
					$("#idMsg").css("color", "red");
					idPass = false;
				} else {
					$("#idMsg").text("사용 가능한 아이디입니다.");
					$("#idMsg").css("color", "green");
					idPass = true;
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
}

var idPass = false;

function checkPhone() {

	if ($("#mobile1").val() == '' || $("#mobile2").val() == ''
			|| $("#mobile3").val() == '') {

		$("#phoneMsg").text("전화번호를 입력해주세요.");
		$("#phoneMsg").css("color", "red");

		if ($("#mobile1").length + $("#mobile2").length + $("#mobile3").length == 11) {
			$("#phoneMsg").text("전화 번호 갯수가 부족합니다.");
			$("#phoneMsg").css("color", "red");
		}
		if ($("#mobile1").val() == '') {
			$("#mobile1").focus();
		}
		if ($("#mobile2").val() == '') {
			$("#mobile2").focus();
		}
		if ($("#mobile3").val() == '') {
			$("#mobile3").focus();
		}
		return;

	} else {
		jQuery.ajax({
			url : '/thepet/member/checkPhone',
			data : {
				phone : SendCombinePhone()
			},
			type : 'post',
			success : function(result) {
				if (result != '') {
					$("#phoneMsg").text("이미 사용중인 전화번호입니다.");
					$("#phoneMsg").css("color", "red");
					idPass = false;
				} else {
					$("#phoneMsg").text("사용 가능한 전화번호입니다.");
					$("#phoneMsg").css("color", "green");
					idPass = true;
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
}

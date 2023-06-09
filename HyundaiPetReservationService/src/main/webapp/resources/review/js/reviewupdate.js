document.addEventListener('DOMContentLoaded', function() {
    const stars = document.querySelectorAll('i'); // 선택자를 'i'로 변경
    const initial = document.getElementById("hidList").value; 
    const initialRate = parseInt(initial);

    for (let i = 0; i < initialRate; i++) {
    	stars[i].classList.add('full_star');
        stars[i].classList.remove('zero_star');
    }

  }); 


$(document).ready(function() {
    $('.rating i').on('click', function() {
      var selectedRate = $(this).index() + 1;

      $('.rating i').removeClass('full_star zero_star');
      $(this).prevAll().addBack().addClass('full_star');
      $(this).nextAll().addClass('zero_star');

      $('#selected-rate').val(selectedRate);
      console.log('Selected rate: ' + selectedRate);
    });
  });

 
 function validateForm(event) {
	    var form = document.getElementById("myForm");
	    var inputs = form.querySelectorAll('input[user_contents]:not([type="submit"])');
	    var isValid = true;

	    for (var i = 0; i < inputs.length; i++) {
	      var input = inputs[i];
	      if (input.hasAttribute('required') && input.value === '') {
	        isValid = false;
	        break;
	      }
	    }

	    if (!isValid) {
	      event.preventDefault(); // 폼 제출 방지
	      alert("모든 필수 필드를 작성해주세요.");
	    }
	  }
 
 //이미지 업로드 하는 부분
 $(document).ready(function() {
	 var maxFileCount = 1; // 최대 파일 개수 설정
	 sessionStorage.setItem("currentFileCount", 0); 
	 $("body").on("change", "input[type='file']", function(e){
		 
		 	if (sessionStorage.getItem("currentFileCount") >= maxFileCount) {
		      alert("최대 " + maxFileCount + "개까지만 파일을 추가할 수 있습니다.");
		      $("input[type='file']").val("");
		      return;
		    }
			let formData = new FormData();
			let fileInput = $("#uploadFile"); // 수정: id 선택자 사용
			let fileList = fileInput[0].files;
			let fileObj = fileList[0];
			
			formData.append("uploadFile", fileObj);
			$.ajax({
				url: '/thepet/image/uploadAjax',
		    	processData : false,
		    	contentType : false,
		    	data : formData,
		    	type : 'POST',
		    	dataType : 'json',
		    	success : function(result){
		    		console.log(result);
		    		showUploadImage(result);
		    		sessionStorage.setItem("currentFileCount", 1);
		    		currentImage = result.fileName;
		    	},
		    	error : function(result){
		    		alert("이미지 파일이 아닙니다.");
		    		$("input[type='file']").val("");
		    	}
			});
		 });
 });
 
 /* 이미지 출력 */
	function showUploadImage(uploadResultArr){
		/* 전달받은 데이터 검증 */
		if(!uploadResultArr || uploadResultArr.length == 0){return}
		
		let uploadResult = $("#uploadResult");
		let obj = uploadResultArr;
		let str = "";
		let fileCallPath = obj.uploadPath.replace(/\\/g, '/') + "/" + obj.fileName;
		str += "<div id='result_card'>";
		str += "<img src='/thepet/image/display?fileName=" + fileCallPath + "' style='width: 230px; height: 220px;'>";
		str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>X</div>";
		console.log(fileCallPath);
		str += `<input type="hidden" name="filename" value="${obj.fileName}">`;
		str += `<input type="hidden" name="uploadpath" value="${obj.uploadPath}">`;
		str += `<input type="hidden" name="uuid" value="${obj.uuid}">`;
		str += "</div>";
		uploadResult.append(str);
	}

	/* 이미지 삭제 버튼 동작 */
	$(document).ready(function(){
		$("body").on("click", "#uploadResult .imgDeleteBtn", function(e) {
		    deleteFile();
		  });
		
		$("body").on("click", "#result_card1 .imgDeleteBtn1", function(e) {
		    $("#uploadResult").remove();
		    let str = "";
		    str += "<div class='four_2'>"
		    str += "<input type='file' id='uploadFile' name='uploadFile'>";
		    str += "<div id='uploadResult'></div>"; // 수정된 부분
		    str += "</div>"
		    $("#uuid").remove();
		    $("#uploadpath").remove();
		    $(".four_3").append(str);
		  });
	});
	
	/* 파일 삭제 메서드 */
	function deleteFile(){
		let targetFile = $(".imgDeleteBtn").data("file");
		
		let targetDiv = $("#result_card");
		
		$.ajax({
			url: '/thepet/image/delete',
			data : {fileName : targetFile},
			dataType : 'text',
			type : 'POST',
			success : function(result){
				console.log(result);
				targetDiv.remove();
				sessionStorage.setItem("currentFileCount", 0);
				$("input[type='file']").val("");
				
			},
			error : function(result){
				console.log(result);
				
				alert("파일을 삭제하지 못하였습니다.")
			}
		});
	}




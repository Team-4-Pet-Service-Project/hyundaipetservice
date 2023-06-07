$(document).ready(function() {
      $('.rating i').on('click', function() {
        var selectedRate = parseInt($(this).data('rate'));
        if ($(this).hasClass('full_star')) {
          // 클릭한 별이 이미 칠해져 있는 경우
          $(this).nextAll().removeClass('full_star').addClass('zero_star');
          $(this).removeClass('full_star').addClass('zero_star');
          selectedRate = 0; // 선택된 평점 초기화
        } else {
          // 클릭한 별이 칠해져 있지 않은 경우
          $('.rating i').removeClass('full_star').addClass('zero_star');
          $(this).prevAll().removeClass('zero_star').addClass('full_star');
          $(this).removeClass('zero_star').addClass('full_star');
        }
        
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
	 /*var currentFileCount = 0; // 현재 파일 개수*/	 
	 sessionStorage.setItem("currentFileCount", 0); 
	 
	 $("input[type='file']").on("change", function(e){
		 	
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
		str += "<img src='/thepet/image/display?fileName=" + fileCallPath + "'style='width: 230px; height: 220px;'>";
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
		$("#uploadResult").on("click", ".imgDeleteBtn", function(e){
			deleteFile();
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





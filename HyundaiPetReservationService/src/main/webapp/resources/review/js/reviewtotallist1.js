    
$(document).ready(function() {
    $(".radio-input").on("click", function() {
    	const location = $("input[name=address]:checked").val();
    	const facilities = $("input[name=dogFacilities]:checked").val();
    	
    	const locationId = {
    	  '서울, 케어': 1,
    	  '서울, 놀이터': 2,
    	  '서울, 미용': 3,
    	  '서울, 스파': 43,
    	  '대구, 케어': 4,
    	  '대구, 놀이터': 5,
    	  '대구, 미용': 6,
    	  '대구, 스파': 41,
    	};

    	const locationAndFacilities = location + ', ' + facilities;
    	const locationIdValue = locationId[locationAndFacilities];
        $.ajax({
            url: "/thepet/review/totallistajax1", // AJAX 요청을 보낼 엔드포인트 URL을 입력하세요
            type: "GET",
            data: { locationId: locationIdValue },
            success: function(response) {
                // 요청이 성공한 경우에 대한 처리
                console.log("AJAX 요청 성공");
                console.log(response);
                // 응답 데이터를 가지고 추가 작업을 수행하세요.
                updateList(response,location,facilities);
                
            },
            error: function(xhr, status, error) {
                // 요청이 실패한 경우에 대한 처리
                console.log("AJAX 요청 실패");
                console.log("Error: " + error);
            }
        });
    });
    
});

function updateList(response,location,facilities){
	
	$('.spec').empty();
	$('.total').empty(); // 기존 내용을 제거
	$('.spec').text(location + " > " + facilities);
    var reviewList = response.review;
    var locationId = response.location;
    var pageMaker = response.pageMaker;
    for (var i = 0; i < reviewList.length; i++) {
    	var review = reviewList[i];
    	
    	var list1 = $('<div></div>').addClass('list1');
    	
    	list1.append($('<input>').attr('type', 'hidden').attr('name', 'id').val(review.id));
    	list1.append($('<input>').attr('type', 'hidden').attr('name', 'reservationId').val(review.reservationId));
    	//여기서 리뷰(class명 review)
    	var reviewlist = $('<div></div>').addClass('review');
    	
    	var review_1 = $('<div></div>').addClass('review_1');
    	var name = $('<div>[' + review.name + ']님</div>').addClass('name');
    	var rating = $('<div></div>').addClass('rating');
    
    	var rating_1 = $('<div>평점 : </div>').addClass('rating_1');
    	var starGroup = $('<div></div>').addClass('star-group');

    	starGroup.append($('<input>').attr('type', 'hidden').attr('id', 'hidList').val(review.rate));
    	starGroup.append($('<i>').addClass('far fa-star').attr('data-rate', '1'));
    	starGroup.append($('<i>').addClass('far fa-star').attr('data-rate', '2'));
    	starGroup.append($('<i>').addClass('far fa-star').attr('data-rate', '3'));
    	starGroup.append($('<i>').addClass('far fa-star').attr('data-rate', '4'));
    	starGroup.append($('<i>').addClass('far fa-star').attr('data-rate', '5'));
    	
    	var date = $('<div>작성날짜 : ' + review.createdTime + '</div>').addClass('date');
		
    	var review_2 = $('<div></div>').addClass('review_2');
    	var image = $('<div></div>').addClass('image');
    	if (review.uuid === null) {
    	    var img2 = $('<img>').attr('src', '/thepet/resources/review/img/no.png');
    	    image.append(img2);
    	} else {
    		var fileName = encodeURIComponent(review.uploadpath.replace(/\\/g, '/') + '/' + review.filename);
    	    var img2 = $('<img>').attr('src', '/thepet/image/display?fileName=' + fileName)
    	                      .css({'width': '210px', 'height': '220px'});
    	    image.append(img2);
    	}
    	var contents = $('<div>' + review.userContents+'</div>').addClass('contents').css({
    		'width' : '700px'
    	});
    	
    	var admin = $('<div></div>').addClass('admin');
    	var admin_1 = $('<div>관리자 답글</div>').addClass('admin_1').css({
    		'margin-right' : '50px',
	});
    	
    	if (review.adminContents === null) {
    		var admin_2 = $('<div>관리자가 댓글 안달았습니다.</div>').addClass('admin_2');
    	} else {
    		var admin_2 = $('<div>' +  review.adminContents+ '</div>').addClass('admin_2');
    	}
    	
    	
    	rating.append(rating_1);
    	rating.append(starGroup);
    	rating.append(date);
    	
    	review_1.append(name);
    	review_1.append(rating);
    	
    	review_2.append(image);
    	review_2.append(contents);
    	
    	admin.append(admin_1);
    	admin.append(admin_2);
    	
    	reviewlist.append(review_1);
    	reviewlist.append(review_2);
    	reviewlist.append(admin);
    	reviewlist.append(pageInfoWrap);
    	list1.append(reviewlist);
    	
    	const starGroupElement = list1.find('.star-group');
        const initialRate = parseInt(starGroupElement.find('#hidList').val());
        const stars = starGroupElement.find('i');
        for (let j = 0; j < initialRate; j++) {
            stars[j].classList.add('fas'); // fas 클래스 추가
            stars[j].classList.remove('far'); // far 클래스 제거
        }
    	 $('.total').append(list1);
    	 
    }
 // 페이지 정보 영역 생성
    var pageInfoWrap = $('<div>').addClass('pageInfo_wrap');
    var pageInfoArea = $('<div>').addClass('pageInfo_area');
    var pageInfoList = $('<ul>').addClass('pageInfo');
    
    // 이전페이지 버튼
    if (pageMaker.prev) {
        var previousBtn = $('<li>').addClass('pageInfo_btn previous');
        var previousLink = $('<a>').attr('href', '/thepet/review/totallist1?locationId=' + locationId+ '&pageNum=' + pageMaker.startPage - 1).text('Previous');
        previousBtn.append(previousLink);
        pageInfoList.append(previousBtn);
    }
    
    // 각 번호 페이지 버튼
    for (var num = pageMaker.startPage; num <= pageMaker.endPage; num++) {
        var pageInfoBtn = $('<li>').addClass('pageInfo_btn');
        var pageInfoLink = $('<a>').attr('href', '/thepet/review/totallist1?locationId=' + locationId+ '&pageNum=' + num).text(num);
        pageInfoBtn.append(pageInfoLink);
        pageInfoList.append(pageInfoBtn);
    }
    
    // 다음페이지 버튼
    if (pageMaker.next) {
        var nextBtn = $('<li>').addClass('pageInfo_btn next');
        var nextLink = $('<a>').attr('href', '/thepet/review/totallist1?locationId=' + locationId+ '&pageNum=' + pageMaker.endPage + 1).text('Next');
        nextBtn.append(nextLink);
        pageInfoList.append(nextBtn);
    }
    
    pageInfoArea.append(pageInfoList);
    pageInfoWrap.append(pageInfoArea);
    $('.total').append(pageInfoWrap);
}



$(document).on("click", ".list1", function() {
    // 클릭한 .list1 요소 내부에서 input 값을 가져오기
    var id = $(this).find("input[name='id']").val();
    var reservationId = $(this).find("input[name='reservationId']").val();
 // 페이지 리다이렉트
    window.location.href = "/thepet/review/detail1?id=" + id + "&reservationId=" + reservationId;
});

function handleClick(element) {
	  var buttons = document.querySelectorAll('.pageInfo_btn a');

	  buttons.forEach(function(btn) {
	    btn.classList.remove('active');
	  });

	  element.classList.add('active');

	  // 상태 저장
	  sessionStorage.setItem('activeButton', element.getAttribute('href'));
	}

	// 페이지 로드 시 상태 복원
	window.addEventListener('load', function() {
	  var activeButton = sessionStorage.getItem('activeButton');

	  if (activeButton) {
	    var buttonToActivate = document.querySelector('.pageInfo_btn a[href="' + activeButton + '"]');
	    if (buttonToActivate) {
	      buttonToActivate.classList.add('active');
	    }
	  }
	});





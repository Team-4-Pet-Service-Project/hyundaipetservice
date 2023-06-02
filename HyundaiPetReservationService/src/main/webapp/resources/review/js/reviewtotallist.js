$(document).ready(function() {
    $(".radio-input").on("click", function() {
    	const location = $("input[name=address]:checked").val();
    	const facilities = $("input[name=dogFacilities]:checked").val();

    	const locationId = {
    	  '서울, 케어': 1,
    	  '서울, 놀이터': 2,
    	  '서울, 미용': 3,
    	  '서울, 스파': 43,
    	  '서울, 미용+스파': 44,
    	  '대구, 케어': 4,
    	  '대구, 놀이터': 5,
    	  '대구, 미용': 6,
    	  '대구, 스파': 41,
    	  '대구, 미용+스파': 42,
    	};

    	const locationAndFacilities = location + ', ' + facilities;
    	const locationIdValue = locationId[locationAndFacilities];

    	console.log(locationIdValue);

        $.ajax({
            url: "/thepet/review/totallistajax", // AJAX 요청을 보낼 엔드포인트 URL을 입력하세요
            type: "GET",
            data: { locationId: locationIdValue },
            success: function(response) {
                // 요청이 성공한 경우에 대한 처리
                console.log("AJAX 요청 성공");
                console.log(response);
                // 응답 데이터를 가지고 추가 작업을 수행하세요.
            },
            error: function(xhr, status, error) {
                // 요청이 실패한 경우에 대한 처리
                console.log("AJAX 요청 실패");
                console.log("Error: " + error);
            }
        });
    });
});



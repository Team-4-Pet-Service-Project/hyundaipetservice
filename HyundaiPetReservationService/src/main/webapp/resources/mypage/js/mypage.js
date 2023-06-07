$(document).ready(function() {
    var buttonId = ''; // 버튼 ID 값을 저장할 변수
    var loginId = '';
    $('#theadA').show();
    $('#theadB').hide();
    loginId = document.getElementById("loginId").value;
    // 초기에 첫 번째 버튼을 활성화 상태로 설정
    $('#buttonA').addClass('active'); // 버튼 A를 활성화 상태로 표시

    $('#buttonA').click(function() {
        buttonId = $(this).attr('id'); // 버튼 A의 ID 값을 가져와서 buttonId에 할당
        
        $(this).addClass('active'); // 버튼 A를 활성화 상태로 표시
        $('#buttonB').removeClass('active'); // 버튼 B의 활성화 상태 제거
        $('#theadA').show();
        $('#theadB').hide();
        
        reservationList();
    });

    $('#buttonB').click(function() {
        buttonId = $(this).attr('id'); // 버튼 B의 ID 값을 가져와서 buttonId에 할당
        $(this).addClass('active'); // 버튼 B를 활성화 상태로 표시
        $('#buttonA').removeClass('active'); // 버튼 A의 활성화 상태 제거
        // ... AJAX 요청 등 버튼 B에 대한 추가 동작 수행
        $('#theadB').show();
        $('#theadA').hide();
        
        prevReservationList();
 
    });
});

function reservationList () {
    let loginId = document.getElementById("loginId").value;
	$.ajax({
		type:'POST',
		url: '/thepet/mypage/getReservationList',
		data : {
			loginId :loginId
		},
		success : function (data) {
			var cnt = data.length;
		    //Object.values(response)[1]
		    // 테이블 내용을 변경하는 코드 작성
		    // 예시: 테이블의 tbody 요소를 선택하여 내용을 업데이트
		    var tbody = $('.board-table tbody');
		    tbody.empty(); // 기존 내용을 제거
		    
		    var cntt = $('.cntt');
		    cntt.empty();
		    cntt.html('총 ' +  cnt + '건');
		    
		    for (let i = 0; i < cnt; i++) {
		    	var reserv = data[i];
		        var reservationDate = new Date(reserv.reservationDate);
		        var year = reservationDate.getFullYear();
		        var month = reservationDate.getMonth() + 1;
		        var day = reservationDate.getDate();
		        var formattedDate = year + '-' + (month < 10 ? '0' + month : month) + '-' + (day < 10 ? '0' + day : day);
		        const cn1 = reserv.price.toLocaleString('ko-KR');
		        
		        var row = $('<tr></tr>');
	            row.append('<td>' + reserv.address + ' ' + reserv.addressDetail + '</td>');
	            row.append('<td>' + reserv.dogFacilities + '</td>');
	            row.append('<td>' + reserv.customerCount + '</td>');
	            row.append('<td>' + reserv['dogName'] + '</td>');
	            row.append('<td>' + formattedDate + '  '+ reserv.reservationStartTime+' ~ ' + reserv.reservationEndTime +'</td>');
	            row.append('<td>' + cn1 + '원' + '</td>');
	            row.append('<td><form action="/thepet/reservation/detail" method="GET"><input type="hidden" name="id" value="' + reserv.id + '"><input type="hidden" name="reservationId" value="' + reserv.reservationId + '"><button type="submit">예약상세</button></form></td>');
	            tbody.append(row);
		    }
		}
		
	})
}

function prevReservationList () {
    let loginId = document.getElementById("loginId").value;
	$.ajax({
		type:'POST',
		url: '/thepet/mypage/getPrevReservationList',
		data : {
			loginId :loginId
		},
		success : function (data) {
			
			var cnt = data.length;
		    
		    //Object.values(response)[1]
		    // 테이블 내용을 변경하는 코드 작성
		    // 예시: 테이블의 tbody 요소를 선택하여 내용을 업데이트
		    var tbody = $('.board-table tbody');
		    tbody.empty(); // 기존 내용을 제거
		    
		    var cntt = $('.cntt');
		    cntt.empty();
		    cntt.html('총 ' +  cnt + '건');
		    
		    for (let i = 0; i < cnt; i++) {
		    	 var reserv = data[i];
		         var reservationDate = new Date(reserv.reservationDate);
		         var year = reservationDate.getFullYear();
		         var month = reservationDate.getMonth() + 1;
		         var day = reservationDate.getDate();
		         var formattedDate = year + '-' + (month < 10 ? '0' + month : month) + '-' + (day < 10 ? '0' + day : day);
		         const cn1 = reserv.price.toLocaleString('ko-KR');
		         
		         let row = $('<tr></tr>');
	             row.append('<td>' + reserv.address + ' ' + reserv.addressDetail + '</td>');
	             row.append('<td>' + reserv['dogFacilities'] + '</td>');
	             row.append('<td>' + reserv['customerCount'] + '</td>');
	             row.append('<td>' + reserv['dogName'] + '</td>');
	             row.append('<td>' + formattedDate + '  '+ reserv.reservationStartTime+' ~ ' + reserv.reservationEndTime + '</td>');
	             row.append('<td>' + cn1 + '원' + '</td>');
	             var buttonCell = $('<td></td>');
	            
	             if (reserv.reviewId !== null) {
                	 buttonCell.append('<form action="/thepet/review/detail1" method="GET"><input type="hidden" name="dogId" value="' + reserv.dogId + '"><input type="hidden" name="id" value="' + reserv.id + '"><input type="hidden" name="reservationId" value="' + reserv.reservationId + '"><button type="submit">리뷰확인</button></form>');
                 } else {
                	 buttonCell.append('<form action="/thepet/review/write" method="GET"><input type="hidden" name="reservationId" value="' + reserv.reservationId + '"><input type="hidden" name="dogFacilities" value="' + reserv.dogFacilities + '"><input type="hidden" name="reservationDate" value="' + formattedDate + '"><input type="hidden" name="reservationStartTime" value="' + reserv.reservationStartTime + '"><input type="hidden" name="reservationEndTime" value="' + reserv.reservationEndTime + '"><button type="submit">리뷰작성</button></form>');
                 }
                 row.append(buttonCell);
		         
                 tbody.append(row);
		    }
		    
		}
		
	})
}



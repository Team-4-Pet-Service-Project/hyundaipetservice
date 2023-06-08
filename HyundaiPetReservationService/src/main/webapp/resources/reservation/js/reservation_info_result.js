$(function() {
	$('.reservation_reset_button').on('click', reservationInfoReset);
	$('.do_reservation_button').on('click', addAllReservation);
})

function reservationInfoReset() {
	$('.result_button_box').hide();
	$('.information_container').empty();
	$('.information_detail_container').empty();
	$('.total_price_box').empty();
	$('.total_price_box').css('display', 'none');
	sessionStorage.clear();
}

function addAllReservation() {
	const loactionMap = {
		'케어' : 1,
		'놀이터' : 2,
		'미용' : 3,
		'스파' : 4,
		'미용+스파' : 5
	}
	
	const categoryMap = {
			"케어":"care",
			"놀이터":"playground",
			"미용":"beauty"
	}
	
	const branchMap = {
			"서울":"seoul",
			"대구":"daegu"
	}
	
	const selectCategory = categoryMap[$('.select_category p').text()];
    const selectBranch = branchMap[$('.radio-input:checked').val()];
	
	let resDogInfo = $('.dog_info_table .dog_table_row');
	
	let data = {
			'category' : `reservation_times_${selectCategory}_${selectBranch}`,
			'reservationList' : []
	};
	for ( let i = 0; i < resDogInfo.length; i++ ) {
		
		const [reservationStartTime, reservationEndTime] = resDogInfo.eq(i).children('td:nth-child(6)').text().split('~');
		data.reservationList.push({
			'reservationDate' : resDogInfo.eq(i).children('td:nth-child(5)').text(),
			'reservationStartTime' : reservationStartTime,
			'reservationEndTime' : reservationEndTime,
			'price' : Number($('.total_price').text().slice(0, -1)),
			'customerCount' : Number($('.customer_count').text()),
			'memberId' : Number(resDogInfo.eq(i).children('td:nth-child(10)').text()),
			'dogId' : Number(resDogInfo.eq(i).children('td:nth-child(9)').text()),
			'locationId' : loactionMap[resDogInfo.eq(i).children('td:nth-child(8)').text()],
			'reservationId' : Number(resDogInfo.eq(i).children('td:nth-child(11)').text())
		});
	}
	
	$.ajax({
		type:'POST',
		url:"/thepet/calender/reservationResult",
		contentType: 'application/json',
		data: JSON.stringify(data),
		success : function(data) {
			alert('예약이 완료되었습니다.');
			window.location.href = '/thepet/mypage/reservlist';
		}
	})
}
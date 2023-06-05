$(function () {
	sessionStorage.clear();
	
	sessionStorage.setItem("reservationRemain", JSON.stringify({}));
	$('.radio-input').on('click', curMonth);
	$('.add_button_box').hide();
	$('.result_button_box').hide();
});

function curMonth() {
	
	$('.calender_container').show();
	
	$('.main_date').empty();
	const date = new Date();
    
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
    
    
    const viewYear = date.getFullYear();
    const viewMonth = date.getMonth();
    const viewDate = date.getDate();
    
    const thisLast = new Date(viewYear, viewMonth + 1, 0);
    
    
    const oneDate = {
    	'category': `reservation_times_${selectCategory}_${selectBranch}`, 
    	'startDate':`${viewYear}/${viewMonth+1}/${viewDate}`,
    	'endDate' : `${thisLast.getFullYear()}/${thisLast.getMonth()+1}/${thisLast.getDate()}`
    }
    
    $.ajax({
    	type:'POST',
		url: "/thepet/calender/oneMonth",
		data : oneDate,
		dataType:'json',
		success : function(data) {
			const n = data.length / 5;
			let existDetail = [];
			
			for (let i = 0; i < n; i++) {
				existDetail.push(data.slice(i*5, (i+1) * 5))
			}
			
			$(".ym").text(`${viewYear}.${viewMonth+1}`);
		    $(".left").removeClass('active_arrow').addClass('disable_arrow');
		    
		    const prevLast = new Date(viewYear, viewMonth, 0);

		    const PLDay = prevLast.getDay();

		    const TLDate = thisLast.getDate();

		    const emptyDate = new Array((PLDay + 1) % 7);
		    const prevDate = new Array(viewDate-1);

		    const thisDates = [...Array(TLDate + 1).keys()].slice(1);

		    const result = [...emptyDate, ...thisDates];
		    existDetail = [...emptyDate, ...prevDate, ...existDetail];
		    
		    for (let i = 0; i < result.length; i++) {
		        const date = result[i];
		        let classDateName = "";
		        let flag = true;
		        
		        let total = 0
		        if (existDetail[i] !== undefined) {		        	
		        	for (let j = 0; j < 5; j++) {
		        		total += existDetail[i][j].remainCount;
		        	}
		        	if (total === 0) {
		        		classDateName = "no_reservation";
		        	}
		        }
		        
		        
		        if (date < viewDate) {
		            classDateName = "prev_date";
		        }
		        else if(classDateName !== 'no_reservation' && date >= viewDate) {
		            classDateName = "cur_date";
		        }
		        
		        let newDate = $("<div></div>").text(date)
		        
		        if (classDateName === 'cur_date' || classDateName === 'no_reservation') {
		        	newDate.on('click', dateClickEvent);
		        }
		        
		        if (i % 7 === 0) {
		            $(".main_date").append(newDate.addClass(`${classDateName} date sun`));
		        }
		        else if (i % 7 === 6) {
		            $(".main_date").append(newDate.addClass(`${classDateName} date sat`));
		        }
		        else {
		            $(".main_date").append(newDate.addClass(`${classDateName} date`));
		        }
		    }
		},
		error : function() {
			
		}
    })
}

function nextMonth() {
	
    const date = new Date();
    
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

    const viewMonth = date.getMonth();

    const curMonth = $('.ym').text();
    const [year, month] = curMonth.split('.');
    let nextYear = 0;
    let nextMonth = 0;
    if (Number(month) === 12) {
        nextYear = Number(year) + 1;
        nextMonth = 1;
    }
    else {
        nextYear = Number(year);
        nextMonth = Number(month) + 1;        
    }
    const thisLast = new Date(nextYear, nextMonth, 0);
    
    const oneDate = {
    	'category': `reservation_times_${selectCategory}_${selectBranch}`, 
        'startDate':`${nextYear}/${nextMonth}/${1}`,
        'endDate' : `${thisLast.getFullYear()}/${thisLast.getMonth()+1}/${thisLast.getDate()}`
    }
    
    $.ajax({
    	type:'POST',
		url: "/thepet/calender/oneMonth",
		data : oneDate,
		dataType:'json',
		success : function(data) {
			$('.main_date').empty();
			const n = data.length / 5;
			let existDetail = [];
			
			for (let i = 0; i < n; i++) {
				existDetail.push(data.slice(i*5, (i+1) * 5))
			}
			
			$(".ym").text(`${nextYear}.${nextMonth}`);
		    
		    
		    if (new Date() < thisLast) {
		        $(".left").removeClass('disable_arrow').addClass('active_arrow');
		    }
		    
		    const prevLast = new Date(year, month, 0);

		    const PLDay = prevLast.getDay();

		    const TLDate = thisLast.getDate();

		    const emptyDate = new Array((PLDay + 1) % 7);

		    const thisDates = [...Array(TLDate + 1).keys()].slice(1);

		    const result = [...emptyDate, ...thisDates];
		    existDetail = [...emptyDate, ...existDetail];

		    for (let i = 0; i < result.length; i++) {
		        const date = result[i];
		        let classDateName = "";
		        
		        let total = 0
		        if (existDetail[i] !== undefined) {		        	
		        	for (let j = 0; j < 5; j++) {
		        		total += existDetail[i][j].remainCount;
		        	}
		        	if (total === 0) {
		        		classDateName = "no_reservation";
		        	}
		        	else {
		        		classDateName = "cur_date";
		        	}
		        }
		        
		        let newDate = $("<div></div>").text(date);
		        newDate.on('click', dateClickEvent);
		        
		        if (i % 7 === 0) {
		            $('.main_date').append(newDate.addClass(`${classDateName} date sun`));
		        }
		        else if (i % 7 === 6) {
		            $('.main_date').append(newDate.addClass(`${classDateName} date sat`));
		        }
		        else {
		            $('.main_date').append(newDate.addClass(`${classDateName} date`));
		        }
		    }
		    
		},
		error : function() {
			
		}
    })
}

function prevMonth() {
	
	const categoryMap = {
		"케어":"care",
		"놀이터":"playground",
		"미용":"beauty"
	}
	
	const a = {
		'서울' : 1,
		'대구' : 2
	}
	
	const branchMap = {
		"서울":"seoul",
		"대구":"daegu"
	}
	
    const selectCategory = categoryMap[$('.select_category p').text()];
    const selectBranch = branchMap[$('.radio-input:checked').val()];
	
    const date = new Date();
    const viewYear = date.getFullYear();
    const viewMonth = date.getMonth();
    const viewDate = date.getDate();
    
    const curMonth = $('.ym').text();
    const [year, month] = curMonth.split('.');
    let prevYear = 0;
    let prevMonth = 0;
    let prevDate = 0;
    if (Number(month) === 1) {
        prevYear = Number(year) - 1;
        prevMonth = 12;
    }
    else {
        prevYear = Number(year);
        prevMonth = Number(month) - 1;
    }
    const thisLast = new Date(prevYear, prevMonth, 0);
    
    
    if (new Date().getMonth()+1 === prevMonth) {
    	prevDate = viewDate;
    }
    else {
    	prevDate = 1;
    }
    
    const oneDate = {
    	'category': `reservation_times_${selectCategory}_${selectBranch}`,
        'startDate':`${prevYear}/${prevMonth}/${prevDate}`,
        'endDate' : `${thisLast.getFullYear()}/${thisLast.getMonth()+1}/${thisLast.getDate()}`
    }
        
    
    $.ajax({
    	type:'POST',
		url: "/thepet/calender/oneMonth",
		data : oneDate,
		dataType:'json',
		success : function(data) {
			const n = data.length / 5;
			let existDetail = [];
			
			for (let i = 0; i < n; i++) {
				existDetail.push(data.slice(i*5, (i+1) * 5))
			}
			$('.main_date').empty();
		    $(".ym").text(`${prevYear}.${prevMonth}`);
		    
		    
		    
		    const prevLast = new Date(prevYear, prevMonth - 1, 0);

		    const PLDay = prevLast.getDay();

		    const TLDate = thisLast.getDate();

		    const emptyDate = new Array((PLDay + 1) % 7);
		    
		    if (new Date().getMonth()+1 === prevMonth) {
		    	$(".left").removeClass('active_arrow').addClass('disable_arrow');
		    	const prevDate = new Array(viewDate-1);
		    	existDetail = [...emptyDate, ...prevDate, ...existDetail];
		    }
		    else {
		    	existDetail = [...emptyDate, ...existDetail];
		    }
		    
		    const thisDates = [...Array(TLDate + 1).keys()].slice(1);

		    const result = [...emptyDate, ...thisDates];
		    
		    
		    for (let i = 0; i < result.length; i++) {
		        const date = result[i];
		        let classDateName = "";
		        let flag = true;
		        
		        let total = 0
		        if (existDetail[i] !== undefined) {		        	
		        	for (let j = 0; j < 5; j++) {
		        		total += existDetail[i][j].remainCount;
		        	}
		        	if (total === 0) {
		        		classDateName = "no_reservation";
		        	}
		        }
		        
		        if (viewYear === prevYear && prevMonth === viewMonth+1) {
		        	if (date < viewDate && classDateName !== "no_reservation") {
		                classDateName = "prev_date";
		            }
		            else if(date >= viewDate && classDateName !== "no_reservation") {
		                classDateName = "cur_date";
		            }
		        }
		        else if (viewYear !== prevYear || prevMonth !== viewMonth+1 && classDateName !== "no_reservation"){
		        	classDateName = "cur_date";
		        }
		        
		        let newDate = $("<div></div>").text(date)
		        
		        if (classDateName === 'cur_date' || classDateName === 'no_reservation') {
		        	newDate.on('click', dateClickEvent);
		        }
		        
		        
		        
		        if (i % 7 === 0) {
		            $('.main_date').append(newDate.addClass(`${classDateName} date sun`));
		        }
		        else if (i % 7 === 6) {
		            $('.main_date').append(newDate.addClass(`${classDateName} date sat`));
		        }
		        else {
		            $('.main_date').append(newDate.addClass(`${classDateName} date`));
		        }
		    }
		},
		error : function() {
			
		}
    })
}

function dateClickEvent(e) {
	$('.add_button_box').show();
	$('.checked_date').removeClass('checked_date');
	e.target.className += ' checked_date';
	
	const [year, month] = $('.ym').text().split('.');
	const d = $('.checked_date').text();
	
	$('.calender_detail_content').remove();
	
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
	
	$.ajax({
		type:'POST',
		url: "/thepet/calender/detail",
		data : {
			'category': `reservation_times_${selectCategory}_${selectBranch}`,
			'date' : `${year}/${month}/${d}`
		},
		dataType:'json',
		success : function (data) {
			let detailTable = $(`
					<table class="calender_detail_content">
						<tr class="detail_table_h">
							<th class="detail_table_cell">선택</th>
							<th class="detail_table_cell">시간</th>
							<th class="detail_table_cell">비고</th>
							<th class="detail_table_cell">남은 자리</th>
						</tr>
					</table>
			`)
			
			data.map(detail => {
				detailTable.append(`
					<tr class="detail_table_row">
						<td class="detail_table_cell" name="id" hidden>${detail.id}</td>
						<td class="detail_table_cell">${detail.remainCount > 0 ? '<input type="radio" name="reservation_time" class="radio_set"/>' : ''}</td>
						<td class="detail_table_cell" name="time">${detail.startTime}~${detail.endTime}</td>
						<td class="detail_table_cell ${detail.remainCount > 0 ? 'reservation_able' : 'reservation_disable'}">${detail.remainCount> 0 ? '예약가능':'예약불가'}</td>
						<td class="detail_table_cell" name="remain_count">${detail.remainCount}</td>
					</tr>
				`)
			})
			
			$('.calender_detail_container').append(detailTable);
			
		},
		error : function (data) {
			
		}
	})
}

function addReservation() {
	let selectDogInfo = $('.mypet_radio:checked');
	let selectDateTime = $('.radio_set:checked');
	let branchOffice = $('.radio-input:checked').val();
	let category = $('.select_category p').text();
	if (selectDogInfo.length === 0) {
		alert("예약할 강아지를 선택해주세요🙏");
		return;
	}
	
	if (selectDateTime.length === 0) {
		alert("예약 가능한 날짜와 시간을 선택해주세요🙏");
		return;
	}
	
	selectDogInfo = selectDogInfo.closest('tr');
	const name = selectDogInfo.children('td[name="name"]').text();
	const age = selectDogInfo.children('td[name="age"]').text();
	const breed = selectDogInfo.children('td[name="breed"]').text();
	const dogSize = selectDogInfo.children('td[name="dogSize"]').text();
	const dogId = selectDogInfo.children('td[name="dogId"]').text();
	const memberId = selectDogInfo.children('td[name="memberId"]').text();
	
	
	const [year, month] = $('.ym').text().split('.');
	const date = $('.checked_date').text();
	
	const time = selectDateTime.closest('tr').children('td[name="time"]').text();
	const timeId = selectDateTime.closest('tr').children('td[name="id"]').text();
	const remainCount = Number(selectDateTime.closest('tr').children('td[name="remain_count"]').text());
	
	let addPersonnel = "";
	
	if (category === "케어"){
		addPersonnel = `<td class="row_content common_cell customer_count">1</td>`;
	}
	else if (category === "놀이터") {
		addPersonnel = `<td class="row_content common_cell customer_count">${$(".customer_counter_input").val()}</td>`;
	}
	else if (category === "미용") {
		
	}
	
	if (sessionStorage.getItem("member") === null) {
		$.ajax({
			type:"GET",
			url:"/thepet/reservation/getMember",
			dataType:'json',
			async:false,
			success : function(data) {
				sessionStorage.setItem("member", data);
				$('.information_container').append(`
						<h1 class="info_h1">
						예약정보
						</h1>
						<h2 class="info_h2">
						예약자 정보
						</h2>
						<table class="member_info_table">
						<tr class="info_table_row">
						<td class="row_head common_cell">이름</td>
						<td class="row_content common_cell">${data.name}</td>
						</tr>
						<tr class="info_table_row">
						<td class="row_head common_cell">연락처</td>
						<td class="row_content common_cell">${data.phone}</td>
						</tr>
						<tr class="info_table_row">
						<td class="row_head common_cell">이메일주소</td>
						<td class="row_content common_cell">${data.email}</td>
						</tr>
						<tr class="info_table_row">
						<td class="row_head common_cell">추가 인원</td>
						${addPersonnel}
						</tr>
						</table>
				`)
			}
		})
	}
	
	let remainCountMap = JSON.parse(sessionStorage.getItem("reservationRemain"));
	if (timeId in remainCountMap) {
		if (remainCountMap[timeId] === 0) {
			alert('예약이 남아 있는 자리수를 초과했습니다. 죄송합니다.');
			return;
		}
		remainCountMap[timeId] = remainCount - 1;
	}
	else {
		remainCountMap[timeId] = remainCount - 1;
	}
	sessionStorage.setItem("reservationRemain", JSON.stringify(remainCountMap));
	
	if ($('.dog_info_table').length === 0) {
		$('.information_container').append(`
			<h2 class="info_h2 dog_info_h2">
				예약견 정보
			</h2>
			<div class="dog_info_table_box">
				<table class="dog_info_table">
					<tr class="dog_table_head">
						<td class="dog_table_common_cell">이름</td>
						<td class="dog_table_common_cell">나이</td>
						<td class="dog_table_common_cell">견종</td>
						<td class="dog_table_common_cell">크기</td>
					</tr>
					<tr class="dog_table_row">
						<td class="dog_table_common_cell">${name}</td>
						<td class="dog_table_common_cell">${age}</td>
						<td class="dog_table_common_cell">${breed}</td>
						<td class="dog_table_common_cell">${dogSize}</td>
						<td class="dog_table_common_cell" hidden>${year}/${month}/${date}</td>
						<td class="dog_table_common_cell" hidden>${time}</td>
						<td class="dog_table_common_cell" hidden>${branchOffice}</td>
						<td class="dog_table_common_cell" hidden>${category}</td>
						<td class="dog_table_common_cell" hidden>${dogId}</td>
						<td class="dog_table_common_cell" hidden>${memberId}</td>
						<td class="dog_table_common_cell" hidden>${timeId}</td>
					</tr>
				</table>
			</div>
		`)
		getServicePrice(dogSize, category);
	}
	else {
		let resDogInfo = $('.dog_info_table .dog_table_row');
		
		
		for (let i = 0; i < resDogInfo.length; i++) {
			const prevName = resDogInfo.eq(i).children('td:nth-child(1)').text();
			const prevDate = resDogInfo.eq(i).children('td:nth-child(5)').text();
			const prevTime = resDogInfo.eq(i).children('td:nth-child(6)').text();
			const prevBranch = resDogInfo.eq(i).children('td:nth-child(7)').text();

			if (prevName === name && prevDate === `${year}/${month}/${date}` && prevTime === time && prevBranch === branchOffice) {
				alert('이미 추가한 예약입니다.');
				return;
			}
		}
		
		$('.dog_info_table').append(`
			<tr class="dog_table_row">
				<td class="dog_table_common_cell">${name}</td>
				<td class="dog_table_common_cell">${age}</td>
				<td class="dog_table_common_cell">${breed}</td>
				<td class="dog_table_common_cell">${dogSize}</td>
				<td class="dog_table_common_cell" hidden>${year}/${month}/${date}</td>
				<td class="dog_table_common_cell" hidden>${time}</td>
				<td class="dog_table_common_cell" hidden>${branchOffice}</td>
				<td class="dog_table_common_cell" hidden>${category}</td>
				<td class="dog_table_common_cell" hidden>${dogId}</td>
				<td class="dog_table_common_cell" hidden>${memberId}</td>
				<td class="dog_table_common_cell" hidden>${timeId}</td>
			</tr>
		`)
		getServicePrice(dogSize, category);
	}
	$('.result_button_box').show();
	$('.dog_table_row').on('click', showReservationDetail);
}

function getServicePrice(dogSize, dogFacilities) {
	
	let category = $('.select_category p').text();
	const requestData = {
		'dogSize' : dogSize,
		'dogFacilities' : dogFacilities
	}
	$.ajax({
		type:'POST',
		url:'/thepet/calender/price',
		data : requestData,
		success : function (data) {
			const totalPriceBox = $('.total_price_box');
			totalPriceBox.show();
			
			let priceResult = data;
			
			
			if (totalPriceBox.children().length === 0) {
				if (category === '놀이터') {
					priceResult = data + Number($(".customer_counter_input").val()) * 10000;
				}
				
				totalPriceBox.append(`
					<p class="total_price_text">결제 예정 금액</p>
					<p class="total_price">${priceResult} 원</p>
				`)
			}
			else {
				let prevPrice = $('.total_price').text();
				prevPrice = Number(prevPrice.slice(0, -1))
				
				$('.total_price').text(`${prevPrice + priceResult} 원`);
			}
		}
	})
}

function showReservationDetail(e) {
	$('.select_info_table_row').removeClass('select_info_table_row');
	$(e.target).closest('tr').addClass('select_info_table_row')
	const info = $(e.target).closest('tr');
	const date = `${info.children('td:nth-child(5)').text()} ${info.children('td:nth-child(6)').text()}`;
	const locationData = {
		'branchOffice' : info.children('td:nth-child(7)').text(),
		'facilities' : info.children('td:nth-child(8)').text()
	}
	
	$.ajax({
		type:'POST',
		url : '/thepet/calender/facilitiesLocation',
		data : locationData,
		dataType:'json',
		success : function (data) {
			
			$('.information_detail_container').empty();
			$('.information_detail_container').append(`
				<h2 class="info_h2 dog_info_h2">
					이용 정보
				</h2>
				<table class="member_info_table">
					<tr class="info_table_row">
						<td class="row_head common_cell">이용일자</td>
						<td class="row_content common_cell">${date}</td>
					</tr>
					<tr class="info_table_row">
						<td class="row_head common_cell">이용 서비스</td>
						<td class="row_content common_cell">${data.dogFacilities}</td>
					</tr>
					<tr class="info_table_row">
						<td class="row_head common_cell">위치</td>
						<td class="row_content common_cell">${data.addressDetail}</td>
					</tr>
				</table>
			`);
		}
	})
}



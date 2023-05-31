$(function () {
    const date = new Date();
    
    const selectCategory = $('.select_category').text();
    
    const viewYear = date.getFullYear();
    const viewMonth = date.getMonth();
    const viewDate = date.getDate();
    
    const thisLast = new Date(viewYear, viewMonth + 1, 0);
    
    
    const oneDate = {
    	'category':selectCategory, 
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
		        else if(classDateName !== 'no_reservation' && data >= viewDate) {
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
    
});

function nextMonth() {
	const selectCategory = $('.select_category').text();
    const date = new Date();

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
        'category':selectCategory, 
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
	const selectCategory = $('.select_category').text();
	
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
        'category':selectCategory, 
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
		        	console.log(i);
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
	$('.checked_date').removeClass('checked_date');
	e.target.className += ' checked_date';
	const [year, month] = $('.ym').text().split('.');
	const d = $('.checked_date').text();
	const date = {'date' : `${year}/${month}/${d}`};
	
	$('.calender_detail_content').remove();
	
	$.ajax({
		type:'POST',
		url: "/thepet/calender/detail",
		data : date,
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
						<td class="detail_table_cell">${detail.remainCount > 0 ? '<input type="radio" name="reservation_time" class="radio_set"/>' : ''}</td>
						<td class="detail_table_cell">${detail.startTime}~${detail.endTime}</td>
						<td class="detail_table_cell ${detail.remainCount > 0 ? 'reservation_able' : 'reservation_disable'}">${detail.remainCount > 0 ? '예약가능':'예약불가'}</td>
						<td class="detail_table_cell">${detail.remainCount}</td>
					</tr>
				`)
			})
			
			$('.calender_detail_container').append(detailTable);
			
		},
		error : function (data) {
			
		}
	})
	
}



$(function () {
	
	
	$('.review_management_container').hide();
    const date = new Date();
    
    const viewYear = date.getFullYear();
    const viewMonth = date.getMonth();
    const viewDate = date.getDate();
    $(".ym").text(`${viewYear}.${viewMonth+1}`);
    $(".left").removeClass('active_arrow').addClass('disable_arrow');

    const prevLast = new Date(viewYear, viewMonth, 0);
    const thisLast = new Date(viewYear, viewMonth + 1, 0);

    const PLDay = prevLast.getDay();

    const TLDate = thisLast.getDate();

    const emptyDate = new Array((PLDay + 1) % 7);

    const thisDates = [...Array(TLDate + 1).keys()].slice(1);

    const result = [...emptyDate, ...thisDates]

    for (let i = 0; i < result.length; i++) {
        const date = result[i];
        let classDateName = "cur_date";
       /*
		 * if (date < viewDate) { classDateName = "prev_date"; } else {
		 * classDateName = "cur_date"; }
		 */
        
        let newDate = $("<div></div>").text(date)
        
        /*
		 * if (classDateName === 'cur_date') { newDate.on('click',
		 * dateClickEvent); }
		 */
        
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
    
	$('.reservation_tab').on('click', function() {
		$('.reservation_tab').removeClass('non_select_form').addClass('select_form');
		$('.review_tab').removeClass('select_form').addClass('non_select_form');
		$('.main_info').css('height', 900);
		/*
		 * $('.dog_form').show(); $('.mypet').hide();
		 */
	})
	
	$('.review_tab').on('click', function() {
		$('.review_tab').removeClass('non_select_form').addClass('select_form');
		$('.reservation_tab').removeClass('select_form').addClass('non_select_form');
		$('.main_info').css('height', 'auto');
		/*
		 * $('.mypet').show(); $('.dog_form').hide();
		 */
	})
	
	$('.reservation_tab').on('click', reservationClickEvent);
	$('.review_tab').on('click', reviewClickEvent);
    
	
	$('.myDropdown').change(function() {
        var selectedOption = $(this).val();
       console.log(selectedOption);
        $.ajax({
            url: '/thepet/admin/reservationLocation',
            method: 'POST', 
            data: { 
            	address: selectedOption,
            },  // AJAX 요청으로 보낼 데이터를 지정합니다. 서버에서는 이 데이터를 받아 처리할 수 있어야 합니다.
            success: function(response) {
    		      // 이번달 예약
    		      $('.this_month_reservation_data').text(response.currentMonthReservationsCount);

    		      // 지난달 예약
    		      $('.last_month_reservation_data').text(response.lastMonthReservationsCount);

    		      // 이번달 매출
    		      $('.this_month_sales_data').text(response.currentMonthSales);

    		      // 지난달 매출
    		      $('.last_month_sales_data').text(response.lastMonthSales);

    		      // 이번달 이용 고객 수
    		      $('.this_month_customers_data').text(response.currentMonthCustomerCount);

    		      // 지난달 이용 고객 수
    		      $('.last_month_customers_data').text(response.lastMonthCustomerCount);
    		      
    		      // 이번달 이용 강아지 수
    		      $('.this_month_puppies_data').text(response.currentMonthDogCount);
    		      
    		      // 지난달 이용 강아지 수
    		      $('.last_month_puppies_data').text(response.lastMonthDogCount);
            	
            	
            	console.log(response);
            },
            error: function(xhr, status, error) {
                console.log(error);  // 에러 발생 시 콘솔에 에러를 출력합니다.
            }
        });
    });
	
	$('.left').on('click', prevMonth);
	$('.right').on('click', nextMonth);
});


function reservationClickEvent() {
	$.ajax({
		type:'Get',
		url: "/thepet/admin/reservationManagement",
		success : function (data) {
			console.log("예약 관리 선택");
			$('.reservation_management_container').show();
		},
		error : function (request, status, error) {
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	})
	$('.reservation_management_container').show();
	$('.review_management_container').hide();
//	$.ajax({
//		type:'Get',
//		url: "/thepet/admin/reservationManagement",
//		success : function (data) {
//			console.log("예약 관리 선택");
//			$('.reservation_management_container').show();
//			window.location("");
//		},
//		error : function (request, status, error) {
//            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//        }
//	})
}

function reviewClickEvent() {
	console.log($('.review_comment_table_row'));
	$('.review_tab').removeClass('non_select_form').addClass('select_form');
	$('.reservation_tab').removeClass('select_form').addClass('non_select_form');
	
	$('.review_management_container').show();
	$('.review_comment_table_row').remove();
	
	// url 넣기
	$.ajax({
		type:'GET',
		url: "/thepet/admin/review",
		success : function (response) {
			console.log("리뷰 관리 선택");
			console.log(response);
			$('.reservation_management_container').hide();
			let no_cnt = 0;
            let cnt = 0;
			for (let i=0; i<response.length;i++) {



				let reservationDate=new Date(response[i].reservationDate);
                let year = reservationDate.getFullYear();
                let month = reservationDate.getMonth() + 1;
                let day = reservationDate.getDate();
                let formattedDate = `${year}-${month}-${day}`;

				
				if (response[i].adminContents === null) {
                    no_cnt += 1;
					$('.review_no_comment_table').append(`
							<tr class="review_comment_table_row">
								<td class="review_comment_table_cell">${response[i].dogFacilities}</td>
								<td class="review_comment_table_cell">${formattedDate}</td>
								<td class="review_comment_table_cell">${response[i].rate}</td>
								<td class="review_comment_table_cell">${response[i].serviceBt}</td>
								<td class="review_comment_table_cell">${response[i].spaceBt}</td>
								<td class="review_comment_table_cell">${response[i].cleanBt}</td>
								<td class="review_comment_table_cell">${response[i].revisitBt}</td>
								<td class="review_comment_table_cell"><form action="/thepet/review/detail1" method="GET"><input type="hidden" name="isAdmin" value="1"><input type="hidden" name="reservationId" value="${response[i].reservationId}"><input type="hidden" name="id" value="${response[i].memberId}"><button type="submit" class="review_comment_button">답변 등록</button></form></td>
								</tr>
					`)
				}
                else {
                    cnt += 1;
                    $('.review_commented_table').append(`
							<tr class="review_comment_table_row">
								<td class="review_comment_table_cell">${response[i].dogFacilities}</td>
								<td class="review_comment_table_cell">${formattedDate}</td>
								<td class="review_comment_table_cell">${response[i].rate}</td>
								<td class="review_comment_table_cell">${response[i].serviceBt}</td>
								<td class="review_comment_table_cell">${response[i].spaceBt}</td>
								<td class="review_comment_table_cell">${response[i].cleanBt}</td>
								<td class="review_comment_table_cell">${response[i].revisitBt}</td>
								<td class="review_comment_table_cell"><form action="/thepet/review/detail1" method="GET"><input type="hidden" name="isAdmin" value="1"><input type="hidden" name="reservationId" value="${response[i].reservationId}"><input type="hidden" name="id" value="${response[i].memberId}"><button type="submit" class="review_comment_button">답변 보기</button></form></td>
								</tr>
					`)
                }
			}
			
			$('.review_no_comment_p').text(`답변하지 않은 고객 리뷰 ${no_cnt} 건`);
			$('.review_commented_p').text(`답변하지 않은 고객 리뷰 ${cnt} 건`);
			
		},
		error : function (request, status, error) {
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	})
}


function nextMonth() {

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

    $('.main_date').empty();

    $(".ym").text(`${nextYear}.${nextMonth}`);
    
    const prevLast = new Date(year, month, 0);
    const thisLast = new Date(nextYear, nextMonth, 0);

    if (new Date() < thisLast) {
        $(".left").removeClass('disable_arrow').addClass('active_arrow');
    }

    const PLDay = prevLast.getDay();

    const TLDate = thisLast.getDate();

    const emptyDate = new Array((PLDay + 1) % 7);

    const thisDates = [...Array(TLDate + 1).keys()].slice(1);

    const result = [...emptyDate, ...thisDates]
    

    for (let i = 0; i < result.length; i++) {
        const date = result[i];

        if (i % 7 === 0) {
            $('.main_date').append($("<div></div>").text(date).addClass("cur_date date sun"));
        }
        else if (i % 7 === 6) {
            $('.main_date').append($("<div></div>").text(date).addClass("cur_date date sat"));
        }
        else {
            $('.main_date').append($("<div></div>").text(date).addClass("cur_date date"));
        }
    }
}

function prevMonth() {
    const date = new Date();
    const viewYear = date.getFullYear();
    const viewMonth = date.getMonth();
    const viewDate = date.getDate();
    
    const curMonth = $('.ym').text();
    const [year, month] = curMonth.split('.');
    let prevYear = 0;
    let prevMonth = 0;
    if (Number(month) === 1) {
        prevYear = Number(year) - 1;
        prevMonth = 12;
    }
    else {
        prevYear = Number(year);
        prevMonth = Number(month) - 1;
    }

    $('.main_date').empty();

    $(".ym").text(`${prevYear}.${prevMonth}`);
    
    const prevLast = new Date(prevYear, prevMonth - 1, 0);
    const thisLast = new Date(prevYear, prevMonth, 0);

    const PLDay = prevLast.getDay();

    const TLDate = thisLast.getDate();

    const emptyDate = new Array((PLDay + 1) % 7);

    const thisDates = [...Array(TLDate + 1).keys()].slice(1);

    const result = [...emptyDate, ...thisDates]

    if (new Date().getMonth()+1 === prevMonth) {
        $(".left").removeClass('active_arrow').addClass('disable_arrow');
    }
    
    for (let i = 0; i < result.length; i++) {
        const date = result[i];
        let classDateName = "";
        
        if (viewYear === prevYear && prevMonth === viewMonth+1) {
            
            if (date < viewDate) {
                classDateName = "prev_date";
            }
            else {
                classDateName = "cur_date";
            }
        }

        if (i % 7 === 0) {
            $('.main_date').append($("<div></div>").text(date).addClass(`${classDateName} date sun`));
        }
        else if (i % 7 === 6) {
            $('.main_date').append($("<div></div>").text(date).addClass(`${classDateName} date sat`));
        }
        else {
            $('.main_date').append($("<div></div>").text(date).addClass(`${classDateName} date`));
        }
    }
}


function dateClickEvent(e) {
	
	const moment = window.moment;
	
	$('.checked_date').removeClass('checked_date');
	e.target.className += ' checked_date';
	
	const [year, month] = $('.ym').text().split('.');
	
	const d = $('.checked_date').text();
	const date = moment(`${year}/${month}/${d}`, 'YYYY/M/D').format('YYYY/MM/DD');

	let selectedOption = $('.myDropdown').val();
	
	console.log(date);
	console.log(selectedOption);
	
	$.ajax({
		type:"post",
		url:"/thepet/admin/reservationDetial",
		data: {
			reservationDate : date,
			address : selectedOption
			},
		success: function(result) {
			
			$('.total_check').empty()
			$('.total_check_detail').empty()
			
			console.log(result)
			
			$('.total_check').append(
				`<tr class="total_check_table_row">
					<td class="total_check_column">총 결제 금액</td>
					<td>${result.totalPrice}</td>
				</tr>
				<tr>
					<td class="total_check_column">총 예약 건수</td>
					<td>${result.totalNum}</td>
				</tr>`
			)
			$('.total_check_detail').append(
				`<tr class="care total_check_detail_table_row">
					<td class="detail_td_title">케어</td>
					<td>${result.totalCareNum}</td>
					<td>${result.totalCarePrice}</td>
				</tr>
				<tr class="beauty total_check_detail_table_row">
					<td class="detail_td_title">미용</td>
					<td>${result.totalBeautyNum}</td>
					<td>${result.totalBeautyPrice}</td>
				</tr>
				<tr class="playground total_check_detail_table_row">
					<td class="detail_td_title">놀이터</td>
					<td>${result.totalPlaygroundNum}</td>
					<td>${result.totalPlaygroundPrice}</td>
				</tr>`
			)
		},
		error: function(result){
			console.log(result);
		}
	})
}
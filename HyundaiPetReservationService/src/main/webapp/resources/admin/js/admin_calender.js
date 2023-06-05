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
		/*
		 * $('.dog_form').show(); $('.mypet').hide();
		 */
	})
	
	$('.review_tab').on('click', function() {
		$('.review_tab').removeClass('non_select_form').addClass('select_form');
		$('.reservation_tab').removeClass('select_form').addClass('non_select_form');
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
    		      $('.reservation_table_this_month_check').text(response.currentMonthReservationsCount);

    		      // 지난달 예약
    		      $('.reservation_table_last_month_check').text(response.lastMonthReservationsCount);

    		      // 이번달 매출
    		      $('.reservation_table_this_month_sales').text(response.currentMonthSales);

    		      // 지난달 매출
    		      $('.reservation_table_cell_last_month_sales').text(response.lastMonthSales);

    		      // 이번달 이용 고객 수
    		      $('.reservation_table_this_month_customer_num').text(response.currentMonthCustomerCount);

    		      // 지난달 이용 고객 수
    		      $('.reservation_table_last_month_customer_num').text(response.lastMonthCustomerCount);
    		      
    		      // 이번달 이용 강아지 수
    		      $('.reservation_table_this_month_puppies').text(response.currentMonthDogCount);
    		      
    		      // 지난달 이용 강아지 수
    		      $('.reservation_table_last_month_puppies').text(response.lastMonthDogCount);
            	
            	
            	console.log(response);
            },
            error: function(xhr, status, error) {
                console.log(error);  // 에러 발생 시 콘솔에 에러를 출력합니다.
            }
        });
    });
});


function reservationClickEvent() {
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

/*function curMonth() {
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
       'startDate':`${viewYear}/${viewMonth+1}/${1}`,
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
          existDetail = [...emptyDate, ...existDetail];
          
          for (let i = 0; i < result.length; i++) {
              const date = result[i];
              
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
}*/

function dateClickEvent(e) {
	
	const moment = window.moment;
	
	$('.checked_date').removeClass('checked_date');
	e.target.className += ' checked_date';
	
	const [year, month] = $('.ym').text().split('.');
	
	const d = $('.checked_date').text();
	const date = moment(`${year}/${month}/${d}`, 'YYYY/M/D').format('YYYY/MM/DD');

	
	$.ajax({
		type:"post",
		url:"/thepet/admin/reservation",
		data: {
			reservationDate : date
			},
		success: function(result) {
			
			$('.total_check').empty()
			$('.total_check_detail').empty()
			
			console.log(result)
			
			$('.total_check').append(
				`<tr>
					<td class="total_check_column">총 결제 금액</td>
					<td>${result.totalPrice}</td>
				</tr>
				<tr>
					<td class="total_check_column">총 예약 건수</td>
					<td>${result.totalNum}</td>
				</tr>`
			)
			$('.total_check_detail').append(
				`<tr class="care">
					<td>케어</td>
					<td>${result.totalCareNum}</td>
					<td>${result.totalCarePrice}</td>
				</tr>
				<tr class="beauty">
					<td>미용</td>
					<td>${result.totalBeautyNum}</td>
					<td>${result.totalBeautyPrice}</td>
				</tr>
				<tr class="playground">
					<td>놀이터</td>
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
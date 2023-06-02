$(function () {
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
              
              let newDate = $("<div></div>").text(date)
              
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

function dateClickEvent(e) {
	
	const moment = window.moment;
	
	$('.checked_date').removeClass('checked_date');
	e.target.className += ' checked_date';
	
	const [year, month] = $('.ym').text().split('.');
	
	const d = $('.checked_date').text();
	const date = moment(`${year}/${month}/${d}`, 'YYYY/M/D').format('YYYY/MM/DD');

	// `` 사용하기
	console.log(date);
	console.log(typeof(date));
	
	$.ajax({
		type:"post",
		url:"/thepet/admin/reservation",
		data: {
			reservationDate : date
			},
		success: function(result) {
			// 성공하면 저 테이블에 값 보여주는 걸로
			console.log(result)
			/*$('.total_check').append(
					'<tr class="total_check_table_row">' + 
						'<td class=' + data[i].totalPrice + ' hidden></td>'+
						'<td class="total_price_data">' + data[i].name + '</td>' +
						'<td class="mypet_table_cell">' + data[i].age + '</td>' +
						'<td name=' + data[i].memberId + ' hidden></td>' +
					'</tr>'
			)*/
		},
		error: function(result){
			console.log(result);
		}
	})
}
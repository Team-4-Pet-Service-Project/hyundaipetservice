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
        let classDateName = "";
        if (date < viewDate) {
            classDateName = "prev_date";
        }
        else {
            classDateName = "cur_date";
        }
        
        let newDate = $("<div></div>").text(date)
        
        if (classDateName === 'cur_date') {
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
});

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
        
        let newDate = $("<div></div>").text(date);
        newDate.on('click', dateClickEvent);
        
        if (i % 7 === 0) {
            $('.main_date').append(newDate.addClass("cur_date date sun"));
        }
        else if (i % 7 === 6) {
            $('.main_date').append(newDate.addClass("cur_date date sat"));
        }
        else {
            $('.main_date').append(newDate.addClass("cur_date date"));
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
        else {
        	classDateName = "cur_date";
        }

        let newDate = $("<div></div>").text(date)
        
        if (classDateName === 'cur_date') {
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
}

function dateClickEvent(e) {
	$('.checked_date').removeClass('checked_date');
	e.target.className += ' checked_date';
	
}



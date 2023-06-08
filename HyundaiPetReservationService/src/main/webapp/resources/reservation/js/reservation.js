$(function() {
	$('.care_container').show();
	$('.playground_container').hide();
	$('.beauty_container').hide();
	
	$('.care').on('click', function() {
		selectOtherService();
		
		$('.care').addClass('select_category');
		$('.playground').removeClass('select_category');
		$('.beauty').removeClass('select_category');
		
		drawAddOption('care');
	})
	
	$('.playground').on('click', function() {
		selectOtherService();
		
		$('.care').removeClass('select_category');
		$('.playground').addClass('select_category');
		$('.beauty').removeClass('select_category');
		
		drawAddOption('playground');
	})
	
	$('.beauty').on('click', function() {
		selectOtherService();
		
		$('.care').removeClass('select_category');
		$('.playground').removeClass('select_category');
		$('.beauty').addClass('select_category');
		
		drawAddOption('beauty');
	})
})


function selectOtherService() {
	$("input:radio[name='experience']").prop('checked', false);
	$('.calender_detail_content').remove();
	$('.main_date').empty();
	$('.calender_container').hide();
	$('.add_button_box').hide();
	$('.result_button_box').hide();
	$('.total_price_box').empty();
	$('.total_price_box').css('display', 'none');
	$('.information_container').empty();
	$('.information_detail_container').empty();
	
	sessionStorage.clear();
	
	sessionStorage.setItem("reservationRemain", JSON.stringify({}));
}

function drawAddOption(category) {
	
	$('.add_option_container').empty();
	
	if (category === 'care') {
		$('.add_option_container').append(`
			<h1 class="add_option_h1">추가 옵션</h1>
			<div class="add_option_messagebox">
				<p class="add_message">* 약, 간식을 부탁하시려는 경우 다로 준비해 주셔야 하며,</p>
				<p class="add_message">먹여야 하는 시간은 직접 알려주셔야 합니다.</p>
				<p class="add_message">특이사항에 작성해주시길 바랍니다.</p>
			</div>	
		`)
	}
	else if (category === 'playground') {
		$('.add_option_container').append(`
			<h1 class="add_option_h1">추가 옵션</h1>
			<div class="add_option_counter_box">
				<div class="customer_counter_box">
					<p class="customer_text">보호자</p>
					<div class="customer_counter">
						<span class="material-symbols-outlined count_decrese">do_not_disturb_on</span>
						<input type="number" value="1" class="customer_counter_input" min="1"/><span class="customer_span">명</span>
						<span class="material-symbols-outlined count_increse">add_circle</span>
					</div>
				</div>
			</div>
		`)
		$('.count_decrese').on('click', countDecrease);
		$('.count_increse').on('click', countIncrease);
}
	else if (category === 'beauty') {
		$('.add_option_container').append(`
			<h1 class="add_option_h1">추가 옵션</h1>
			<div class="add_option_radio_box">
				<div class="radoi_button_box">
					<label for="beauty">
						<input type="checkbox" name="beauty_service_type" id="beauty" value="미용" class="add_option_radio_input"/>
						<i class="circle"></i>
						<span class="text">미용</span>
					</label>
				</div>
				<div class="radoi_button_box">
					<label for="spar">
						<input type="checkbox" name="beauty_service_type" id="spar" value="스파" class="add_option_radio_input"/>
						<i class="circle"></i>
						<span class="text">스파</span>
					</label>
				</div>
			</div>
		`)
	}
}

function countIncrease() {	
	$('.customer_counter_input').val(Number($('.customer_counter_input').val()) + 1);
}

function countDecrease() {
	
	if (Number($('.customer_counter_input').val()) === 1) {
		return;
	}
	
	$('.customer_counter_input').val(Number($('.customer_counter_input').val()) - 1);
}
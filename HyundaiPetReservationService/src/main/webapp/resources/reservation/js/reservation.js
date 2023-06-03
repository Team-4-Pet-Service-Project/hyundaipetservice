$(function() {
	$('.care_container').hide();
	$('.playground_container').hide();
	$('.beauty_container').show();
	
	$('.care_container .main_date').addClass("care_calender");
	$('.playground_container .main_date').addClass("playground_calender");
	$('.beauty_container .main_date').addClass("beauty_calender");
	
	$('.care').on('click', function() {
		$('.care').addClass('select_category');
		$('.playground').removeClass('select_category');
		$('.beauty').removeClass('select_category');
		
		$('.care_container').show();
		$('.playground_container').hide();
		$('.beauty_container').hide();
	})
	
	$('.playground').on('click', function() {
		$('.care').removeClass('select_category');
		$('.playground').addClass('select_category');
		$('.beauty').removeClass('select_category');
		
		$('.care_container').hide();
		$('.playground_container').show();
		$('.beauty_container').hide();
	})
	
	$('.beauty').on('click', function() {
		$('.care').removeClass('select_category');
		$('.playground').removeClass('select_category');
		$('.beauty').addClass('select_category');
		
		$('.care_container').hide();
		$('.playground_container').hide();
		$('.beauty_container').show();
	})
})
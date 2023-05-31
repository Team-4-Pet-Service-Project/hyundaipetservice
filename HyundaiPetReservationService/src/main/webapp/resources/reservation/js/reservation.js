$(function() {
	$('.playground_container').hide();
	$('.beauty_container').hide();
	
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
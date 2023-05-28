$(function () {
	$('.mypet').hide();
	$('.new_dog').on('click', function() {
		$('.new_dog').removeClass('non_select_form').addClass('select_form');
		$('.exist_dog').removeClass('select_form').addClass('non_select_form');
		
		$('.dog_form').show();
		$('.mypet').hide();
	})
	
	$('.exist_dog').on('click', function() {
		$('.exist_dog').removeClass('non_select_form').addClass('select_form');
		$('.new_dog').removeClass('select_form').addClass('non_select_form');
		$('.mypet').show();
		$('.dog_form').hide();
	})
})
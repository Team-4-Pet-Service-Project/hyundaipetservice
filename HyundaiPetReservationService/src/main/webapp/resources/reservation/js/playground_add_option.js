$(function() {
	$('.count_decrese').on('click', countDecrease);
	$('.count_increse').on('click', countIncrease);
})

function countIncrease() {	
	$('.customer_counter_input').val(Number($('.customer_counter_input').val()) + 1);
}

function countDecrease() {
	
	if (Number($('.customer_counter_input').val()) === 1) {
		return;
	}
	
	$('.customer_counter_input').val(Number($('.customer_counter_input').val()) - 1);
}
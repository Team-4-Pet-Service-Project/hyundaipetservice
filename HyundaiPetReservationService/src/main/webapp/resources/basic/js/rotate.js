$(function () {
	$('.menu_detail_box').hide();
})

const menuTrigger = document.querySelector('.menu-trigger');

menuTrigger.addEventListener('click', (event) => {
  event.currentTarget.classList.toggle('active-3');
  
  if ($('.active-3').length === 0) {
	  $('.menu_detail_box').hide();
  }
  else {
	  $('.menu_detail_box').show();
  }
});
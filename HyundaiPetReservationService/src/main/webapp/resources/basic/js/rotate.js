$(function () {
	$('.menu_detail_box').hide();
	$('.menu_detail_sub_category').hide();
	$('.pet_menu').hover(petMenuhoverEvent);
	$('.logo').on('click', function() {
		window.location.href = '/thepet/main';
	})
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

function petMenuhoverEvent() {
	$('.pet_menu').text('반려동물 >').addClass('selected_detail_main_category');
	$('.menu_detail_sub_category').show();
}

/*function petMenuhoverOutEvent() {
	$('.pet_menu').text('반려동물').removeClass('selected_detail_main_category');
	$('.menu_detail_sub_category').hide();
}*/
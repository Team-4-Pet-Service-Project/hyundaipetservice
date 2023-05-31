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
	
	$('.dog_form_btn').on('click', addDogClickEvent);
	$('.exist_dog').on('click', getDogsInfo);
})

function addDogClickEvent() {
	let form = $('.dog_form').serialize();
	console.log(form);
	$.ajax({
		type:'POST',
		url: "/thepet/addDog",
		data: form,
		success : function (data) {
			$('.dog_form')[0].reset();
		},
		error : function (request, status, error) {
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	})
}

function getDogsInfo() {
	$.ajax({
		type:'GET',
		url: "/thepet/getDogs",
		success : function (data) {
			$('.mypet_table_row').remove();
			
			for (let i = 0; i < data.length; i++) {
				$('.mypet_table').append(
					'<tr class="mypet_table_row">' + 
						'<td name=' + data[i].id + ' hidden></td>'+
						'<td class="mypet_table_cell"><input type="radio" name="select_mypet" class="mypet_radio"></td>' + 
						'<td class="mypet_table_cell">' + data[i].name + '</td>' +
						'<td class="mypet_table_cell">' + data[i].age + '</td>' +
						'<td class="mypet_table_cell">' + data[i].breed + '</td>' +
						'<td class="mypet_table_cell">' + data[i].dogSize + '</td>' +
						'<td name=' + data[i].memberId + ' hidden></td>' +
					'</tr>'
				)
			}
		},
		error : function (request, status, error) {
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	})
}
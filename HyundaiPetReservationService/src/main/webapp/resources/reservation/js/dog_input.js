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
	$('.dog_info_delect_btn').on('click', deleteDogInfo);
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
			console.log(data)
			$('.mypet_table_row').remove();
			
			for (let i = 0; i < data.length; i++) {
				$('.mypet_table').append(
					'<tr class="mypet_table_row">' + 
						'<td name="dogId" hidden>' + data[i].id + '</td>'+
						'<td class="mypet_table_cell"><input type="radio" name="select_mypet" class="mypet_radio"></td>' + 
						'<td class="mypet_table_cell" name="name">' + data[i].name + '</td>' +
						'<td class="mypet_table_cell" name="age">' + data[i].age + '</td>' +
						'<td class="mypet_table_cell" name="breed">' + data[i].breed + '</td>' +
						'<td class="mypet_table_cell" name="dogSize">' + data[i].dogSize + '</td>' +
						'<td name="memberId" hidden>' + data[i].memberId + '</td>' +
					'</tr>'
				)
			}
		},
		error : function (request, status, error) {
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	})
}

function deleteDogInfo() {
	console.log($('.mypet_radio:checked').closest('tr').children('td:nth-child(1)').text());
	
	if ($('.mypet_radio:checked').length === 0) {
		alert('삭제할 강아지를 선택하세요');
	}
	
	const checkedDogInfo = $('.mypet_radio:checked').closest('tr');
	let dogId = checkedDogInfo.children('td:nth-child(1)').text();
	
	$.ajax({
		type:'POST',
		url:"/thepet/deleteDog",
		data : {'dogId':dogId},
		success : function (data) {
			console.log(data);
			checkedDogInfo.remove();
		},
		error : function (request, status, error) {
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            alert('해당 강아지의 예약이 존재합니다.');
        }
	})
}
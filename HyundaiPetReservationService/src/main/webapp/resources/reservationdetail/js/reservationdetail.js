$('.list-button').click(function() {
	console.log('fdfd');
	history.back(); // 이전 페이지로 이동
});

/*모달창*/
const modal = document.getElementById("modal")

function modalOn() {
    modal.style.display = "flex"
}

function isModalOn() {
    return modal.style.display === "flex"
}

function modalOff() {
    modal.style.display = "none"
}


const btnModal = document.querySelector(".cancel-button");
btnModal.addEventListener("click", e => {
    modalOn();
});

const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})

modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})

window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})

$('#cancelButton').click(function() {
	modalOff()
});

$('#confirmButton').click(function() {
	var reservationId = document.getElementById("reservationId").value;
    // AJAX 호출
    $.ajax({
      url: '/thepet/reservation/delete',  // 실제 서버 URL로 대체해야 합니다.
      method: 'GET',  // 요청 메소드 (GET, POST 등)
      data: {
        // 필요한 데이터를 객체 형태로 전달합니다.
    	  reservationId: reservationId
      },
      success: function(response) {
        // 서버 응답을 받았을 때 실행할 동작을 여기에 작성합니다.
        window.location.href = response;
      },
      error: function(xhr, status, error) {
        // 서버 요청이 실패했을 때 실행할 동작을 여기에 작성합니다.
        console.log('요청 실패:', status, error);
      }
    });
  });

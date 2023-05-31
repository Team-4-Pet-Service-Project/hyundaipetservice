//const initialRate = parseInt('${rate}'); // JSP 변수를 가져와서 정수로 변환

document.addEventListener('DOMContentLoaded', function() {
    const stars = document.querySelectorAll('i'); // 선택자를 'i'로 변경
    const initial = document.getElementById("hidList").value; 
    const initialRate = parseInt(initial);
    for (let i = 0; i < initialRate; i++) {
      stars[i].classList.add('fas');
      stars[i].classList.remove('far');
    }

    console.log(stars);
  });


//여기 모달창

/*fetch("https://baconipsum.com/api/?type=all-meat&paras=200&format=html")
    .then(response => response.text())
    .then(result => loremIpsum.innerHTML = result)*/

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


const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
    modalOn()
})

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
	var reviewId = document.getElementById("reviewId").value;
	console.log(reviewId);
    // AJAX 호출
    $.ajax({
      url: '/thepet/review/delete',  // 실제 서버 URL로 대체해야 합니다.
      method: 'GET',  // 요청 메소드 (GET, POST 등)
      data: {
        // 필요한 데이터를 객체 형태로 전달합니다.
    	reviewId: reviewId
      },
      success: function(response) {
        // 서버 응답을 받았을 때 실행할 동작을 여기에 작성합니다.
        console.log('요청 성공:', response);
        window.location.href = response;
      },
      error: function(xhr, status, error) {
        // 서버 요청이 실패했을 때 실행할 동작을 여기에 작성합니다.
        console.log('요청 실패:', status, error);
      }
    });
  });


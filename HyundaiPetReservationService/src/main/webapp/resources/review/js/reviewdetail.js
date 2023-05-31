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
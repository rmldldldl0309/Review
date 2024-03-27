function goToKakaoHandler (event) {
    window.location.href = 'https://developers.kakao.com/';
}
const goToKakaoElement = document.getElementById('kakao');
goToKakaoElement.addEventListener('click', goToKakaoHandler);

function goToNaverHandler (event) {
    window.location.href = 'https://developers.naver.com/';
}
const goToNaverElement = document.getElementById('naver');
goToNaverElement.addEventListener('click', goToNaverHandler);
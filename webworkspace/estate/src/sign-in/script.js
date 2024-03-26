const ID = 'rmldldldl0309';
const PASSWORD = 'qwe123';

function onSignInButtonClickHandler(event) {
    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;

    if (id === ID && password === PASSWORD) {
        alert('로그인 성공!')
    } else {
        const signInMessageElement = document.getElementById('sign-in-message');
        signInMessageElement.textContent = '로그인 정보가 일치하지 않습니다';
    }
}

function onSignUpLinkClickHandler (event) {
    window.location.href = 'https://google.com';
}

const signUpLinkElement = document.getElementById('sign-up-link');
signUpLinkElement.addEventListener('click', onSignUpLinkClickHandler);

// https://developers.kakao.com/

// https://developers.naver.com/

function goToKakaoHandler (evert) {
    window.location.href = 'https://developers.kakao.com/';
}
const goToKakaoElement = document.getElementById('kakao');
goToKakaoElement.addEventListener('click', goToKakaoHandler);

function goToNaverHandler (evert) {
    window.location.href = 'https://developers.naver.com/';
}
const goToNaverElement = document.getElementById('naver');
goToNaverElement.addEventListener('click', goToNaverHandler);
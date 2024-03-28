const ID = 'rmldldldl0309';
const PASSWORD = 'qwe123';
const EMAIL = 'email@gmail.com'
const AUTH_NUMBER = '1010';

let id = '', password = '', passwordCheck = '', email = '', authNumber = '';
let isDuplicate = true, isPasswordPattern = false, isEqualPassword = false, isEmail = false, isDuplicateEmail = true, isEqualAuthNumber = false;

const idInputElement = document.getElementById('id');
const passwordInputElement = document.getElementById('password');
const passwordCheckInputElement = document.getElementById('password-check')
const emailInputElement = document.getElementById('email');
const authNumberInputElement = document.getElementById('auth-number');

const checkDuplicateButtonElement = document.getElementById('check-duplication-button');
const checkEmailButtonElement = document.getElementById('check-email-button');
const checkAuthNumberButtonElement = document.getElementById('check-auth-number-button');

const idMessageElement = document.getElementById('id-message');
const passwordMessageElement = document.getElementById('password-message');
const passwordCheckMessageElement = document.getElementById('password-check-message')
const emailMessageElement = document.getElementById('email-message');
const authNumberMessageElement = document.getElementById('auth-number-message');

const signUpbuttonElement = document.getElementById('sign-up-button')
const signUpLinkElement = document.getElementById('sign-in-link');

function onIdInputHandler (event) {
    // 변수에 이벤트가 일어났을떄 실제값 저장
    id = event.target.value;
    // ?
    isDuplicate = true;
    // 입력한 값을 변경되거나 공백이 되었을 때 메세지 없애기
    if (!id || id) idMessageElement.textContent = '';
    // 변수에 이벤트가 일어났을 때 버튼 활성화
    if (id) checkDuplicateButtonElement.className = 'input-primary-button';
    else checkDuplicateButtonElement.className = 'input-disable-button';
}

function onPasswordInputHandler (event) {
    password = event.target.value;
    // 정규표현식을 통해 비밀번호 양식 지정
    const passwordReg = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,13}$/;
    // 비밀번호가 양식에 맞게 입력되었는지 테스트한 값을 저장
    isPasswordPattern = passwordReg.test(password);
    // 테스트한 값이 false면 에러메세지, true면 메서지 출력 X
    if (!isPasswordPattern) {
        passwordMessageElement.className = 'input-message error';
        passwordMessageElement.textContent = '영문 숫자를 혼용하여 8~13자리를 입력해주세요';
        return;
    }
    passwordMessageElement.className = 'input-message';
    passwordMessageElement.textContent = '';
};

function onPasswordCheckInputHandler (event) {
    passwordCheck = event.target.value;
    // 앞서 입력했던 비밀번호와 체크칸에 입력한 비밀번호가 동일한가?
    isEqualPassword = password === passwordCheck;
    // 동일하지 않다면 에러메세지, 동일하면 ok메세지
    if (!isEqualPassword) {
        passwordCheckMessageElement.className =  'input-message error';
        passwordCheckMessageElement.textContent = '비밀번호가 일치하지 않습니다';
        return;
    }
    passwordCheckMessageElement.className =  'input-message primary';
    passwordCheckMessageElement.textContent = '비밀번호가 일치합니다';
}


function onEmailInputHandler (event) {
    email = event.target.value;
    // 
    isEmail = false;
    isDuplicateEmail = true;

    if (!email || email) emailMessageElement.textContent = '';

    if (email) checkEmailButtonElement.className = 'input-primary-button';
    else checkEmailButtonElement.className = 'input-disable-button';
}

function onAuthNumberInputHandler (event) {
    authNumber = event.target.value;
    isEqualAuthNumber = false;
    
    if (!authNumber || authNumber) authNumberMessageElement.textContent = '';

    if (authNumber) checkAuthNumberButtonElement.className = 'input-primary-button';
    else checkAuthNumberButtonElement.className = 'input-disable-button';
}

// input이 일어났을 때 유효성 검사 및 회원가입
idInputElement.addEventListener('input', function (event){
    onIdInputHandler(event);
    setSignUpButton();
});
passwordInputElement.addEventListener('input', function (event){
    onPasswordInputHandler(event);
    setSignUpButton();
})
passwordCheckInputElement.addEventListener('input', function (event){
    onPasswordCheckInputHandler(event);
    setSignUpButton();
})
emailInputElement.addEventListener('input', function (event){
    onEmailInputHandler(event);
    setSignUpButton();
});
authNumberInputElement.addEventListener('input', function (event){
    onAuthNumberInputHandler(event);
    setSignUpButton();
});

function onCheckDuplicateClickHandler (event) {
    // 값 없으면 버튼 활성화X
    if (!id) return;

    isDuplicate = id === ID;
    
    if (isDuplicate) {
        idMessageElement.className = 'input-message error';
        idMessageElement.textContent = '이미 사용중인 아이디 입니다';
        return;
    }
    idMessageElement.className = 'input-message primary'
    idMessageElement.textContent = '사용 가능한 아이디 입니다';
}

function onCheckEmailClickHander (event) {
    if (!email) return;

    const emailReg = /^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\.[a-zA-Z]{2,3}$/; 
    isEmail = emailReg.test(email);
    if (!isEmail) {
        emailMessageElement.className = 'input-message error';
        emailMessageElement.textContent = '잘못된 이메일 형식입니다';
        return;
    }

    isDuplicateEmail = email === EMAIL;
    if (isDuplicateEmail) {
        emailMessageElement.className = 'input-message error';
        emailMessageElement.textContent = '이미 사용중인 이메일입니다';
        return;
    }

    emailMessageElement.className = 'input-message primary';
    emailMessageElement.textContent = '인증번호가 전송되었습니다'
}

function onCheckAuthNumberClickHandler (event) {
    if (!authNumber) return;

    isEqualAuthNumber = authNumber === AUTH_NUMBER;
    if (!isEqualAuthNumber) {
        authNumberMessageElement.className = 'input-message error';
        authNumberMessageElement.textContent = '인증번호가 일치하지 않습니다.';
        return;
    }
    
    authNumberMessageElement.className = 'input-message primary';
    authNumberMessageElement.textContent = '인증번호가 확인되었습니다.';
}

checkDuplicateButtonElement.addEventListener('click', function (event){
    onCheckDuplicateClickHandler(event);
    setSignUpButton();
});
checkEmailButtonElement.addEventListener('click', function (event){
    onCheckEmailClickHander(event);
    setSignUpButton();
});
checkAuthNumberButtonElement.addEventListener('click', function (event){
    onCheckAuthNumberClickHandler(event);
    setSignUpButton();
});

function onSignInLinkClickHandler (event) {
    window.location.href = '../sign-in';
}

signUpLinkElement.addEventListener('click', onSignInLinkClickHandler);

function setSignUpButton () {
    const isPrimaryButton =
        id && password && passwordCheck && email && authNumber && !isDuplicate && isPasswordPattern && isEqualPassword && isEmail && !isDuplicateEmail && isEqualAuthNumber;
    
    if (isPrimaryButton) signUpbuttonElement.className = 'primary-button full-width';
    else signUpbuttonElement.className = 'disable-button full-width';

}

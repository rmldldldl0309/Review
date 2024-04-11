import React, { useState } from 'react'
import './style.css'

type AuthPage = 'sign-in' | 'sign-up';

interface Props {
    // 함수의 타입 선언 시 > 화살표 함수로 매개변수 + 리턴 값 입력
    onLinkClickHandler: () => void;
}

function SignIn ({onLinkClickHandler}: Props) {
    const onSignInButtonClickHandler = () => {

    };

    return(
        <div className='authentication-contents'>
            <div className='authentication-input-container'></div>
            <div className='authentication-button-container'>
                <div className="primary-button full-width" onClick={onSignInButtonClickHandler}>로그인</div>
                <div className="text-link" onClick={onLinkClickHandler}>회원가입</div>
            </div>
            <div className='short-divider'></div>
            <div className='authentication-sns-container'></div>
        </div>
    )
}

function SignUp ({onLinkClickHandler}: Props) {

    const onSignInButtonClickHandler = () => {};

    return (
        <div className='authentication-contents'>
            <div className='authentication-sns-container'></div>
            <div className='short-divider'></div>
            <div className='authentication-input-container'></div>
            <div className='authentication-button-container'>
                <div className="primary-button full-width" onClick={onSignInButtonClickHandler}>회원가입</div>
                <div className="text-link" onClick={onLinkClickHandler}>로그인</div>
            </div>
        </div>
    )
}

export default function Authentication () {

    // use- 함수 = 훅함수 > 반드시 컴포넌트 바로 아래에 선언되어 있어야 한다
    const [page, setPage] = useState<AuthPage>('sign-in');

    const onLinkClickHandler = () => {
        if (page === 'sign-in') setPage('sign-up');
        else setPage('sign-in');
    }

    const AuthenticationContents = page === 'sign-in' ? <SignIn onLinkClickHandler={onLinkClickHandler}/> : <SignUp onLinkClickHandler={onLinkClickHandler}/>;

    return (
        <div id='authentication-wrapper'>
            <div className='authentication-image-box'></div>
            <div className='authentication-box'>
                <div className='authentication-container'>
                    <div className='authentication-title h1'>{'임대 주택 가격 서비스'}</div>
                    {AuthenticationContents}
                </div>
            </div>
        </div>
    )
}

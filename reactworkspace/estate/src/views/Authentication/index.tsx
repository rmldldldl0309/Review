import React, { ChangeEvent, useState } from 'react'
import './style.css'

import SignInBackground from 'assets/img/sign-in-background.png'
import SignUpBackground from 'assets/img/sign-up-background.png'
import InputBox from 'components/Inputbox';

type AuthPage = 'sign-in' | 'sign-up';

interface SnsContainerProps {
    title: string;
}

function SnsContainer ({title}: SnsContainerProps) {

    const onSnsButtonClickHandler = (type: 'kakao' | 'naver') => {
        alert(type);
    };

    return(
        <div className='authentication-sns-container'>
            <div className='sns-container-title label'>{title}</div>
            <div className='sns-button-container'>
                <div className='sns-button kakao-button' onClick={() => onSnsButtonClickHandler('kakao')}></div>
                <div className='sns-button naver-button' onClick={() => onSnsButtonClickHandler('naver')}></div>
            </div>
        </div>
    );
};

interface Props {
    // 함수의 타입 선언 시 > 화살표 함수로 매개변수 + 리턴 값 입력
    onLinkClickHandler: () => void;
}

function SignIn ({onLinkClickHandler}: Props) {

    const [id, setId] = useState<string>('');
    const [password, setPassword] = useState<string>('');

    //                                                 input에 대한 change 이벤트 발생 시
    const onIdChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        setId(event.target.value);
    };
    
    const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        setPassword(event.target.value);
    };

    const onSignInButtonClickHandler = () => {
        alert(`아이디: ${id} / 비밀번호: ${password}`);
        setId('');
        setPassword('');
        alert(`아이디: ${id} / 비밀번호: ${password}`);
    };

    return(
        <div className='authentication-contents'>
            <div className='authentication-input-container'>
                <InputBox label='아이디' type='text' value={id} placeholder='아이디를 입력해주세요' onChangeHandeler={onIdChangeHandler}/>
                <InputBox label='비밀번호' type='password' value={password} placeholder='비밀번호를 입력해주세요' onChangeHandeler={onPasswordChangeHandler}/>
            </div>
            <div className='authentication-button-container'>
                <div className="primary-button full-width" onClick={onSignInButtonClickHandler}>로그인</div>
                <div className="text-link" onClick={onLinkClickHandler}>회원가입</div>
            </div>
            <div className='short-divider'></div>
            <SnsContainer title='sns 로그인'/>
        </div>
    )
}

function SignUp ({onLinkClickHandler}: Props) {

    //                  state                    // 
    const [id, setId] = useState<string>('');
    const [password, setPassword] = useState<string>("");
    const [passwordCheck, setpasswordCheck] = useState<string>("");
    const [email, setEmail] = useState<string>("");
    const [num, setNum] = useState<string>("");

    const [idButtonStatus, setidButtonStatus] = useState<boolean>(false);
    const [emailButtonStatus, setEmailButtonStatus] = useState<boolean>(false);
    const [numButtonStatus, setNumButtonStatus] = useState<boolean>(false);

    //                  event Handler                   //
    const onIdChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const {value} = event.target;
        setId(value);
        setidButtonStatus(value !== '');
    };
    const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const {value} = event.target;
        setPassword(value);
    };
    const onPasswordCheckChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const {value} = event.target;
        setpasswordCheck(value);
    };
    const onEmailChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const {value} = event.target;
        setEmail(value);
        setEmailButtonStatus(value !== '');
    };
    const onNumChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const {value} = event.target;
        setNum(value);
        setNumButtonStatus(value !== '');
    };

    const onIdButtonClickHandler = () => {
        if (!idButtonStatus) return;
        alert(id);
    }
    const onEmailButtonClickHandler = () => {
        if (!emailButtonStatus) return;
        alert(email);
    }
    const onNumButtonClickHandler = () => {
        if (!numButtonStatus) return;
        alert(num);
    }

    const onSignInButtonClickHandler = () => {};

    //                  render                  //
    return (
        <div className='authentication-contents'>
            <SnsContainer title='SNS 회원가입'/>
            <div className='short-divider'></div>
            <div className='authentication-input-container'>
                <InputBox label='아이디' type='text' value={id} placeholder='아이디를 입력해주세요' onChangeHandeler={onIdChangeHandler} buttonTitle='중복 확인' buttonStatus={idButtonStatus} onIdButtonClickHandler={onIdButtonClickHandler}/>
                <InputBox label='비밀번호' type='password' value={password} placeholder='비밀번호를 입력해주세요' onChangeHandeler={onPasswordChangeHandler}/>
                <InputBox label='비밀번호 확인' type='password' value={passwordCheck} placeholder='비밀번호를 입력해주세요' onChangeHandeler={onPasswordCheckChangeHandler}/>
                <InputBox label='이메일' type='text' value={email} placeholder='이메일 주소를 입력해주세요' onChangeHandeler={onEmailChangeHandler} buttonTitle='이메일 인증' buttonStatus={emailButtonStatus} onIdButtonClickHandler={onEmailButtonClickHandler}/>
                <InputBox label='인증번호' type='text' value={num} placeholder='인증번호 4자리를 입력해주세요' onChangeHandeler={onNumChangeHandler} buttonTitle='인증 확인' buttonStatus={numButtonStatus} onIdButtonClickHandler={onNumButtonClickHandler}/>
            </div>
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

    const imageboxStyle = {backgroundImage: `url(${page === 'sign-in' ? SignInBackground : SignUpBackground})`};

    return (
        <div id='authentication-wrapper'>
            <div className='authentication-image-box' style={imageboxStyle}></div>
            <div className='authentication-box'>
                <div className='authentication-container'>
                    <div className='authentication-title h1'>{'임대 주택 가격 서비스'}</div>
                    {AuthenticationContents}
                </div>
            </div>
        </div>
    )
}

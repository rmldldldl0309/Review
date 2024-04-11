import React, { ChangeEvent } from "react";
import './style.css';

export interface InputBoxProps {
    label: string;
    type: 'text' | 'password';
    value: string;
    placeholder: string;
    onChangeHandeler: (event: ChangeEvent<HTMLInputElement>) => void;
    buttonTitle?: string;
    buttonStatus?: boolean;
    onIdButtonClickHandler?: () => void;
}

export default function InputBox({ label, type, value, placeholder, buttonTitle, onChangeHandeler, buttonStatus, onIdButtonClickHandler }: InputBoxProps) {

    const buttonClass = buttonStatus ? `input-primary-button` : 'input-disable-button';

    return (
        <div className="input-box">
            <div className="input-label label">{label}</div>
            <div className="input-content-box">
                <input
                    className="input"
                    // 상태의 불일치 해결
                    type={type}
                    value={value}
                    placeholder={placeholder}
                    onChange={onChangeHandeler}
                />
                { buttonTitle && 
                <div className={buttonClass} onClick={onIdButtonClickHandler}>
                    {buttonTitle}
                </div> 
                }
            </div>
            <div className="input-message"></div>
        </div>
    );
}
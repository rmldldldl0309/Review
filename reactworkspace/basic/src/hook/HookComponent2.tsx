import React, { useRef, useState } from 'react'

export default function HookComponent2() {

    const [image, setImage] = useState<string>('');

    // useRef :
    // DOM 객체를 직접 다루고자 할때 혹은 렌더링 없이 값을 변경, 저장하고자 할 때 사용
    // const DOM객체참조변수 = useRef<DOM요소타입>()
    // DOM 객체를 참조하기 위해서 useRef를 사용하면 참조할 요소에 ref={} 속성에 해당 참조요소를 지정해야 함
    const inputRef = useRef<HTMLInputElement>(null);    // inputRef => HTMLInputElement | undefined

    const onButtonClickHandler = () => {
        // ref의 참조 객체는 해당 변수의 current 속성에 들어있음
        // 참조변수(null 혹은 undefined를 가질 수 있는 object타입의 변수)에서 특정 속성 및 메서드를 호출하려할 때 null 혹은 undefined가 아닌 상태에서만 작업을 수행하도록 하기 위해 참조변수?.속성 혹은 참조변수?.함수()로 실행
        // current? >null 혹은 undefined가 아니면 focus함수 수행
        // inputRef.current?.focus()                                        // 불안정한 형태
        if(inputRef.current) inputRef.current.focus();              // 위의 코드 보완
    }

    const onInputChangeHandler = () => {
        const { current } = inputRef;
        if (!current) return;
        if (!current.files) return;

        const file = current.files[0];
        const fileReader = new FileReader();
        fileReader.readAsDataURL(file);
        fileReader.onloadend = () => {
            setImage(fileReader.result as string);
        };
    }

    return (
        <div>
            <img src={image} />
            <input ref={inputRef} type='file' onChange={onInputChangeHandler}/>
            <button onClick={onButtonClickHandler}>❎</button>
        </div>
    )
}

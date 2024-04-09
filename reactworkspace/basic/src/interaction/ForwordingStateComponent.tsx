import React, { useState } from 'react'

// 컴포넌트로 상태 전달
// - 부모요소에 자식요소로 상태를 전달하려면 Properties로 전달
// - 문제점 : 
// - 자식 컴포넌트에서 상태를 변경하면 부모 컴포넌트가 리렌더링됨
// - 해당 상태를 쓰지 않는 부모 컴포넌트의 자식 컴포넌트도 같이 렌더링
// - 상태 선언을 최대한 낮은 부모 컴포넌트에서 선언하여 전달
// - 이 문제를 해결하기 위해 글로벌 상태(context, Redux, zustand)라고 하는 상태관리가 파생됨

interface Sub1Props {
    count: number;
    onClickHandler: () => void;
}

function SubComponent1 ({count, onClickHandler}: Sub1Props)  {
    return (
        <>
            <h1 style={{backgroundColor: 'red'}} onClick={onClickHandler}>{count}</h1>
        </>
    )
}

function SubComponent2 (props: Sub1Props) {

    const [numbers, setNumbers] = useState<number[]>([]);

    const onClickHandler = () => {
        numbers.push(0);
        setNumbers(numbers);
    };

    return (
        <div style={{padding: '8px', backgroundColor: 'blue'}}>
            <h2 onClick={onClickHandler}>{numbers.length}</h2>
            <SubComponent1 {...props}/>
        </div>
    )
}

export default function ForwordingStateComponent() {

    //       상태함수  상태변경함수                  타입  초기값
    const [count, setCount] = useState<number>(0);

    const onPlusButtonClickHandler = () => {
        setCount(count + 1);
    };

    return (
        <>
            <SubComponent1 count={count} onClickHandler={onPlusButtonClickHandler}/>
            <SubComponent2 count={count} onClickHandler={onPlusButtonClickHandler}/>
            <button onClick={onPlusButtonClickHandler}>+</button>
        </>
    )
}

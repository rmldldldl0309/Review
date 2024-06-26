import React from 'react'

// 조건부 렌더링
// - 상황 (조건)에 따라서 결과를 다르게 렌더링 하려고 할 때 사용
// - if, &&, ?(삼항 연산)을 사용하는 방법이 존재

//                             number를 반환    변수명    변수 타입
function IfComponent ({number}: {number: number}) {
    // if문을 이용한 조건부 렌더링
    // - 함수(컴포넌트 함수) 내부에서 return을 다르게 주는 방법

    // ex) number가 양수면 number값을 h1이면서 red로 표시 / 음수면 number값을 h3면서 blue / 0이면 number값을 h2면서 green
    if (number > 0) return (
        <h1 style={{color: 'red'}}>{number}</h1>
    )
    if (number < 0) return (
        <h3 style={{color:'blue'}}>{number}</h3>
    )
    return (
        <h2 style={{color:'green'}}>{number}</h2>
    )

    // else if > 후속검사 하고싶지 않을 때 사용

}

function AndComponent ({number}: {number: number}) {
    // && 연산자를 이용한 조건부 렌더링
    // - JSX 내부(return 내부)에서 상황에 따라 렌더링 여부를 결정하고 싶을 때 사용

    // ex) 만약 number가 양수면 `양수`를 렌더링
    // if (number > 0) return '양수';
    // + 양수가 아니면 '양수가 아님'을 렌더링
    // if (number <= 0) return '양수가 아님';
    // if (!(number > 0)) return '양수가 아님';
    return (
        <h1>
            {number > 0 && "양수"}
            {number <= 0 && "양수가 아님"}
            {/* {number > 0 || "양수가 아님"} */}
        </h1>
    )
}

function ThreeTermComponent ({number}: {number: number}) {
    // 삼항 연산자(? :)를 이용한 조건부 렌더링
    // JSX 내부에서 (return 안) 상황(조건)에 따라서 서로 다른 렌더링을 하고 싶을 때 사용

    // ex) number가 양수면 '양수', 음수면 '음수', 0이면 '영'
    return (
        <h1>
            {number > 0 ? '양수' : number < 0 ? '음수' : '영'}
        </h1>
    )
}

export default function ConditionalRedering() {

    return (
        <>
            <IfComponent number={1}/>
            <IfComponent number={-1}/>
            <IfComponent number={0}/>
            <AndComponent number={1}/>
            <AndComponent number={0}/>
            <ThreeTermComponent number={1}/>
            <ThreeTermComponent number={0}/>
            <ThreeTermComponent number={-1}/>
        </> 
    )

}

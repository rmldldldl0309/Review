import React from 'react'

// Properties (속성)
// - 부모 컴포넌트 (호출부)에서 자식 컴포넌트로 데이터를 전달하기 위한 *객체*
// - 부모 컴포넌트에서는 HTML과 동일한 방식 (속성명 = 데이터) 로  전달
// - 자식 컴포넌트에서는 JS의 매개변수 방식으로 받음
// - 전달할 수 있는 데이터는 JS로 표현할 수 있는 모든 형태
// - 컴포넌트가 리렌더링되는 기준
// - Properties 부모요소에서 자식 요소로 데이터 전송 O, 자식에서 부모요소로 데이터 전송 X

interface Props {
    title: string;
    content: string;
    // 선택형
    nickname?: string;
}

function Child({title, content, nickname = "비공개"}: Props) {

    // const title = props.title;
    // const content = props.content;

    // const {title, content} = props;

    return(
        <div>
            <h1>{title}</h1>
            <h1>{nickname}</h1>
            <p>{content}</p>
        </div>
    )
}

export default function Properties() {
    return (
    <>
        <Child title = '제목1' content = '내용1' nickname="Sky" />
        <Child title = '국제인구 이동' content = '보도자료'/>
        <Child  title = '외국인 지역별 통계' content = '?'/>
    </>
    )
}

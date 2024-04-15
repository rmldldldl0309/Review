import React, { useEffect, useState } from 'react'

//? Hook 함수 : 
// - React에서 컴포넌트의 상태와 생명주기에 따른 기능을 수행할 수 있도록 해주는 특별한 함수
// - use로 시작하는 함수

//? - Hook 함수의 종류 >
// - useState : 컴포넌트의 상태 관리를 가능하게 해주는 함수 / 상태 생성, 업데이트, 값에 접근
// - useEffect : 컴포넌트가 렌더링될 때마다 특정 작업을 수행할 수 있도록 하는 함수 / mount, update, unmout 단계에서 수행되는 함수
// - useRef : 1. DOM 요소에 직접 접근하기 위한 함수 / 2. 렌더링 사이에 값을 기억하는 함수       > 1번의 용도로 많이 사용
// - useContext : 컴포넌트 트리상에서 전역적으로 상태를 공유하고자 할 때 사용하는 함수
// - useReducer : 상태 로직을 관리하는 함수 / 상태 업데이트 로직을 컴포넌트 외부로 옮길 수 있도록 하여 코드관리를 수월하게 만든다
// - useCallback : 메모리 내에서 함수를 재사용할 수 있도록 하는 함수 / 렌더링 없이 특정 함수를 다시 호출할 수 있도록 해줌
// - useMemo : 메모리에 계산된 값(함수의 결과)을 저장하여 함수를 재실행하지 않고 사용할 수 있도록 하는 함수 

// - 훅 함수는 반드시 컴포넌트의 코드블럭에 존재해야한다. 
// - 만약 컴포넌트의 코드블럭 외의 다른곳에 위치하는 경우 그 코드블럭은 반드시 훅 함수여야 한다
// const [count, setCount] = useState<number>(0);

export default function HookComponent1() {

    const [count, setCount] = useState<number>(0);
    const [flag, setFlag] = useState<boolean>(false);

    const addCount = () => {
        // const [count, setCount] = useState<number>(0);
        setCount(count + 1);
    }
    const reverseFlag = () => {
        setFlag(!flag);
    }
    
    //? useEffect :
    // - 컴포넌트의 생명주기에 따라 특정함수를 수행하도록 하는 훅 함수
    // - useEffect(실행할 함수, 스코프할 상태 배열);
    //* - 개발자 모드에서는  mount - unmout가 한번 실행 되면서 테스트 후 다시 정상 실행
    
    // 컴포넌트 마운트 시에만 실행 > 페이지 실행 시 해야하는 작업 지정 시 사용
    useEffect(() => {
        // console.log('useEffect');
    }, [] );

    // 스코프할 상태배열을 지정하지 않으면 모든 상태가 변경될 때마다 실행됨
    useEffect(() => {
        //! 스코프 할 상태배열을 지정하지 않은 effect에서 상태를 변경하면 무한 실행 > 의도치 않은 디도스
        //! setFlag(!flag)
        // console.log('useEffect');
    });

    // 스코프할 상태배열에 상태를 지정하면 지정한 상태가 변경되 될때마다 실행됨
    useEffect(() => {
        //! 스코프 할 상태배열에 지정한 상태를 해당 effect에서 변경하면 무한 실행
        //! setCount(count + 1);
        // console.log('count 변경');
        // console.log(count);
    }, [count] );

    // 스코프할 상태 배열에 두 개 이상의 상태를 지정할 수 있다 (배열에 포함된 상태 중 하나라도 변경되면 effect가 실행되)
    useEffect(() => {
        // console.log('count 또는 flag가 변경됨');
        // console.log(count);
        // console.log(flag);
    }, [count, flag]);
    
    const SubComponent = () => {

        // 전달한 콜백함수의 리턴으로 unmount시 실행할 함수를 반환할 수 있다
        //상태 스코프와 연결하여 작업할 필요 X
        useEffect( () => {
            console.log('mount 시 실행');
            return () => {
                console.log('unmount 시 실행');
            }
        }, [])

        return <h1>SubComponent</h1>
    }
    
    return (
        <div>
            {count}
            {flag && <SubComponent/>}
            <button onClick={addCount}>+</button>
            <button onClick={reverseFlag}>!</button>
        </div>
    )
}

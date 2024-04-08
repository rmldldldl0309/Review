import React, { ChangeEvent, useState } from 'react'
import { setConstantValue } from 'typescript';

// 상태(status)
// - 각각의 컴포넌트를 가지는 데이터
// - 컴포넌트의 렌더링 결과에 영향을 미침
// - 컴포넌트는 독립적인 상태를 가질 수 있다
// - 상태가 변경되면 컴포넌트가 리랜더링 됨

export default function StatementComponent() {

    // status 선언
    // - useState라는 함수로 함수를 선언할 수 있다
    // - const [상태변수, 상태변경 함수] = userState<상태변수타입>(초기값);
    
    // let count = 0;
    let [count, setCount] = useState<number>(0);
    // let total: number = 0;
    const [total, setTotal] = useState<number>(0);
    // let favorits: string[] = [];
    const [favorites,setFavorites] = useState<string[]>(['사과']);
    const [favorite, setFavorite] = useState<string>('');

    const onCountAddHandler = () => {
        // setCount(count + 1);
        // 상태변수는 반드시 상태변경함수로 변경해야 리렌더링됨`
        // count ++;
        
        // 상태 변경 함수를 통해 함수를 변경한다고 바로 적용 X
        // 리렌더링 된후 상태변경함수가 적용
        // setCount(count + 1);
        // setCount(count + 1);
        // setCount(count + 1);

        // 상태변경 함수에 콜백함수를 전달하면 해당 콜백함수는 상태 변경 작업을 누적해서 함
            // setCount((count) => count + 1)
            // setCount((count) => count + 1)
            // setCount((count) => count + 1)

        // 변경된 상태를 사용하고 싶을 때 해결방법 : 임시 변수를 사용하여 간접 사용
        const tmp = count + 1;
        setCount(tmp);
        setTotal(total + tmp);

    };
    
    // Input 요소의 값을 가져오고자 할 때에는 onChange 이벤트의 .target.value로 가져옴
    const onInputHandler = (event: ChangeEvent<HTMLInputElement>) => {
        // 가져온 .target.value 값을 상태에 지저
        setFavorite(event.target.value);
    };

    //! 기억해 두기
    const onAddListHandler = () => {
        // 상태가 배열 혹은 객체이면 각각에 대해 요소에 대해 추가/변경이 일어나도 상태가 변경된 것으로 인식 X (실제 주소가 변경된것이 아니기 때문)
        // 상태가 변경된 것으로 인식하게 하고 싶으면 새로운 배열 혹은 객체를 생성하여 상태를 변경해야 한다 (일반적으로 복사하여 변경)

        // 첫번째 방법
        // // 배열은 참조변수이기에 불러왔을 때 주소를 반환 / 주소 변화 X > 값 변화 X
        // favorites.push(favorite);
        // // 값을 바꾸기 위해서 주소 변경이 필요 > 새로운 배열을 생성
        // const newFavorites = favorites.map((item) => item)
        // setFavorites(newFavorites);

        // 두번째 방법
        //             가지고 있던것 스프레드, 새로운 요소
        setFavorites([...favorites, favorite]);
        setFavorite('');
    };

    return (
        <>
            <button onClick={onCountAddHandler}>+</button>
            <h1>{count}</h1>
            <h1>{total}</h1>
            <hr />
            {/* Input이 만약 상태를 변경한다면 value로 그 상태를 지정해야 불일치가 발생하지 않음  */}
            <input onChange={onInputHandler}  value={favorite}/>
            <button onClick={onAddListHandler}>추가</button>
            <h4>{favorite}</h4>
            <ul>
                {favorites.map((item, index) => <li key={index}>{item}</li>)}
            </ul>
        </>
    )
}

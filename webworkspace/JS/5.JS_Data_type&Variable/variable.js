/*
    변수 : 데이터를 저장하는 공간에 이름을 부여한 것
    - var, let, const 키워드
*/
var varVariable;
let letVariable;
// const = 상수선언 > 반드시 선언 시 초기화 해야함
const constVariable = 10;

/*
    변수의 중복 선언 : var 키워드로 선언한 변수는 중복 선언 가능
*/
var age = 23;
var age = 30;

// let로 선언한 변수는 중복 선언 불가능
let address = '부산시';
// let address = '울산시';

/*
    동적 타이핑 : 변수의 타입이 데이터가 할당된 순간에 데이터의 타입에 따라 결정
*/
var variable = 10;
// console.log(typeof variable);  //number
var variable = '10';
// console.log(typeof variable);  //string

/*
    변수 호이스팅 : var 키워드나 function 키워드로 선언한 변수 혹은 함수에 대해서 scope가 최상위로 옮겨지는 것
    - 선언 단계 : 변수를 등록하는 단계 (스코프가 가능해짐)
    - 초기화 단계 : 변수에 undefined가 할당됨
    - 할당 단계 : undefined에 실제값이 할당됨
*/
// console.log(x);  //undefined
var x =10;
if (true){
    var x = 99;
}
// console.log(x);

/*
    var 키워드로 선언한 변수는 블록 레벨 스코프가 아닌 함수 레벨 스코프를 가짐
    - 함수 레벨 스코프 : 함수 내에서 선언된 변수는 함수 안에서 사용 가능, 함수 밖에서는 사용 불가능                                 //함수 - 파일내, 쓰레드
    - 블록 레벨 스코프 : 코드 블럭 내에서 선언된 변수는 해당 코드블럭내에서 사용 가능 ,코드블럭 밖에서는 사용 불가           //블럭 - {}
*/

/*
    var 키워드로 선언된 변수의 문제점
    1. 함수 레벨 스코프
        - 모든변수가 전역변수로 선언 됨
    2. var키워드 없이도 생성 가능
        - 의도하지 않은 변수 생성
    3. 중복선언 가능
        - 의도하지 않은 변수 변경
    4. 호이스팅
        - 선언 전에 사용 가능

    - 이러한 문제들을 해결하기 위해 ES6+ 부터는 let, const 키워드로 변수선언
*/

// console.log(y);
let y =10;
if(true){
    let y = 99;
}
console.log(y)
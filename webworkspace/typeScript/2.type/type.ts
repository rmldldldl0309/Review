/*
    타입선언 : 
    - 변수 및 함수에 타입을 지정하여 타입에 대한 제한을 추가할 수 있음
*/
let variable: string = '문자열';
// variable = true;     /error

// 매개변수의 타입 : number / 함수의 리턴 값 타입 : string
function func(arg: number): string {
    return arg + ' ';
}

const arrowFunc = (arg:number): string => {
    return arg + ' ';
}

/*
    typescript의 타입
    - string : 문자열
    - number : 숫자
    - boolean : 논리
    - null : null 값
    - undefined : 정의되지 않음
    - object : 참조 타입
    - array : 배열 타입
    - enum : 열거형 타입
    - void : 함수에서 반환값이 없음
    - any : 모든 타입
*/
// array
const numbers1: number[] = [1, 2, 3, 4, 5];
const numbers2: Array<number> = [6, 7, 8, 9, 10];

// enum
enum Color {RED, GREEN, BLUE}
const color1: Color = Color.RED;
// const color2: Color = RED;

// any
let anyV: any = 10;
anyV = "10";

// void
const aFunc = (): void => {};

/*
    타입추론 :
    - 타입을 선언하지 않고 값이 변수에 값이 할당되는 순간에 할당된 값에 따라 변수의 타입이 결정나는 것
*/
let stringVariable = '문자열';  // string
// stringVariable = 10;

/*
    타입 변환 :
    - as 키워드로 형변환 가능 (객체일때 자주사용)
*/
const PI: any = "3.14";
let piNumber:number = PI as number;
piNumber = Number (PI);

/*
    유니온 타입
    - 복수의 타입을 지정하는 방법, |
*/
let union: number|null;
union = 10;
union = null;
// union = '10';

/*
    리터럴 타입
    - 지정한 리터럴 값만 가질 수 있는 타입
*/
let gender: '남' | '여';
gender = '남';
gender = '여';
// gender = '남자';

/*
    객체 : 키(key)와 값(value)로 구성된 속성들의 집힙
    - 메서드를 가질 수 있음
*/

/*
    객체 리터럴 : 자바스크립트에서 가장 일반적 객체 생성 방법
    - {}를 사용하여 객체를 생성
*/
const empthObject = {};
const hongGildong = {
    name: '홍길동',
    ag : 20,
    address: '서울특별시',
    greating : function () {
        console.log(`안녕 난 ${this.name} 이야`);
    }
};

console.log(hongGildong);
console.log(hongGildong.name);
hongGildong.greating();

const name = '고종';
const age = 40;
const address = '서울 특별시';

const  goJong = {
    name,
    age,
    address
};

console.log(goJong);

console.log('==============================');

/*
    Object 생성자 : Object 클래스의 생성자로 빈 객체 생성 가능
*/
const emptyObjectByConstructor = new Object();
console.log(emptyObjectByConstructor);

console.log('==============================');

/*
    생성자 함수 : 생성자 함수를 사용하여 클래스 처럼 사용 가능
*/
function Person (name, age, address) {
    this.name = name,
    this.age = age,
    this.address = address
}
const goGildong = new Person('고길동', 30, '인천광역시')
console.log(goGildong);
console.log(goGildong.name);

console.log('==============================');

/*
    속성 이름 (속성 키) : 
    - 일반적으로 문자열로 표기함
    - 자바스크립트에서 유효한이름(변수 이름으로 사용가능한 이름)일 경우 따옴표 생략 가능
    - 유효한 이름이 아닐 경우 반드시 따옴표를 포함하여 작성
*/
const kimsangheon = {
    'first name' : 'sangheon',
    'last name' : 'kim',
    gender : 'male',
    age : 32,
};

console.log(kimsangheon);

console.log('==============================');

/*
    속성 값 읽기 : 
    - . 표기법 [] 표기법으로 접근가능
    - . : 유효한 이름일 경우
    - [] : 유효한 이름이 아니거나 접근할 속성이 동적으로 변할 경우 ([] 안에 반드시 문자열로 지정)
    - 객체에 존재하지 않는 속성에 접근하면 undefined를 반환
*/
console.log(kimsangheon.age);
console.log(kimsangheon["last name"]);
let property = 'first name';
console.log(kimsangheon[property]);

console.log('==============================');

/*
    속성 값 변경 :
    - 객체 속성에 접근하여 새로운 값을 할당하여 변경 가능
    - 만약 존재하지 않는 속성에 값을 할당하면 새로운 속성이 생성
*/
goJong.name = '이형';
goJong.birth = '1852-09-08';
console.log(goJong);

console.log('==============================');

/*
    속성 삭제 :
    - delete 연산자를 사용하여 객체 속성 제거
*/
delete goJong.birth;
console.log(goJong);

console.log('==============================');

/*
    for-in 문 : 
    - for-in 문으로 객체에 포함되어 있는 key를 순회해서 접근 가능
    - 반환되는 값은 문자열 타입의 키가 반환
*/
for (const key in goJong){
    console.log(`${key} : ${goJong[key]}`);
}

console.log('==============================');

// 주소가 전달
let sunJong = goJong;
sunJong.name = '이척';

console.log(sunJong.name);
console.log(goJong.name);

// 값 복사
sunJong = {
    name : goJong.name,
    age : goJong.age,
    address : goJong.address
}

sunJong = {};
for (const key in goJong) {
    sunJong[key] = goJong[key];
}

console.log(sunJong);

sunJong = {};
console.log(sunJong);

// name, age, address
sunJong = {...goJong};
console.log(sunJong);

goJong.name = '이형';
console.log(goJong.name);
console.log(sunJong.name);
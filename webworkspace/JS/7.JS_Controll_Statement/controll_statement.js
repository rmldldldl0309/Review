/*
    if else 문
    - 조건식이 true일 경우 if 코드블럭을 실행, false 인 경우 else 코드블럭 실행
    - 조건식 위치에 논리 값을 반환하는 표현식이 아니더라도 사용 가능
*/
let age = 10;
if (age > 19) console.log('성인')
else console.log('미성년자')

console.log('==============================');

let number = 10;
let kind = '';
if (number % 3) kind = '3의 배수 X'
else kind = '3의 배수'

console.log('==============================');

/*
    - if else 문을 삼항 연산자로 변환하여 사용 가능하다
*/

kind = number % 3 ? '3의 배수 X' : '3의 배수';

console.log('==============================');

/*
    switch 문
    - 표현식을 비교하여 값이 표현식과 일치하면 해당하는 case문으로 실행 순서를 옮김
    - 표현식과 일치하는 case가 존재하지 않으면 defalut문으로 이동
    - break를 지정하지 않으면 맨 끝까지 진행
*/
const weekNumber = 3;
let weekString = '';
switch (weekNumber){
    case 0: weekString += '일요일';
        break;
    case 1: weekString += '월요일';
        break;
    case 2: weekString += '화요일';
        break;
    case 3: weekString += '수요일';
        break;
    case 4: weekString += '목요일';
        break;
    case 5: weekString += '금요일';
        break;
    default : weekString += '토요일';
}
console.log(weekString);

console.log('==============================');

/*
    for 반복문
    - 반복할 횟수가 정해져 있을 때 사용하는 반복문
*/
const dan = 3;
for (let count = 1; count <= 9; count ++){
    console.log(`${dan} * ${count} = ${dan*count}`)
}

console.log('==============================');

/*
    while 반복문
    - 횟수가 지정되어 있지 않을 때 사용하는 반복문
*/
let randomNum = Math.random();
console.log(randomNum);
while (randomNum > 0.5){
    randomNum = Math.random();
    console.log(randomNum);
}

console.log('==============================');

/*
    do-while 반복문
    - 반복할 코드 블럭은 한번은 반드시 실행하고 조건을 확인
*/
let randomNum2 = 0;
do{
    randomNum2 = Math.random();
    console.log(randomNum2);
}while(randomNum2 > 0.5)

console.log('==============================');

/*
    break 문 
    - switch문이나 반복문에서 코드 블록을 강제로 탈출할 때 사용
*/
let count = 0;
while (true){
    if (count === 5) break;
    console.log(count ++)
}

console.log('==============================');

/*
    continue 문
    - 반복문의 진행 위치를 맨 마지막으로 이동
*/
count = 0;
while (true){
    if (count === 10) break;
    if (count % 2 === 0) {
        count ++;
        continue;
    }
    console.log(count++);
}
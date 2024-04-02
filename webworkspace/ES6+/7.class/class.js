/*
    클래스 정의 : class 키워드를 사용하여 선언
    - constructor를 이용해서 멤버 변수를 선언 및 초기화를 할 수 있다
    - 생성자에서 this를 이용해서 멤버 변수를 지정
    - new 연산자를 통해서 인스턴스를 생성할 수 있다
*/
// 왕 클래스 : 이름 / 묘명 / 생일 / 사망일
class King {
    constructor () {
        this.name = "이성계";
        this.tombName = "태조"
        this.birth = "1335-11-04";
        this.death = "1408-06-27"
    }
}
const taejo = new King();
console.log(taejo);

console.log('==================================================');

/*
    constructor: 
    - 인스턴스를 생성하고 클래스 필드를 초기화하기 위한 용도로 사용되는 특수한 메서드 (생성자)
    - 생성자 안에서 this 키워드를 이용해서 클래스의 멤버 변수를 선언하고 초기화 할 수 있음
    - 생성자의 매개변수로 각 속성의 값을 받아서 초기화
    - 자바스크립트의 새성자는 오버로드가 되지 않음
*/
class King2 {
    // constructor () {}

    constructor (name, tombName, birth, death) {
        this.name = name;
        this.tombName = tombName;
        this.birth = birth;
        this.death = death;
    }
}

const junjong = new King2('이방과', '정종', '1357-07-26', '1419-10-24');
console.log(junjong);       // 컨스트럭터 2개라 에러


console.log('==================================================');

/*
    클래스의 필드 선언 : ES6+의 클래스가 가질 수 있는 제어자
    - 퍼블릭 필드
    - 프라이빗 필드
    - 정적(static) 퍼블릭 필드
    - 정적 필드 프라이빗 필드
*/ 
class Sample1 {
    publicField;
    #privateField;
    static  staticPublicField  = "정적 퍼블릭 필드";   
    static  staticPrivateField = "정적 프라이빗 필드";

    constructor (publicField, privateField) {
        this.publicField = publicField;
        this.#privateField = privateField;
        // this.staticPublicField = publicField;
        // this.staticPrivateField = privateField;
    }
}
const sample1Instance = new Sample1('퍼블릭 필드', ' 프라이빗 필드')
console.log(sample1Instance);
// console.log(sample1Instance.#privateField);
// console.log(sample1Instance.#staticPublicField);
console.log(Sample1.staticPublicField)

console.log('==================================================');

/*
    getter, setter : 
    - getter : 프라이빗 멤버 변수의 값을 얻을 수 있는 캡슐화 메서드
    - setter : 프라이빗 멤버 변수의 값을 할당할 수 있는 캡슐화 메서드
*/
class Sample2 {
    #privateField;

    constructor (privateField) {
        this.#privateField = privateField;
    }

    get privateField() {
        return this.#privateField;
    }

    set privateField(privateField) {
        return this.#privateField = privateField;
    }
}
const sample2Instance = new Sample2("프라이빗 필드");
console.log(sample2Instance.privateField);
sample2Instance.privateField = "변경 프라이빗 필드";
console.log(sample2Instance.privateField);

console.log('==================================================');

/*
    인스턴스 메서드와 정적 메서드 : 
    - 클래스 내부에 function 키워드를 제거한 함수를 작성하여 인스턴스 메서드 선언 가능
    - static 키워드를 추가하여 정적 메서드 선언 가능ㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑㅑ
*/
class Sample3 {
    instanceMethod () {
        console.log('인스턴스 메서드');
    }

    static staticMethod () {
        console.log ("정적 메서드");
    }
}

const sample3Instance = new Sample3();
sample3Instance.instanceMethod();
Sample3.staticMethod();

console.log('==================================================');

/*
    클래스 상속 : 
    - extends 키워드를 통하여 상속이 거능
    - 메서드 오버라이딩 가능
    - super 키워드로 부모 크래스를 참조할 수 있음
*/
class PatentClass {
    parentField;

    constructor (parentField) {
        this.parentField = parentField;
    }

    parentField() {
        console.log("부모 메서드");
    }
}

class ChildClass extends PatentClass {
    child1Field;
    constructor () {
        // 반드시 해줘야함
        super("부모 필드");
        this.child1Field = '자식1 필드';
    }

    child1Metohd() {
        console.log("자식 1 메서드");
    }
}

class ChildClass2 extends ParemtC {
    child2Field;

    constructor () {
        super('부모 필드')
        this.child2Field= "자식 필드"
    }

    parentMethod () {
        console.log("자식 메서드");
    }
}

const child1Instence = new ChildClass();
console.log(child1Instence.parentField);
console.log(child1Instence.child1Field);
child1Instence.parentMethod();
child1Instence.child1Metohd();

const child2Instence = new ChildClass2();
console.log(child1Instence.parentField);
console.log(child1Instence.child1Field);
child2Instence.parentMethod();

package practice2;

// 오버라이딩: 하위 클래스에서 상위 클래스의 메서드를 재정의 하는 것
// 규칙
// 1. 상위 클래스에서 선언된 메서드와 메서드 이름, 매개변수의 조합이 같아야함
// 2. 상위 클래스에서 선언되 메서드가 final 로 선언되었다면 재정의 불가능
// 3. 상위 클래스에서 선언된 메서드보다 좁은 범위의 접근제어 불가
// 장점
// 1. 코드의 일관성과 가독성을 향상
// 2. 다형성 지원으로 코드의 확장성을 향상


class SuperClass{
	
	int superInstance;
	
	SuperClass (int superInstance){
		this.superInstance = superInstance;
	}
	
	void instanceMethod() {
		System.out.println("부모 클래스의 메서드");
	}
}

class SubClass1 extends SuperClass{
	
	// 부모 클래스에 생성자가 존재하므로 반드시 자식 클래스에도 생성자가 존재해야함
	SubClass1() {
		super(10);
	}
	
	void instanceMethod(String string) {
		System.out.println(string);
	}

}

class SubClass2 extends SuperClass{
	
	SubClass2(int superInstance){
		super(superInstance);
	}
	
	@Override
	void instanceMethod() {
		super.instanceMethod();
		System.out.println("Sub2의 인스턴스 메서드 입니다.");
	}
	
	
}

public class C_Overriding {

	public static void main(String[] args) {
;
		SuperClass instance1 = new SuperClass(0);
		SubClass1 instance2 = new SubClass1();
		SubClass2 instance3 = new SubClass2(50);
		
		instance3.instanceMethod();
		
		System.out.println(instance1.superInstance);
		System.out.println(instance2.superInstance);
		System.out.println(instance3.superInstance);
		
	}

}

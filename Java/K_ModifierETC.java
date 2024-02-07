package practice2;

// ###### 기타 제어접근자 ######

// ## ▶ final
// - final 클래스: 확장(상속)불가
// - final 메서드: 오버라이드 불가
// - final 변수: 재할당 불가 (상수)

final class FinalClass{
	
}

// class FinalSub extends FinalClass{
//												> final 클래스는 확장 불가
// }

class FinalExample1{
	final void finalMethod(int a) {		
	}
}

class FinalExample1Sub extends FinalExample1{
	// void finalMethod(int a) {
	// 											> final 메서드는 오버라이드 불가	
	// }
}

class FinalExample2{
	final int VARIABLE = 1;
	
	void finalVariable() {
		// VARIABLE = 20;						> final 변수는 재할당 불가능
	}
}

// ---------------------------------------------------------------------------------
//## ▶ static
// - 메서드: 인스턴스 생성없이 클래스로 바로 호출 가능, 인스턴스로도 호출가능
// - 변수: 인스턴스 생성없이 클래스로 바로 호출 가능, 인스턴스로도 호출가능

class StaticClass{
	static void staticMethod() {
		System.out.println("정적메서드");
	}
}

class Example{
	static int variable = 100;
}


public class D_ModifierETC {

	public static void main(String[] args) {
		
		StaticClass.staticMethod();							// > 클래스로 직접 호출
		StaticClass instance1 = new StaticClass();
		instance1.staticMethod();							// > 인스턴스로도 호출 가능
		
		System.out.println(Example.variable);				// > 클래스로 직접 호출
		Example instance2 = new Example();
		System.out.println(instance2.variable);				// > 인스턴스로도 호출 가능
	}

}

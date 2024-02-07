package practice2;

// 접근제어자: 클래스, 필드, 메서드에 대해서 외부 접근에 대한 제어를 하는 것
// private: 같은 클래서 내에서만 접근 가능
// default: 같은 패키지 내에서만 접근 가능
// protected: 같은 패키지 내부 혹은 외부 패키지의 자손 클래스에서만 접근 가능
// public: 모든 패키지에서 접근 가능

class AccessModifier{
	
	void method() {
		D_AccessModifier instance = new D_AccessModifier();
		// instance.privateVariable;    							// private = 외부클래스에서 접근 불가능
		
	}
}

public class D_AccessModifier {
	
	private int privateVariable;
	int defaultVariable;
	protected int protectedVariable;
	public int publicVariable;
	
	void method() {
		this.privateVariable = 0;									// private = 같은 클래스 안에서는 접근 가능
	}
	
}

package practice2;

// ##### 다형성 #####
// 하나의 표현을 여러가지 형태로 나타낼 수 있는 것

// 오버로드: 같은 클래스 내에서 이름이 같은 메서드를 여러개 정의할 수 있게 하는 
// 오버라이딩: 자손 클래스에서 부모 클래스에 정의된 메서드를 재정의 하는 것

class Human{
	String name;
	int age;
}

class Chef extends Human{
	String Position;
}

interface FootballPlayers{
	public abstract void kick();
}

class FootbalPlayer extends Human implements FootballPlayers{
	int goal;
	
	@Override
	public void kick() {}
	
}

public class H_Polymorphism {

	public static void main(String[] args) {

		Human human = new Human();
		Chef chef = new Chef();
		FootbalPlayer player = new FootbalPlayer();
		
		// ## 클래스의 형변환 ##	
		// 업캐스팅: 하위 클래스의 객체를 상위 클래스의 참조변수에 담을 수 있도록 하는 것
		Human human2 = new Chef();
		Human human3 = new FootbalPlayer();
		
		FootbalPlayer football = new FootbalPlayer();
		
		// 다운캐스팅: 업캐스팅으로 인해 상위 클래스에 담긴 하위 클래스의 객체를 다시 돌려 놓는 것
		Chef chef1 = (Chef) human2;
		FootbalPlayer player1 = (FootbalPlayer) human3;
		
		FootbalPlayer player2 = (FootbalPlayer) football;
		
		// Object 클래스 > 가장 최상위에 있는 클래스 > 어떤 클래스도 다 받을 수 있음
		Object object1 = new Human();
		Object object2 = new Chef();
		Object object3 = new FootbalPlayer();
		
		
	}

}

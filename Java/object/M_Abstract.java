package practice2;

// ##### 추상화 #####
// ## 추상 클래스: 추상 메서드를 포함할 수 있는 클래스
// 추상 클래스 자체로 인스턴스를 생성할 수 없다. 반드시 추상 클래스를 상속한 하위 클래스를 통해 인스턴스를 생성
// abstract class 클래스명	{}

// ## 추상 메서드: 선언부만 존재하고 구현부는 존재하지 않는 메서드
// 반드시 추상 클래스를 상속 받은 하위 클래스에 오버라이딩해서 구현해야 한다
// abstract 반환타입 메서드명 (매개변수) {}


abstract class Player{
	String name;
	String species;
	String gender;
	double experience;
	
	Player(String name, String species, String gender, double experience) {
		this.name = name;
		this.species = species;
		this.gender = gender;
		this.experience = experience;
	}
	
	abstract double hunt(int figure);
}

class Dealer extends Player{
	
	Dealer(String name, String species, String gender, double experience) {
		super(name, species, gender, experience);
	}

	@Override
	double hunt(int figure) {					// 추상메서드는 반드시 하위 클래스에서 오버라이드해야한다
		System.out.println(figure + "만큼의 공격을 했습니다.");
		this.experience += (figure * 0.8);
		return experience;
	}
	
}

public class F_Abstract {

	public static void main(String[] args) {
		
		// Player instance = new Player();  > 추상화 클래스는 자체적으로 인스턴스를 생성할 수 없다
		
		// 추상 클래스의 하위클래스를 통해 인스턴스를 생성 
		Dealer instance = new Dealer("ksh", "인간", "남성", 50000);


	}

}

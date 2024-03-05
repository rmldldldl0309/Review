package practice2;

// 상속 ( Super class > Sub class )
// : 원래 존재하던 클래스를 확장하여 재사용할 수 있도록 하는 것 / 코드 중복을 제거하고 확장성을 높일 수 있음
// : 모든 클래스는 Object 라는 최상위 클래스를 반드시 상속하고 있음
// : Java 는 다이아몬드 문제를 방지하기 위해 단일 상속만을 지원한다

// 다이아문제: 다중 상속을 했을 때 발생할 수 있는 메서드 호출의 모호성(어떤 메소드를 불러와야할지 모호)

// : extends 키워드를 이용하여 확장

class Mechine{
	String name;
	int yearOfProduct;
	
	Mechine(String name, int yearOfProduct) {
		System.out.println(name + "의 제작년도는 " + yearOfProduct + "입니다");
	}

	void operation(String name) {
		System.out.println(name + "이 작동합니다");
	}
	
}

// super / super()
// : 부모의 메서드를 호출하는 경우 super.메서드명, 부모의 생성자를 호출하는 경우 super()

class TV extends Mechine{
	String location;
	
	TV(String name, int yearOfProduct){
		super("TV", 2015);
	}	
	
	void tv() {
		System.out.println(location + "에있는 " + name + "가 작동합니다");
	}
}

class Computer extends Mechine{
	String location;
	
	Computer(String name, int yearOfProduct){
		super("컴퓨터", 2018);
	}
	
	void computer() {
		System.out.println(location + "에있는 " + name + "가 작동합니다");
	}
} 

class SmartPhone extends Mechine{
	
	SmartPhone(String name , int yearOfProduct) {
		super("스마트폰", 2023);
	}

	void operation(String name) {
		super.operation("스마트폰");
	}
}

public class B_Inheritance {

	public static void main(String[] args) {

		Mechine mechine = new Mechine("기계" ,0);
		mechine.name = "기계";
		mechine.operation("기계");
		
		TV television = new TV("TV", 2023);
		television.name = "텔레비젼";
		television.location = "거실";
		television.tv();
		
		Computer computer = new Computer("컴퓨터", 2016);
		computer.name = "컴퓨터";
		computer.location = "안방";
		computer.computer();
		
		SmartPhone smartphone = new SmartPhone("휴대폰", 2018);
		smartphone.operation("");		
	}

}
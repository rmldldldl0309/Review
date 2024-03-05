package practice2;

// ##### 인터페이스 #####
// 클래스가 구현해야만 하는 메서드들을 선언하는 참조 타입
// 인터페이스의 모든 변수는 private static final 형태가 와야한다
// 인터페이스의 모든 메서드는 public abstract 형태가 와야한다 (default 나 public 형태가 올 수도 있다)
// 인터페이스는 다중구현이 가능하다

// 접근제어자 interface 인터페이스명{...}

// ----------------------------------------------------------
// 넗이 공식
// 삼각형 > double bottom, double height, double triangleArea
// 정사각형 > double area, double squareArea
// 원형  > double radius, double pi, double circleArea

interface AreaCalculation{
	public static final double PI = 3.14;
	
	public abstract double triangleArea(double bottom, double height);
	public abstract double squareArea(double area);
	public abstract double circleArea(double radius);
}

class Calculation implements AreaCalculation{

	@Override
	public double triangleArea(double bottom, double height) {
		return (bottom*height)/2;
	}

	@Override
	public double squareArea(double area) {
		return Math.pow(area, 2);
	}

	@Override
	public double circleArea(double radius) {	
		return Math.pow(radius, 2)*PI;
	}
	
}



public class G_Interface {

	public static void main(String[] args) {
	
		AreaCalculation instance = new Calculation();
		
	}

}

package practice2;

// ##### 캡슐화 #####
// : 멤버 변수(속성)와 메서드를 묶어서 변수에 대한 조작을 메서드를 통해서만 할 수 있도록 하는 것
// > 정보 은닉 및 데이터 보호 / 데이터의 무결성을 보장할 수 있다

class FootballPlayer{
	private String name;					// getter, setter 는 private 와 묶어 사용함으로써 무결성을 보장
	private String team;
	private String position;
	private int goal;
	
	FootballPlayer(){}

	FootballPlayer(String name, String team, String position, int goal){
		this.name = name;
		this.team = team;
		this.position = position;
		this.goal = goal;
	}
	
	String getName() {							   // getter - setter메서드로 값 저장한거 불러오는 용도
		return this.name;
	}
	
	void setName(String name) {                    // setter - 저장하기 전에 검증
		this.name = name;
	}
	
	String getTeam() {
		return this.team;
	}
	
	void setTeam(String team) {                   
		this.team = team;
	}
	
	String getPosition() {
		return this.position;
	}
		
	int getGoal() {								   
		return this.goal;							
	}
	
	void setGoal(int goal) {                    
		this.goal = goal;
	}
	
}

public class E_Encapsulation {

	public static void main(String[] args) {
		// 매개변수 setter 되있는 항목 중 하나라도 입력하지 않으면 오류
		FootballPlayer kane = new FootballPlayer("해리 케인", "바이에른 뮌헨", "ST", 30);
		System.out.println(kane.getGoal());
		System.out.println(kane.getPosition());
	}

}

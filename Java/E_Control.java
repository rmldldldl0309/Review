package practice;

import java.util.Scanner;

public class E_Control {

	public static void main(String[] args) {
		
		// ========== 제어문 ==========
		// 제어문: 조건에 따라 코드의 흐름을 결정
		
		// 조건문: 특정 조건이 만족하면 코드를 실행, 만족하지 않으면 실행하지 않는다
		
		// -- ▶ if: 주어진 조건이 true 면 코드 실행

		// if (조건 - 논리 표현식) {실행할 코드}
		
		int age = 24;
		boolean isHighSchool = age >= 17 && age <= 19;
		if (!isHighSchool) {System.out.println("고등학생이 아닙니다.");}
		
		// -- ▶ else: if 문의 조건 - 논리 표현식이 false일 경우 코드를 실행
		// if (조건 - 논리 표현식) {true면 실행할 코드}
		// else {false면 실행할 코드}
		
		// else문은 반드시 if문 뒤에 존재해야한다
		// else문에는 조건 식을 작성하지 않는다
		
		age = 17;
		if (age > 19) {
			System.out.println("성인");
		}else {
			System.out.println("미성년자");
		}
		
		// ---------------------------------------------------------
		// -- ▶ switch: 특정 변수 또는 값에 따라 실행할 코드 블록의 범위를 결정하는 것
		// switch(변수 - 일반 표현식){
		// case 값1:
		//		변수 - 일반표현식이 값 1과 같을 경우 시작할 코드 위치 
		// case 값2:
		//		변수 - 일반표현식이 값 2과 같을 경우 시작할 코드 위치
		//		break;  											>만나면 switch문 종료
		// case 값3:
		//		변수 - 일반표현식이 값 3과 같을 경우 시작할 코드 위치
		// default:
		// 		변수 - 일반표현식이 case의 값들과 일치하지 않거나 바로 위에서 
		//			  break문을 만나지 않으면 실행되는 코드
		// }	
		
		int input = 5;
		// input이 0이면 A를 출력
		// input이 1이면 B
		// input이 2이면 CD
		// input이 3이면 D
		// input이 4이면 EF
		// input이 0-4가 아니면 F
		
		switch(input) {
		case 0: 
			System.out.println("A");
			break;
		case 1: 
			System.out.println("B");
			break;
		case 2: 
			System.out.println("C");
		case 3: 
			System.out.println("D");
			break;
		case 4: 
			System.out.println("E");
		default:
			System.out.println("F");
		}
		
		// ========== 반복문 ==========
		// 반복문: 특정 조건에 부합하면 지정한 코드를 여러번 실행
		
		// -- ▶ for: 반복 횟수가 정해져 있을때 사용하는 반복문
		// for (조건에 사용할 변수 초기화; 조건; 조건에 사용할 변수 증강) {반복할 코드}	
		
		for (int i = 0; i < 3; i++) {
			System.out.println("안녕하세요");
		}
		
		// -- ▶ foreach: 컬렉션(배열)의 각 요소를 하나씩 변수에 복사하여 사용하는 반복문
		
		int[] numbers = new int[5];
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 3;
		numbers[3] = 4;
		numbers[4] = 5;
		
		for (int index = 0; index < numbers.length; index++) {
			System.out.println(numbers[index]);
		}
		
		System.out.println("--------------------------------------------------");
		
		for (int number: numbers) {
			System.out.println(number);
		}
		// 위의 식은 일반적인 for문 아래쪽은 foreach문
		
		// ---------------------------------------------------------
		// -- ▶ while: 반복할 횟수가 정해져있지 않을 때 사용하는 반복문
		// - 조건이 true인 동안 반복, 조건이 false가 되면 종료
		
		Scanner sc = new Scanner(System.in);
		input = 1;
		
		while (input != 0) {
			input = sc.nextInt();
			if (input % 2 != 0) {
				// 반복문에서 continue문을 만나면 조건 검사로 넘어감
				continue;
			}
			if (input % 2 == 0) {
				// 반복문에서 break문을 만나면 반복문을 종료
				break;
			}
			System.out.println("입력값 : " + input);
			System.out.println("while 반복문 실행중...");
		}
		System.out.println("반복문 종료");

	}

}

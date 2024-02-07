package practice;

import java.util.Scanner;

public class D_Operator {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 3;
		double c = 10.0;
		double d = 3.0;
		
		int intResult;
		double doubleResult;
			
		// ========== 연산자 ==========
		// - ▶ 산술연산자: 사칙연산
		
		// -- 더하기(+)
		intResult = a + b;					
		System.out.println(intResult);
		
		doubleResult = a + b;		// 자동 형변환
		intResult = (int)(c + d);	// 강제 형변환
		
		// -- 빼기(-)
		intResult = a - b;
		System.out.println(intResult);
		
		// -- 곱하기(*)
		doubleResult = c*d;
		System.out.println(doubleResult);
		
		// -- 나누기(/)
		intResult = a / b;
		System.out.println(intResult);
		doubleResult = c / d;
		System.out.println(doubleResult);
		doubleResult = a / d;
		System.out.println(doubleResult);
		// 정수 나누기 정수의 결과 값에서 실수부는 버려진다
		
		// -- 나머지(%)
		intResult = a % b;
		System.out.println(intResult);
		
		// -------------------------------------
		// - ▶ 증감 연산자: 피연산자의 값을 1씩 증가 또는 감소
		// 증가 연산자 = ++ / 감소 연산자 = --
		// 연산자의 위치에 따라 결과가 달라질 수 있다
		System.out.println(++a);
		
		// -------------------------------------
		// - ▶ 대입 연산자: 좌항에 우항을 할당
		// = : 좌항에 우항을 할당
		// += : 좌항에 우항을 더한 결과값을 대입
		// -= : 좌항에 우항을 뺀 결과값을 대입
		// *= : 좌항에 우항을 곱한 결과값을 대입
		// /= : 좌항에 우항을 나눈 몫을 대입
		// %= : 좌항에 우항을 나눈 나머지값을 대입
		
		// -------------------------------------
		// - ▶ 관계 연산자: 좌항과 우항을 비교하고 그 결과를 논리값으로 변환
		// >(크다), >=(크거나 같다), <(작다), <=(작거나 같다)
		// == : 좌항과 우항이 같으면 true, 다르면 false
		// != : 좌항과 우항이 다르면 true, 같으면 false
		
		// -------------------------------------
		// - ▶ 논리 연산자: 피연산자가 모두 논리형태로 논리 값을 조합
		// && : AND연산, 좌항과 우항이 모두 true 일때만 true
		// || : OR연산, 좌항과 우항 둘 중 하나라도 true 면 true
		
		// -------------------------------------
		// - ▶ 삼항 연산자: 간단한 조건에 따라 결과를 반환하는 연산자
		// 조건(논리식) ? 참일때결과 : 거짓일때결과
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하시오 : ");
		
		int age = sc.nextInt();
		
		String stringResult = ( age > 19 ? "성인" : "미성년자" );
		System.out.println(stringResult);	
		
		

}

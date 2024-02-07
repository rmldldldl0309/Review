package practice;

public class B_DataType {

	public static void main(String[] args) {
		
		// ========== 기본형 데이터 타입 ==========
		// ▶ 정수형
		
		// 1. byte형
		// : 1byte(8bit)의 크기를 가지는 정수형 데이터 타입
		// -128 ~ 127
		byte num1 = 124;
		
		// 2. short형
		// : 2byte(16bit)의 크기를 가지는 정수형 데이터 타입
		// -32,768 ~ 32,767 
		short num2 = 32767;
		
		// 3. int형
		// : 4byte(32bit)의 크기를 가지는 정수형 데이터 타입
		// -2,147,483,648 ~ 2,147,483,647
		int num3 = 2147483647;
		
		// 4. long형
		// : 8byte(64bit)의 크기를 가지는 정수형 데이터 타입
		long num4 = 2_147_483_648L;
		
		// + 값 초기화 할때 가독성을 위해 숫자 사이에 _를 넣을 수 있다
		
		//----------------------------------------------
		// ▶ 실수형
		
		// 1. float
		// : 4byte(32bit)의 크기를 가지는 실수형 데이터 타입
		// : 소수점 7자리까지 표현 
		float num5 = 3.1_415_926f;
		
		// 2. double
		// : 8byte(64bit)의 크기를 가지는 실수형 데이터 타입
		// : 소수점 15자리까지 표현
		double num6 = 1.2345678910111213;
		
		//----------------------------------------------
		// ▶ 문자형: 문자 하나를 저장할 수 있는 데이터 타입
		
		// char
		// : 2byte(16bit)의 크기를 가지는 문자형 데이터 타입 / 0~65535
		char char1 = 'A';
		char char2 = 65;    // 숫자가 들어가는 경우 아스키 코드로 변환
		
		//----------------------------------------------
		// ▶ 논리형: 참과 거짓 값을 가지는 데이터 타입
		
		// boolean: 1byte(8bit)의 크기를 가지는 논리형 데이터 타입
		boolean boolean1 = true;
		boolean boolean2 = false;
		
		// ========== 참조형 데이터 타입 ==========
		// ▶ String
		// : 문자열을 표현하는데 사용하는 참조형 데이터 타입
		// : 문자열을 다루기 위한 여러가지 기능들을 제공
		// : 주소를 참조하는 값을 저장해서 참조 자료형이라 부름
		String hi = "안녕하세요";
		
		// ▶ String 의 주요기능
		// 1. 문자열 결합
		// + 나 concat(문자열)으로 두 문자열 연결 가능
		System.out.println(hi + "!!");
		System.out.println(hi.concat("!!"));
		
		// 2. 문자열 비교
		// equals(문자열): 두 문자열이 동일한지 비교
		// compareTo(문자열): 두 문자열을 사전순으로 비교
		// compareToIgnoreCase(문자열): 대소문자 구분없이 사전순으로 비교
		System.out.println(hi.equals("hello"));
		System.out.println(hi.compareToIgnoreCase("apple"));
		
		// 3. 문자열 길이
		// length(): 문자열의 길이를 반환
		System.out.println("Hello, my name is Kim Sangheon".length());
		
		// 4. 문자열 변환
		// toUpperCase(): 모든 문자를 대문자로 변환
		// toLowerCase(): 모든 문자를 소문자로 변환
		System.out.println("HeLlO".toUpperCase());
		System.out.println("HeLlO".toLowerCase());
		
		// 5. 문자열 찾기
		// indexOf(문자열): 찾고자 하는 문자열을 처음 찾은 위치의 인덱스 번호를 반환
		// lastIndexOf(문자열): 찾고자하는 문자열을 마지막으로 찾은 위치의 인덱스 번호를 반환
		String str = "Hello, my name is Kim Sangheon";
		System.out.println(str.indexOf(","));
		System.out.println(str.lastIndexOf(" "));
		
		// 6. 부분 문자열
		// substring(시작인덱스), substring(시작인덱스, 종료인덱스): 문자열을 원하는 크기만큼 추출
		System.out.println(str.substring(7));
		System.out.println(str.substring(7, 9));
		
		// ========== 형변환 ==========
		// ▶ 형변환: 데이터 타입이 서로 다른 변수를 옮겨 담는 것
		
		// - 자동 형변환(묵시적 형변환): 작은 데이터 타입의 변수를 큰 데이터 타입의 변수로 옮겨 담을 때 발생
		int num7 = 100;
		double num8 = num7;
		
		// - 강제 형변환(명시적 형변환)
		// : 큰 데이터 타입의 변수를 작은 데이터 타입의 변수로 옮겨 담을 때 발생
		// : 할당하고자 하는 큰 데이터 타입 변수 앞에 (작은 데이터 타입)을 붙여줌
		num7 = (int)num8;
		
	}

}

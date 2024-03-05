package practice;

import java.util.Arrays;

public class C_Array {

	public static void main(String[] args) {
		
		// # 배열: 동일한 타입의 변수를 여러개 저장할 수 있는 저장 공간(= 자료 구조)
		// : new 연산자를 이용하여 생성
		// : 한번 생성된 배열의 크기는 변경할 수 없다
		
		// 선언: 데이터타입[] 변수명(배열명);
		int[] numbers;
		// 생성: 변수명 = new 데이터타입[크기]
		numbers = new int[5];
		System.out.println(numbers);
		
		int[] numbers2 = new int[5];
		int[] numbers3 = {1, 2, 3, 4, 5};
		int[] numbers4 = new int[] {6, 7, 8, 9, 10};
		System.out.println(numbers2); // [I@372f7a8d 
		System.out.println(numbers3); // [I@2f92e0f4
		System.out.println(numbers4); // [I@28a418fc
		// 주소 값을 저장하고 있다
		
		// 배열의 요소에 접근할때는 '인덱스'를 이용
		// 인덱스 번호는 0 ~ 배열 길이 - 1 
		System.out.println(numbers3[2]);  // 3
		System.out.println(numbers4[4]);  // 10
		
		// -----------------------------------------------
		numbers[1] = 90;  // 0 90 0 0 0
		numbers2[0] = 99; // 99 0 0 0 0
		System.out.println(numbers);  // [I@cb0ed20
		
		numbers2 = numbers;
		System.out.println(numbers2); // [I@cb0ed20  >  주소값이 복사되었다
		
		numbers[4] = 100;  
		// numbers = 0 90 0 0 100
		// numbers2 = 0 90 0 0 100    >  주소가 복사되었기 때문
		
		// -----------------------------------------------
		char[] fruit = {'a', 'p', 'p', 'l', 'e'};
		System.out.println(fruit);
		// > 문자로 이루어진 배열을 출력하면 숫자형과 달리 문자를 그대로 출력해준다

		// -----------------------------------------------
		// # 배열 함수 & 복사
		int[] arr = {1, 3, 5, 1, 7, 2, 8, 10};
		
		// 1. Array.ToString()
		System.out.println(Arrays.toString(arr));
		// > 배열을 하나의 문자열로 출력
		
		// 2. Array.sort()
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		// > 배열을 오름차 순으로 정렬		
		
		// 3. 배열의 복사
		// - 얕은 복사: 두 개의 배열이 하나의 공간을 바라봄, 하나 수정하면 다른 한쪽도 수정
		int[] arr1 = {1, 2, 3};
		int[] arr2 = arr1;		// 배열의 얕은 복사
		System.out.println(arr1);  // [I@8e24743
		System.out.println(arr2);  // [I@8e24743
		
		// - 깊은 복사: 두 배열이 서로 다른 공간을 가지고 있음, 한쪽 값 수정해도 다른쪽에 영향 X
		int[] arr3 = {3, 1, 4, 5, 10};
		int[] arr4 = Arrays.copyOf(arr3, arr3.length);  // 배열의 깊은 복사
		arr3[0] = 11;
		System.out.println(Arrays.toString(arr3));  // 11 1 4 5 10
		System.out.println(Arrays.toString(arr4));	// 3 1 4 5 10
		
	}

}

package Q4;

import java.util.Scanner;

public class q2 {

	public static void main(String[] args) {

		// 정수를 10개 입력받아 배열에 저장한 후, 배열을 검색하여 3의 배수만 골라 출력하는
//		프로그램을 작성하라. [목적-배열과 반복문 연습] [난이도 하] 
//				정수 10개 입력>>2 44 77 6 8 9 12 88 100 2323 
//				6 9 12
		Scanner sc = new Scanner(System.in);
//		int배열을 생성
		int[] arr = new int[10];
		int oddCount = 0;
		System.out.println("정수를 10개 입력 하시오");
//		int 배열에 10개의 데이터를 저장하는 반복문
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
//		배열의 데이터 중에 3의 배수만 출력하는 반복문
		for (int num : arr) {
			if (num % 3 == 0) {
				oddCount++;
				System.out.print(num + " ");
			}
		}
		System.out.println("3의 배수 는 총 " + oddCount + "개");

		int[] intArr = new int[10];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}

		for (int i : intArr) {
			if (i % 3 == 0) {
				System.out.println(i + " ");
			}
		}
	}

}

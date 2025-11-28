package pratice2;

import javax.print.attribute.SetOfIntegerSyntax;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		1. 
//		구구단을 짝수단 만 출력하도록 프로그램을 만들어 보세요. (continue 사용)
		for (int i = 2; i <= 9; i++) {
			if (i % 2 != 0) {
				// 단수에 2를 나누어 나머지가 0이 아니면 continue 를 실행하여 다음 단으로 넘어가게함
				continue;
			}
			// 곱하는 수를 반복하는 for문
			for (int j = 1; j <= 9; j++) {
				System.out.print(i * j + ",");
			}

			System.out.println();
		}
		System.out.println();
//		2.구구단을 단보다 곱하는 수가 작거나 같은 경우까지만 출력하는 프로그램
//		을 만들어 보세요. (break 사용)
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j > i) {
					break;
				}
				System.out.print(i * j + ",");
			}
			System.out.println();
		}
//		for (int i = 2; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				System.out.print(i*j+" ");
//				if(i==j) {
//					break;
//				}
//			}
//			System.out.println();}
//		3.반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요
//		 *
//		 **
//		 ***
//		 ****
//		 *****

// 몇줄 출력할지 설정하는 반복문
		for (int i = 1; i <= 5; i++) {
			// 별을 몇개 출력할지 설정하는 반복문 
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
// 한줄을 모두 출력한 후 엔터를 치는 명령어	
			System.out.println();

		
		}
		System.out.println();

//		
//		 4. 반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요
//		 *****
//		 ****
//		 ***
//		 **
//		 *	
//		
		// starEnd : 별을 몇번 출력할지 설정하는 변수
		int starEnd = 5;
		// 몇줄을 출력할지 설정하는 반복문
		for(int i=1; i<=5; i++) {
			//별을 몇개 출력할지 설정하는 반복문 5,4,3,2,1 순서로 실행
			for(int j=1; j<=starEnd; j++) {
				System.out.print("*");
			}
//		별 출력횟수를 매 반복마다 1씩 줄여주는 설정
			starEnd--;
			//별을 모두 출력한 후 줄바꿈을 실행하는 설정
			System.out.println();
		}
		for (int x = 5; x >= 1; x--) {
			for (int j = 1; j <= x; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		
//------------위 3,4 번을 합쳐보자 -------------		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int x = 4; x >= 1; x--) {
			for (int j = 1; j <= x; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
}

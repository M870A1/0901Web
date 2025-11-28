package chapter6;

public class Ex04_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// while 반복문 : 몇번 반복할지 정해져 있지 않은 경우 사용하는 반복문
		// int 초기값 = 1;
		// while(조건식) {
		// 증감식;
		// 반복해서 실행할 코드 ;
		// }
		int i = 1;
		while (i <= 5) {
			System.out.print(i + ",");
			i++;
		}
		System.out.println();
		int j = 0;
		while (j < 5) {
			System.out.print(j + ",");
			j++;
		}
		System.out.println();
		// 100에서 110까지 출력하는 while 문 작성하기

		int z = 100;
		while (z <= 110) {
			System.out.print(z + ",");
			z++;
		}
		// 2에서 9까지 출력하는 while 문 작성하기
		System.out.println();
		int y = 2;
		while (y <= 9) {
			System.out.print(y + ",");
			y++;
		}
		// 10에서 1까지 출력하는 while 문 작성하기
		System.out.println();
		int x = 10;
		while (x >= 1) {
			System.out.print(x + ",");
			x--;
		}
		// 5,10,15를 출력하는 while 문 작성하기
		System.out.println();
		int r = 5;
		while (r <= 15) {
			System.out.print(r + ",");
			r += 5;
		}

		
	}

}

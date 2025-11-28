package chapter6;

import java.util.Scanner;

public class Ex01_if1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// if문의 문법
//		if( 조건식 ){
//			조건식이 true 일때 실행할 코드;
//		}else if(조건식) {
//		else if(조건식)의 결과가 true일때 실행할 코드;
//        }else {
//			위의 조건식이 flase일때 실행할 코드;
//		}
//		90이상 A 80점이상 B 70점이상 C 60점 이상 D 60점 미만나머지 E
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요>>");
		int num = sc.nextInt();
		if (num >= 90) {
			System.out.println("A");
		} else if (num >= 80) {
			System.out.println("B");
		} else if (num >= 70) {
			System.out.println("C");
		} else if (num >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}

package chapter5;

import java.util.Scanner;

public class Ex04_Scanner3 {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("국어 수학 영어 점수를 입력해주세요.");
		int kor = sc.nextInt();
		int math = sc.nextInt();
		int eng = sc.nextInt();
		int total = kor + math + eng;
		double avg = total / 3.0;
		System.out.println("저는" + name + "입니다.");
		System.out.println("국영수 총합은 " + total + "점,평균은" + avg + "점 입니다.");
//										String.format("%.2f",avg)문자열 변경하여 소수점 2째 자리까지 
	}

}

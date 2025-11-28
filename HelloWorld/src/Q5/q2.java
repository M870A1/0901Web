package Q5;

import java.util.Scanner;

class Phone {
	private String name, tel; // 멤버 변수 name,tel을 선언,
	// private 접근 제어자를 외부 클래스에서 직접 접근하지 못하도록 설정

	// String 문자열(이름과 전화번호) 을 저장

	public Phone(String name, String tel) { // 생성자
		this.name = name;
		this.tel = tel;
	}// 매개변수로 전달받은 값(name, tel)을 멤버 변수에 저장

	public String getName() {
		return name;
	}// getter 메서드

	public String getTel() {
		return tel;
	}// getter 메서드
}

public class q2 {
	public static void main(String[] args) {
//		다음은 이름(name 필드)과 전화번호(tel 필드)를 가진 Phone 클래스이다.
//		이름과 전화번호를 입력받아 2개의 Phone 객체를 생성하고, 출력하는 main 메소드를 작성하라. 
//		[목적 – 클래스 만들기 연습] [난이도 하] 

		Scanner sc = new Scanner(System.in);
		Phone[] phones = new Phone[2]; // 2배열 크기로 설정
		for (int i = 0; i < phones.length; i++) { // 배열의 크기만큼 반복하라
			System.out.print("이름과 전화번호 입력 >> ");
			String name = sc.next(); // String(문자열) 에 name 값 저장받을공간
			String tel = sc.next(); // String 에 tel 값 저장받을공간
			phones[i] = new Phone(name, tel); // 배열의 i번째 자리에 정보를 저장
		}
		for (Phone i : phones) { // 향상된 for문
			System.out.println(i.getName() + "의 번호" + i.getTel());
		}
	}
}
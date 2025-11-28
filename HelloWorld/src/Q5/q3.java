package Q5;

import java.util.Scanner;

class Rect {
// 가로,세로크기를 저장하는 멤버 변수 두개를 선언
	private int width, height;
	
//	가로,세로 크기를 반드시 설정하여 Rect클래스를 생성하도록 하는 생성자
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
// 가로,세로 크기를 곱하여 넓이를 구하는 getArea메서드
	public int getArea() {
		return width * height;
	}
// getter,setter가 없기 때문에 Rect클래스에서 가로,세로 크기를 출력하거나 변경하는 것은 불가능
}

public class q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Rect[] rectArr = new Rect[4];
		for (int i = 0; i < rectArr.length; i++) {
			System.out.println("너비와 높이 >>"); // 입력 받을 너비와 높이
			int width = sc.nextInt(); // int(숫자) width 값 저장공간
			int height = sc.nextInt();// int(숫자) height 값 저장공간

			// Rect를 만드는 코드
			rectArr[i] = new Rect(width, height); // i 번째 자리에 너비와 높이가 지정된 새로운 사각형 저장
		}
		System.out.println("저장하였습니다...");
//출력 내용
		int sum = 0; // 변수를 0 으로 초기화 - 전체 면적 합을 저장
		for (Rect rect : rectArr) { // 향상된 for문,모든 Rect 객체를 하나씩 꺼내서 rect 변수에 담으며 반복
									// rect 객체의 getArea(width * height) 메서드 를 호출 하여 사각형을 면적을 구함.

			// 각 Rect의 넓이를 더하는 코드
			sum += rect.getArea(); // 구한 면적을 sum 변수에 계속 더해 누적
		}
		System.out.println("사각형 전체의 합은" + sum); // 누적된 sum 값 출력
	}

}

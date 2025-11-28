package Test1;

import java.util.Scanner;

class Circle {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * 3.14;
	}
}

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Circle[] circles = new Circle[4];
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < circles.length; i++) {
			System.out.print((i + 1) + "반지름을 입력하세요: ");
			int radius = scanner.nextInt();
			circles[i] = new Circle(radius);
		}
		double totalArea = 0;
		for (int i = 0; i < circles.length; i++) {
			totalArea += circles[i].getArea();
		}
		System.out.println("저장하였습니다...");
		System.out.println("원의 면적 전체 합은 " + totalArea + "입니다.");

		
	}

}
		
		
//[문제1] 원을 표현하는 다음 Circle 클래스를 활용하여,
//Circle 객체 배열을 생성하고,
//사용자로부터 4개의 반지름을 입력받아 배열에 저장한 뒤, 스케너
//배열을 검색하여 원 면적의 합을 출력하는 main() 메소드를 가진 CircleArray 클래스를 작성하시오.		
//		1 반지름 >> 25
//		2 반지름 >> 4
//		3 반지름 >> 71
//		4 반지름 >> 30
//		저장하였습니다...
//		원의 면적 전체 합은 20667.48

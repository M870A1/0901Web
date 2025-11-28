package Pratice1;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요>>");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println(num1 + "+" + num2 + "은 " + (num1 + num2));
//--------------------------------------------------------------
		System.out.println("몇 층인지 입력하세요>>");
		int floor = sc.nextInt();
		int height = floor * 5;
		System.out.println(height + "m입니다.");
//--------------------------------------------------------------
		System.out.println("x 값을 입력하세요 >>");
		int x = sc.nextInt();
		int y = x * x - 3 * x + 7;
		System.out.println("x=" + x + "y=" + y);
//--------------------------------------------------------------
		Scanner scanner = new Scanner(System.in);
		System.out.print("논리 연산을 입력하세요>>");
		boolean a = scanner.nextBoolean(); // 첫 번째 논리 값 읽기
		String op = scanner.next(); // 논리 연산자(AND 또는 OR)를 문자열로 읽기
		boolean b = scanner.nextBoolean(); // 두 번째 논리 값 읽기
		switch(op){
		 case "AND": case "and": case "&&": case "&":
			 System.out.println(a && b);
			 break;
		 case "OR": case "or": case "||": case "|":
			 System.out.println(a || b);
			 break;
		}
//--------------------------------------------------------------
		System.out.println("돈의 액수를 입력하세요 >>");
		int money = sc.nextInt();
		int fiftythousand = money / 50000;
		money %= 50000;
		int tenthousand = money / 10000;
		money %= 10000;
		int thousand = money / 1000;
		money %= 1000;
		int fivehundred = money / 500;
		money %= 500;
		int hundred = money / 100;
		money %= 100;
		int ten = money / 10;
		money %= 10;
//		int one = money / 1;

		System.out.println("5만원" + fiftythousand + "개" 
							+ "1만원" + tenthousand + "개" 
							+ "1천원" + thousand + "개"
							+ "500원"+ fivehundred + "개"
							+ "100원" + hundred + "개" + 
								"10원" + ten + "개" );
							//+ "1원" + one + "개");
//--------------------------------------------------------------
		System.out.println("학점을 입력하세요 >>");
//		char num = sc.next().charAt(0);
//		if (num == 'A' || num == 'B') {
//			System.out.println("Excellent");
//		} else if (num == 'C' || num == 'D') {
//			System.out.println("Good");
//		} else if (num == 'F') {
//			System.out.println("Bye");
//		} else {
//			System.out.println("A ~ F를 입력하세요");
//		}
		 String str = sc.next();
		switch(str) {
		case "A": case "B":
			System.out.println("Excellent");
			break;
		case "C" :case "D":
			System.out.println("Good");
			break;
		case "F":
			System.out.println("Bye");
			break;
			default :
				System.out.println("A,B,C,D,F,중에 입력해주세요.");
		}
		
//--------------------------------------------------------------
		System.out.println("커피를 주문하세요>>");
		String coffee = sc.next();
		int count = sc.nextInt();

		switch (coffee) {
		case "에스프레소":
			System.out.println(count * 2000 + "원 입니다.");
			break;
		case "아메리카노":
			System.out.println(count * 2500 + "원 입니다.");
			break;
		case "카푸치노":
			System.out.println(count * 3000 + "원 입니다.");
			break;
		case "카페라떼":
			System.out.println(count * 3500 + "원 입니다.");
			break;
		default:
			System.out.println("잘못된 주문 입니다. 에소프레소,아메리카노,카푸치노,카페라떼 중에서 주문 해주세요.");
		}

//		System.out.println("커피를 주문하세요 >>");
//		String coffee = sc.next();
//		int count = sc.nextInt();
//		if(coffee.equals("에소프레소")) {
//			System.out.println(count * 2000 + "원 입니다.");
//		 
//		}else if(coffee.equals("아메리카노")) {
//				System.out.println(count * 2500 + "원 입니다.");		
//		}else if(coffee.equals("카푸치노")) {
//			System.out.println(count * 3000 + "원 입니다.");
//		}else if(coffee.equals("카페라떼")) {
//			System.out.println(count * 3500 + "원 입니다.");	
//		}
//		
		sc.close();
		
	}
	}

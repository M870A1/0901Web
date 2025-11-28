package Q4;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
// 영문 소문자를 하나 입력받고 그 문자보다 알파벳 순위가 낮은 모든 문자를 출력하는
//		프로그램을 작성하라. [목적-2중 중첩 반복문 연습] [난이도 하] 
//				알파벳 한 문자를 입력하세요>>e 
//				abcde  97~101
//				bcde 97~100
//				cde 97~99
//				de 97~98
//				e 97
//				Scanner로 문자를 읽을 때 다음과 같이 하면 된다. 
//				String s = scanner.next(); // 문자열로 읽음 
//				char c = s.charAt(0); // 문자열의 첫 번째 문자 
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳 한 문자를 입력하세요 >> ");
//		String s = sc.next(); // 문자열로 읽음
//		char c = s.charAt(0); // 문자열의 첫 번째 문자
//		for (char i = 'a'; i <= c; i++) {
//			for (char j = 'a'; j <= c; j++)
//				System.out.print(j);
//		}
//		System.out.println();
//		int end = (int) c;
//
//		for (int start = 97; start <= end; start++) {
//			for (int ch = start; ch <= end; ch++) {
//				System.out.print((char) ch);
//			}
//			System.out.println();
//		}
String str = sc.next();
char ch = str.charAt(0);
// 소문자 a 는 97번으로 저장됨, 숫자이기 때문에 반복의 변수로 사용 가능
for(char a='a'; a<=ch; a++) {
for(char num='a'; num<=ch; num++) {
	System.out.print(a);
}
System.out.println();
}
		
		
		
		
		
// c = e = 101
// 반복문으로 97~101까지
// 97 ~ 100 
// 97~99
// 97~98
// 97
	}
}
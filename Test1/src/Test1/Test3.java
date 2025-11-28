package Test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Map<String, Integer> account = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("<< 통장 관리 프로그램입니다. >>");

		while (true) {
			System.out.print("이름과 금액 입력>> ");
			String input = sc.nextLine().trim();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			
			String[] parts = input.split("\\s+");
			String name = parts[0];
			
			int amount = Integer.parseInt(parts[1]);
			account.put(name,
					account.getOrDefault(name, 0)
					+ amount);
//			맵을 반복하여 데이터 출력하는 방식
			for (String key : account.keySet()) {
				System.out.print("(" + key + ">" + account.get(key) + "원)");
			}
			System.out.println();
		}
	}
}

//if(map.containsKey()){
// parts += map.get(name);



//[문제3] 고객의 이름과 통장 잔액을 관리하는 프로그램을 *해시맵*을 이용하여 작성하시오.
//이 프로그램은 고객의 이름과 잔액을 누적하여 관리한다.
//한 고객의 입력이 끝나면 현재까지의 모든 고객의 통장 잔액을 출력한다.

//<< 통장 관리 프로그램입니다. >>
//이름과 금액 입력>> 홍길동 45000
//(홍길동>45000원) 
//이름과 금액 입력>> 김철수 2800
//(홍길동>45000원)(김철수>2800원)
//이름과 금액 입력>> 홍길동 500
//(홍길동>45500원)(김철수>2800원)
//이름과 금액 입력>> 김철수 1800
//(홍길동>45500원)(김철수>4600원)
//이름과 금액 입력>> exit
//프로그램을 종료합니다...

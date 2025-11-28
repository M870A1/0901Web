package Test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Test4 {

	public static void main(String[] args) {
		Map<String, Integer> account = new HashMap<>();
		Vector<String> drink = new Vector<>();

		drink.add("밀키스");
		drink.add("코카콜라");
		drink.add("펩시");
		drink.add("칠성사이다");

		Map<String, Integer> drinkMap = new HashMap<>();
		drinkMap.put("밀키스", 700);
		drinkMap.put("코카콜라", 800);
		drinkMap.put("펩시", 1000);
		drinkMap.put("칠성사이다", 1200);

		Scanner sc = new Scanner(System.in);
		System.out.println("밀키스, 코카콜라, 펩시, 칠성사이다 있습니다");
		while (true) {
			System.out.println("그만 입력시 종료합니다.");
			System.out.print("선택  >> ");
			String data = sc.nextLine().trim();
		
			if (data.equalsIgnoreCase("그만")) {
				System.out.println("종료합니다...");
				break;
			}

				if (drinkMap.containsKey(data)) {
	                System.out.println(data + " 는 " + drinkMap.get(data) + "원 입니다.");

}
			}

		}
	}
// HashMap<String, Integer> 컬렉션을 생성하고
// “밀키스”는 700, “코카콜라”는 800, “펩시”는 1000, “칠성사이다”는 1200을 저장하시오.
//그리고 다음과 같이 음료수 이름을 입력받으면 HashMap에서 검색하여 가격을 출력하시오.

//밀키스, 코카콜라, 펩시, 칠성사이다 있습니다.
//선택 >> 코카콜라
//코카콜라는 800원 입니다.
//선택 >> 칠성사이다
//칠성사이다는 1200원 입니다.
//선택 >> 그만
//종료합니다...
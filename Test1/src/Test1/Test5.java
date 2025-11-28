package Test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		System.out.println("나라 이름과 인구를 5개 입력하세요.");

		for (int i = 0; i < 5; i++) {
			System.out.print("나라 이름, 인구 >> ");
			String name = sc.next();

			int population = sc.nextInt();
			nations.put(name, population);
		}

		int minPopulation = Integer.MAX_VALUE;
		String minCountry = "";
		Set<String> keys = nations.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String country = it.next();

			int population = nations.get(country);

			if (population < minPopulation) {
				minPopulation = population;
				minCountry = country;
			}
		}

		System.out.println("가장 인구가 적은 나라는 '" + "(" + minCountry + ","
							+ " " + minPopulation + ")");

	}

}

//[문제5] 5개의 나라 이름과 인구를 입력받아 해시맵에 저장하고,
//가장 인구가 적은 나라를 검색하여 출력하는 프로그램을 작성하시오.
//이때 다음 해시맵을 이용하시오.
//HashMap<String, Integer> nations = new HashMap<String, Integer>();

//나라 이름과 인구를 5개 입력하세요. (예: Korea 5000)
//나라 이름, 인구 >> Korea 5000
//나라 이름, 인구 >> China 1000000
//나라 이름, 인구 >> USA 30000
//나라 이름, 인구 >> Swiss 2000
//나라 이름, 인구 >> France 2500
//제일 인구가 적은 나라는 (Swiss, 2000)

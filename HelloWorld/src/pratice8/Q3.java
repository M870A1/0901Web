package pratice8;

import java.util.Scanner;
import java.util.Vector;

public class Q3 {

	public static void main(String[] args) {
		Vector<Integer> rainvector = new Vector<>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\"강수량 입력(0 입력시 종료)>>");
			int rain = sc.nextInt();
			if (rain == 0) {
				break;
			}

			rainvector.add(rain);

			System.out.println(rainvector);

//			int avg = 0;
//
//			for (Integer r : rainvector) {
//
//				avg += r;
//
//				System.out.println();
//			}
//			avg = avg / rainvector.size();
			// stream 사용 방식
			int sum = rainvector.stream()
					.mapToInt(Integer::intValue)
					.sum();
		double avg	= rainvector.stream()
				.mapToInt(Integer::intValue)
				.average().getAsDouble();
			
			
			System.out.println("현재 평균 : " +(int)avg);
		}
	System.out.println("End");
	}
}
//3. Vector 컬렉션을 이용하여 강수량의 평균(avg)을 유지 관리하는 프로그램을 작성하라.
//강수량을 입력하면 벡터에 추가하고 현재 입력된 모든 강수량의 평균을 출력하라. 

//강수량 입력(0 입력시 종료)>>5 
//5 
//현재 평균 : 5 
//강수량 입력(0 입력시 종료)>>80 
//5 80 
//현재 평균 : 42 
//강수량 입력(0 입력시 종료)>>53 
//5 80 53 
//현재 평균 46 
//강수량 입력(0 입력시 종료)>>22 
//5 80 53 22 
//현재 평균 40 
//강수량 입력(0 입력시 종료)>>0 
//End
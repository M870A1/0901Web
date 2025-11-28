package chapter17;

import java.util.Random;

public class Ex14_RandomUse {

	public static void main(String[] args) {
// 	now Random(시드) : 시드를 적지 않으면 시간을 기준으로 랜덤값을 출력한다
		Random rand1 = new Random();
		for(int i = 0; i<10; i++) {
//			nextInt(10) : 0~9 까지의 랜덤값 
//			nextBoolean() : true,false의 랜덤 값
//			nextInt() : int최대와 최소 사이의 랜덤 값  
//			nextLong() : long최대 와 최소 가이의 랜덤 값
//			nextDouble() : 0~1사이의 소수점 값

			System.out.print(rand1.nextInt(10)+ " ");
		}
		System.out.println();
//		시드를 설정하면 매번 똑같은 랜덤값을 출력한다 : 동일한 환경을 여러번 실행해야하는 경우
//		 시듐레이션, 게임의 랜덤맵 , 테스트 환경
		Random rand2 = new Random(12);
		for(int i=0; i<10; i++){
System.out.print(rand2.nextInt(10)+ " ");	
	}

	System.out.println();	
	}
}

package paratice3;

import java.util.Arrays;

public class array5 {

	public static void main(String[] args) {
		
		int[] intArr = { 1, 3, 12, 16, 11, 50, 36, 27, 60, 89, 100 };
		int evenCount = 0;
		int oddCount = 0;
		for(int i : intArr) {
			if(i%2 ==0) {
				evenCount++;
			}else {
				oddCount++;
			}
		}
		System.out.println("짝수개수"+evenCount);
		System.out.println("홀수개수"+oddCount);
		// stream을 사용한 짝수 개수 구하기


		System.out.println("짝수개수"+evenCount);
		System.out.println("홀수개수"+oddCount);
	
	}
}
//		int[] intArr = { 1, 3, 12, 16, 11, 50, 36, 27, 60, 89, 100 };
//		int count1 = 0;
//		int count2 = 0;
//		for (int i = 0; i < intArr.length; i++) {
//			if (intArr[i] % 2 == 0) {
//				System.out.println(" 짝수: " + intArr[i]);
//				count1++;
//			} else {
//				System.out.println(" 홀수: " + intArr[i]);
//				count2++;
//			}
//		}
//		System.out.println("짝수:" + count1);
//		System.out.println("홀수:" + count2);
//	}


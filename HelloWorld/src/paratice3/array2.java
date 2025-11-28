package paratice3;

import java.util.Arrays;

public class array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 70, 50, 90, 60, 30, 20 };

		int min = arr[0]; // int min = Integer.MIN_VALUE; 배열에 0번째값, int에 저장 가능한 가장 작은값
		int max = arr[0]; // int max = Integer.MAX_VALUE; 배열에 0번째값, int에 저장 가능한 가장 큰값

		for (int i : arr) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
			System.out.println("최대값 :" + max);
			System.out.println("최소값 :" + min);
		}
//		for(int i = 0; i< arr.length ; i++){		
//		if (arr[i]< min) {
//			min = arr[i];
//		}
//		if(arr[i]> max) {
//			max = arr[i];
//		}
//		
//		}
//		System.out.println("최소값 : "+ min);
//		System.out.println("최대값 : "+ max);	

		// 최대값 구하기
		max = Arrays.stream(arr).max().getAsInt();
		System.out.println("최대값 : " + max);
		// 최소값 구하기
		min = Arrays.stream(arr).min().getAsInt();
		System.out.println("최소값 : " + min);

	}

}

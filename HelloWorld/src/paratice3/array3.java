package paratice3;

import java.util.Arrays;

public class array3 {

	public static void main(String[] args) {
// int[] studentArr = {100,50,70,90,100,60,30,10,50};
// int sum = 0;
// 
// for (int i = 0; i< studentArr.length; i++) {
//	 sum += studentArr[i];
// }
// double average = sum/studentArr.length;
// System.out.println("합계 :"+ sum);
// System.out.println("평균값 : "+ average);
//	}
		int[] studentArr = { 100, 50, 70, 90, 100, 60, 30, 10, 50 };
		int sum = 0;

		for (int i : studentArr) {
			sum += i;
		}
		int avg = sum / studentArr.length;
		System.out.println("합계 :" + sum);
		System.out.println("평균값 :" + avg);
// stream 사용
		sum = Arrays.stream(studentArr).sum();
		double avg1 = Arrays.stream(studentArr).average().getAsDouble();
		System.out.println("합계 :" + sum);
		System.out.println("평균 :" + avg1);
	}
}

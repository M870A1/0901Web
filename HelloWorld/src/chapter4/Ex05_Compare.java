package chapter4;

public class Ex05_Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		비교연산자의 결과는 true,false로 지정되기 때문에 boolean자료형으로 저장
		boolean value = 1>2; // 1은 2보다 크다 -> flase
		System.out.println(value);
		int num1 = 10; // num1 은 10
		
//		비교 연산자 사용시 변수는 앞에 작성하기
		System.out.println(num1>5);// num1은5보다 크다 -> true
	    System.out.println(5<num1);// 앞에 숫자를 사용하는 방식은 X
	    
//	    "출력할 문자열" + (계산식) : 콘솔에 출력할때 설명문을 작성하는 방식
		System.out.println("2 >= 1 : " + (2>=1)); //2는 1보다 크거나 같다-> true
	    System.out.println("2 <= 1 : " + (2<=1)); //2는 1보다 작거나 같다-> false
	
//	    1.0은 double, 1은 int자료형 이지만 자동 형 변환으로 인해
//	    int인 1이 double로 변경되어 계산됨	    
//	    비교연산자 사용시에도 자동형 변환이 실행됨
	    System.out.println("1.0 == 1 : " + (1.0==1));// 1.0은 1과 같다-> true
	    System.out.println("1.0 != 1 :" + (1.0!=1));// 1.0은 1과 다르다-> false

	}

	
}






















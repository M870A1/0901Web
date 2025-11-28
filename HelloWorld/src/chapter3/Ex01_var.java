package chapter3;

public class Ex01_var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 표기법 3가지
		// 카멜표기법(변수,메서드) : stringValue, maxCount, minCount
		// 파스칼표기법(클래스) : StringValue,MaxCount,MinCount
		// 언더스코어표기법(상수) : STRING+VALUE, MAX_CONUT, MIN_COUNT
		
		// 변수의 작성 방법
		// 1. 카멜표기법 , 변수의 첫단어의 첫글자는 소문자로 나머지 단어의 첫글자는 대문자로 작성
		// 2. 알파벳, 숫자, _ 만을 사용하여 작성한다.
		// 3. 첫글자는 알파벳,$로만 작성할 수 있다.
		// 4. 변수이름만 보고도 어느정도 의미가 통하도록 작성한다.
		
        //   자료형 변수이름 = 저장할값;
		// 1. int 자료형에 5를 저장하세요.
		int intValue = 5;
		System.out.println(intValue);

		// 2. long 자료형에 1234567890123을 저장하세요.
		long longValue = 1234567890123L;
		System.out.println(longValue);

		// 3. String 자료형에 오늘의 날씨는 맑음을 저장하세요.
		String stringValue = "오늘의 날씨는 맑음";
		System.out.println(stringValue);

		// 4. double 자료형에 3.14를 저장하세요.
		double doubleValue = 3.14;
		System.out.println(doubleValue);

		// 5. boolean 자료형에 false 를 저장하세요.
			boolean num1 = 5 > 10;
			System.out.println(num1);

		
		
		
	}

}

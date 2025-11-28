package chapter14;

public class Ex03_stringBuffer {

	public static void main(String[] args) {
//		System.currenTimeMillis() : 1970년 1월1일부터 현재까지의 1/1000초 단위로 반환
		long startTime = System.currentTimeMillis();
		System.out.println("프로그램이 시작 되었습니다.");

//		StringBuffer 클래스
//		문자열을 변경하는 코드를 많이 실행해야하는 경우 사용하는 클래스
//		StringBuffer는 스레드 사용시 안전하게 변경가능
//		StringBuffer는 스레드 사용시 데이터가 이상하게 변경되는 경우가 생김

		StringBuffer str = new StringBuffer("abcd");
		for (int i = 0; i < 100000; i++) {
			str.append("ab");
		}
		System.out.println("프로그램이 종료되었습니다.");
		System.out.println(str);
		long endTime = System.currentTimeMillis();
		long time = (endTime - startTime);
		System.out.println(time + "초 동안 실행 되었습니다.");

	}

}

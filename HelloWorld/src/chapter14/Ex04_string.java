package chapter14;

public class Ex04_string {

	public static void main(String[] args) {
//		System.currenTimeMillis() : 1970년 1월1일부터 현재까지의 1/1000초 단위로 반환
		long startTime = System.currentTimeMillis();
		System.out.println("프로그램이 시작 되었습니다.");
		String str = "abcd";
		for (int i = 0; i < 10000; i++) {
			str += "ab";
		}
		System.out.println("프로그램이 종료되었습니다.");
		System.out.println(str);
		long endTime = System.currentTimeMillis();
		long time = (endTime - startTime);
		System.out.println(time + "초 동안 실행 되었습니다.");

	}

}

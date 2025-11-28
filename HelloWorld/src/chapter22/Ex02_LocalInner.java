package chapter22;

class HumanCamp2 {
	private int speed = 10;

//	멤버 내부 클래스
	public void getMarine() {
		// 지역 내부 클래스
		class Marine2 {
			public void move() {
				System.out.println("인강형 유닛이" + speed + "속도로 이동합니다.");
			}
		}

		Marine2 inner = new Marine2();
		inner.move();
	}
}
//	내부 클래스 메서드 실행

public class Ex02_LocalInner {

	public static void main(String[] args) {
		
		HumanCamp2 hc = new HumanCamp2();
		hc.getMarine();

		System.out.println();
	}

}

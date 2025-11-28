package chapter22;

interface Unit3 {
	void move();
}

class HumanCamp3 {
	private int speed = 10;
	int add(int n1, int n2) {
		return n1+n2;
	}
//	클래스를 생성하여 돌려주는 메서드
	public Unit3 getMarine() {
//		Unit3의 move 추상 메서드를 구현
//		Marine3의 경우 지역 내부 클래스라서 밖에서는 절대 쓰이지 않음
//		익명 내부 클래스로 변경하여 이름을 생략가능
		class Marine3 implements Unit3 {
			public void move() {
				System.out.println("인간형 유닛이" + speed + "속도로 이동합니다 ");
			}
		}
//		Marine3 이라는 객체를 생성하여 돌려줌
		return new Marine3();
	}
// new 인터페이스 이름() {오버라이드 이후 만들면 바로 사용가능  }; < 세미콜론 잘넣을것
// 위의 getMarine 메서드와 같이 Unit3을 생성하여 반환하는 메서드
	public Unit3 getMarine2() {
//		익명 내부 클래스를 사용하여 이름을 작성하지 않고 설정
		return new Unit3() {
			@Override
			public void move() {
				System.out.println("인간형 유닛이" + speed + "속도로 이동합니다 ");
			}
		};
	}
}

public class Ex03_AnonymousInner1 {

	public static void main(String[] args) {
		HumanCamp3 hc = new HumanCamp3();
		Unit3 unit = hc.getMarine();
		unit.move();

//		익명 내부 클래스를 변수 선언시 작성하는 방식
		Unit3 unit3 = new Unit3() {
			@Override
			public void move() {
				System.out.println("인강형 유닛이 10속도로 이동합니다.");
			}
		};
		unit3.move();
		
	
	}

}

package chapter20;

class Npc5 {
	@Override
	public String toString() {
		return "This is Npc5.";
	};
}

class Tank5 {
	@Override
	public String toString() {
		return "This is Tank5.";
	}
}
//class 클래스이름<제네릭타입>{
// 제네릭타입 매개변수 이름 규칙
// 1. 한글자로 이름 짓기
// 2. 대문자로 이름 짓기
// 대표적으로 사용되는 문자 :E(Element,K(Key), N(Number), T(Type),V(Value)
// 2개를 쓸떄 class camp5<E,T> 이렇게 2개 넣기 
//}

class Camp5<T> {
// 제네릭으로 설정한 T는 멤버 변수, 메서드, 생성자 에서 자료형으로 사용 가능
	private T unit;
	public void set(T unit) {
		this.unit = unit;
	}
	public T get() {
		return unit;
	}
}

public class Ex05_MyGameGaneric1 {

	public static void main(String[] args) {
//		기본자료형(보라색 자료형)은 제네릭에 사용할 수 없다.
//		클래스이름 <자료형> 변수이름 = new 클래스이름 <>(); 
		Camp5<Npc5> human = new Camp5<>();
		Camp5<Tank5> tank = new Camp5<>();
//		Camp5<int> intTest = new Camp5<>(); int는 기본 자료형이기 떄문에 에러
//		숫자를 사용하려면 int대신 interger를 사용하자 
		Camp5<Integer> integetTest = new Camp5<>();
		
//		 Camp5<Nnc5>로 설정했기 떄문에 npc5만 저장할 수 있도록 변경됨 
		human.set(new Npc5());
//		human.set(new Tank5()); Tank5는 human에 저장시 에러를 발생 시킴 
		tank.set(new Tank5());
//		tank.set(new Npc5()); Npc5는 tank에 저장시 에러를 발생 시킴
		Npc5 hUnit = human.get();
		Tank5 mUnit = tank.get();

		System.out.println(hUnit);
		System.out.println(mUnit);

	}

}

package Pratice6;

class Circle {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
}
// final을 붙이면  NamedCircle은 상속할 수 없는 클래스로 변경됨
final class NamedCircle extends Circle {
	String name;

	NamedCircle(int radius, String name) {
		super(radius);
		this.name = name;
	}
// final을 붙이면 오버라이딩 할 수 없는 메서드로 변경됨
	final void show() {
		System.out.println(name + ",반지름 =" + getRadius());
	}
}

public class Q1 {

	public static void main(String[] args) {
		NamedCircle w = new NamedCircle(5, "Waffle");
		w.show();
	}
}
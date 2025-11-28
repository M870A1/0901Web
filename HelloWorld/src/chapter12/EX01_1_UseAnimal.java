package chapter12;

class Animal {
	// 멤버 변수로 : name, age,
	// 메서드 : eat(),move()
	String name;
	int age;

	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void eat() {
		System.out.println(name + "가 먹이를 먹습니다");
	}

	void move() {
		System.out.println(name + "가 10의 속도로 움직입니다");
	}

}

class Cat extends Animal {
	// 메서드 : meow() : 고양이가 야옹하고 웁니다.

	Cat(String name, int age) {
		super(name, age);
	}
	// eat() 메서드를 오버라이딩하여 고양이는 천천히 먹습니다 출력하기.
	// move() 메서드를 오버라이딩 하여 고양이는 조용히 움직입니다 출력하도록 변경

	void move() {
		System.out.println(name + "는 조용히 움직 입니다.");
	}

	void eat() {
		System.out.println(name + "가 천천히 먹습니다.");
	}

	void meow() {
		System.out.println("고양이가 야옹하고 웁니다.");
		System.out.println(name + "는" + " " + age + "살입니다.");
	}

}

class Dog extends Animal {
	// 메서드 : bark() : 강아지가 멍멍하고 짖습니다.
	Dog(String name, int age) {
		super(name, age);
	}
 @Override
void eat() {
	super.eat();
	System.out.println("단 주인의 허락이 떨어져야 먹습니다.");
}
	@Override
	void move() {
		super.move();
		System.out.println(name + "는 산책을 나갈때 속도가 2배가 됩니다.");
	}

	void bark() {
		System.out.println("강아지가 멍멍하고 짖습니다.");
		System.out.println(name + "는" + " " + age + "살입니다.");
	}
}

public class EX01_1_UseAnimal {

	public static void main(String[] args) {
		Cat Animal = new Cat("고양이", 2);
		Animal.eat();
		Animal.move();
		Animal.meow();

		System.out.println();

		Dog Animal2 = new Dog("강아지", 3);
		Animal2.eat();
		Animal2.move();
		Animal2.bark();

	}
}

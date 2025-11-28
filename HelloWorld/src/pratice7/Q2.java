package pratice7;

class Person {
	public String name;
	public String address;
	public String number;

	Person(String name, String address, String number) {
		this.name = name;
		this.address = address;
		this.number = number;
	}

	String getName() {
		return name;
	}

	String getAddress() {
		return address;
	}

	String getNumber() {
		return number;
	}

	void setName(String name) {
		this.name = name;
	}

	void setAddress(String address) {
		this.address = address;
	}

	void setNumber(String number) {
		this.number = number;
	}

	void println() {
		System.out.println("이름:" + name);
		System.out.println("주소:" + address);
		System.out.println("전화번호:" + number);
	}
}

class Customer extends Person {
	public String id;
	public int mileage;

	Customer(String name, String address, String number, String id, int mileage) {
		super(name, address, number);
		this.id = id;
		this.mileage = mileage;
	}

	String getId() {
		return id;
	}

	int getMileage() {
		return mileage;
	}

	void setId(String id) {
		this.id = id;
	}

	void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public void println() {
		super.println();
		System.out.println("고객번호:" + id);
		System.out.println("마일리지:" + mileage);

	}
}

public class Q2 {

	public static void main(String[] args) {
//		2. Person 클래스를 설계하라. Person 클래스는 이름, 주소, 전화번호 를 필드로 가진다. 
//		하나 이상의 생성자를 정의하고 각 필드에 대하여 접근자와 설정자 메소드를 작성하라. 
//		이어서 Person을 상속받아서 Customer를 작성하여 보자.
//		Customer는 고객 번호와 마일리지를 필드로 가지고 있다. 
//		한 개 이상의 생성자를 작성하고 적절한 접근자 메소드와 설정자 메소드를 작성한다.
//		이들 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라.
//					[Person 정보]
//					이름: 김악마
//					주소: 서울특별시 강남구
//					전화번호: 010-1234-5678
//
//					[Customer 정보]
//					이름: 나용사
//					주소: 부산광역시 해운대구
//					전화번호: 010-9876-5432
//					고객번호: C001
//					마일리지: 1200
		Person person = new Person("김악마", "서울특별시 강남구","010-1234-5678");
		System.out.println("[Person]");
		person.println();

		System.out.println("------------");

		Customer customer = new Customer("나용사", "부산광역시 중앙구", "010-9876-5432", "C001", 5000);
		System.out.println("[Customer]");
		customer.println();
	}
}

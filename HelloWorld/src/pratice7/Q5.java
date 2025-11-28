package pratice7;

class Phone {
	public String company;
	public int price;
	public String communicationtype;

	Phone(String company, int price, String communicationtype) {
		this.company = company;
		this.price = price;
		this.communicationtype = communicationtype;
	}

	public String getcompany() {
		return company;
	}

	public int getprice() {
		return price;
	}

	public String getcommunication() {
		return communicationtype;
	}

	void setcompany(String company) {
		this.company = company;
	}

	void setprice(int price) {
		this.price = price;
	}

	void setcommunication(String communicationtype) {
		this.communicationtype = communicationtype;
	}

	void printIn() {
		System.out.println("제조사: " + company);
		System.out.println("가격: " + price + "만원");
		System.out.println("통신타입: " + communicationtype);
	}
}

class SmartPhone extends Phone {
	String OS;
	double OSversion;
	int Memroysize;
	String Camera;
	boolean Bluetooth;

	SmartPhone(String company, int price, String communicationtype, String OS, double OSversion, int Memroysize,
			String Camera, boolean Bluetooth) {
		super(company, price, communicationtype);
		this.OS = OS;
		this.OSversion = OSversion;
		this.Memroysize = Memroysize;
		this.Camera = Camera;
		this.Bluetooth = Bluetooth;
	}

	public String getOS() {
		return OS;
	}

	public double getOSversion() {
		return OSversion;
	}

	public int getMemroysize() {
		return Memroysize;
	}

	public String getCamera() {
		return Camera;
	}

	public String getBluetooth() {
	    return Bluetooth ? "지원" : "미지원";
	}
	public boolean isBluetooth() {
		return Bluetooth;
	}

	void setOS(String OS) {
		this.OS = OS;
	}

	void setOSversion(double OSversion) {
		this.OSversion = OSversion;
	}

	void setMemroysize(int Memroysize) {
		this.Memroysize = Memroysize;
	}

	void setCamera(String Camera) {
		this.Camera = Camera;
	}

	void setBluetooth(boolean Bluetooth) {
		this.Bluetooth = Bluetooth;
	}

	@Override
	public void printIn() {
		super.printIn();
		System.out.println("운영체제 타입:" + OS);
		System.out.println("운영체제 버전: " + OSversion);
		System.out.println("내부 메모리 크기: " + Memroysize + "GB");
		System.out.println("카메라 지원 여부: " + Camera);
		System.out.println("블루투스 지원 여부: " + Bluetooth);
	}
}

public class Q5 {

	public static void main(String[] args) {

		Phone phone = new Phone("Sanmsung", 100, "5g");
		phone.printIn();

		System.out.println("------------");

		SmartPhone smartPhone = new SmartPhone("Apple", 100, "5g", "iOS",
												17.1, 256, "있음", true);
		smartPhone.printIn();

	}

}
//		5. 일반적인 휴대폰을 나타내는 Phone 클래스를 작성한다.
//		Phone에는 제조사, 가격, 통신타입(2g 또는 3g) 등의 정보가 저장되어 있다.
//		Phone에서 상속받아서 SmartPhone 클래스를 작성하여 보자.
//		SmartPhone 클래스에는 운영체제 타입, 운영체제 버전, 내부 메모리
//		크기, 카메라 장착 여부, 블루투스 지원 여부 등의 필드가 추가된다.
//		생성자, 접근자, 설정자를 포함하여서 각각의 클래스를 작성한다.
//		이들 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라. 

//[일반 휴대폰 정보]
//제조사: Samsung
//가격: 150000
//통신 타입: 2G
//
//[스마트폰 정보]
//제조사: Apple
//가격: 1300000
//통신 타입: 5G
//운영체제: iOS
//OS 버전: 17.1
//내부 메모리: 256GB
//카메라 장착 여부: 있음
//블루투스 지원 여부: 지원

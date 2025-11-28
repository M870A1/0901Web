package pratice7;

class Food {
	public int kcal;
	public int price;
	public int weight;

	Food(int kcal, int price, int weight) {
		this.kcal = kcal;
		this.price = price;
		this.weight = weight;
	}

	int getkcal() {
		return kcal;
	}

	int getprice() {
		return price;
	}

	int getweight() {
		return weight;
	}

	void setkcal(int kcal) {
		this.kcal = kcal;
	}

	void setprice(int price) {
		this.kcal = price;
	}

	void setweight(int weight) {
		this.weight = weight;
	}

	void printIn() {
		System.out.println("칼로리: " + kcal+"kcal");
		System.out.println("가격: " + price+"원");
		System.out.println("중량: " + weight+"kg");
	}
}

class Melon extends Food {
	String farmdate;

	Melon(int kcal, int price, int weight,String farmdate) {
		super(kcal, price, weight);
		this.farmdate = farmdate;
	}

	public String farmdate() {
		return farmdate;
	}

	void setfarmdate(String farmdate) {
		this.farmdate = farmdate;
	}
@Override
public void printIn() {
	super.printIn();
	System.out.println("생산 농장: " + farmdate);
	}
}

public class Q4 {
public static void main(String[] args) {
		Food food = new Food (150,12000,2);
		food.printIn();

		System.out.println("------------");

		Melon melon = new Melon (180, 26000, 4, "용사멜론농원");
		melon.printIn();
	}
}
	
//		4. 일반적인 음식을 나타내는 Food 클래스를 상속받아서 멜론을 나타내는 Melon 클래스를
//		작성하여 보자. 
//		Food 클래스는 칼로리, 가격, 중량 등의 정보를 가진다.
//		Melon 클래스는추가로 경작 농원 정보를 가진다.
//		생성자, 접근자, 설정자를 포함하여서 각각의 클래스를작성한다. 
//		이들 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라. 

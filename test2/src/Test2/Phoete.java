package Test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Phone1 {
	private String name;
	private String tel;
	private String address;

	public Phone1(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}
}

public class Phoete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Phone> map = new HashMap<>();

		System.out.print("인원수 >> ");
		int count = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < count; i++) {
			System.out.println("이름과 전화번호(번호는 연속적으로 입력), 주소 >>");
			String name = sc.next();
			String tel = sc.next();
			sc.nextLine();
			String address = sc.nextLine();
			map.put(name, new Phone(name, tel, address));
		}

		System.out.println("저장되었습니다...");

		while (true) {
			System.out.print("검색할 이름 >> ");
			String name = sc.next();
			if (name.equals("exit"))
				break;
			if (map.containsKey(name)) {
				Phone phone = map.get(name);
				System.out.println(name + "의 번호와 주소는 " + phone.getTel() + ", " + phone.getAddress() + "입니다.");
			} else {
				System.out.println(name + "은(는) 없습니다.");
			}
		}

		System.out.println("프로그램을 종료합니다...");
		sc.close();
	}
}

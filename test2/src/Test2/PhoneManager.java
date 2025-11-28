package Test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Phone {
	private String name;
	private String tel;
	private String address;

	public Phone(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 전화: " + tel + ", 주소: " + address;
	}
}

public class PhoneManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Phone> PhoneMap = new HashMap<>();
		for(int i=0; i<3; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력), 주소>>");
			String name = sc.next();
			String tel = sc.next();
			String address = sc.next();
			Phone s = new Phone(name, tel,address);
			PhoneMap.put(name,s);
		}


			System.out.println("저장되었습니다...");
		
			for(String name : PhoneMap.keySet()) {	
		}
		while(true) {
			System.out.print("검색할 이름>>");
			String name = sc.next();
			if(name.equals("exit")) {
				System.out.println("프로그렘을 종료합니다...");
				break;
			}
			if(PhoneMap.containsKey(name)) {
				System.out.println(PhoneMap.get(name).getName()
						+"의 번호와 주소는 "+PhoneMap.get(name).getTel()
						+","+PhoneMap.get(name).getAddress()+"입니다.");
			}else {
				System.out.println(name+"은(는) 없습니다.");
			}
		}
	}

}

//문제2] 작성할 클래스명: Phone 클래스, PhoneManager 클래스
//이름(name)과 전화번호(tel) 필드, 주소(address),
//생성자 및 필요한 메소드를 가진 Phone 클래스를 작성하고,
//다음 실행 사례와 같이 작동하도록 main()을 가진 PhoneManager 클래스를 작성하세요.
//한 사람의 전화번호는 하나의 Phone 객체로 다룹니다.

//인원수 >> 3
//이름과 전화번호(번호는 연속적으로 입력), 주소 >> 김인수 111-1111 서울
//이름과 전화번호(번호는 연속적으로 입력), 주소 >> 조수미 222-2222 부산
//이름과 전화번호(번호는 연속적으로 입력), 주소 >> 한원선 333-3333 경기도
//저장되었습니다...
//
//검색할 이름 >> 한원선
//한원선의 번호와 주소는 333-3333, 경기도 입니다.
//검색할 이름 >> 박인수
//박인수 은(는) 없습니다.
//검색할 이름 >> exit
//프로그램을 종료합니다...
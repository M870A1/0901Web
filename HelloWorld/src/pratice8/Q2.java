package pratice8;

import java.util.HashMap;
import java.util.Scanner;

class Nation {
	private String name;
	private String capital;

	public Nation(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
}

public class Q2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> nations = new HashMap<String, String>();
        System.out.println("나라이름과 수도를 입력하세요. (예 : Korea 서울)");
        while(true) {
			System.out.print("나라 이름, 수도>>");
			String str = sc.next();
			if(str.equals("그만")) {
				break;
			}
			String city = sc.next();
			nations.put(str, city);
        }
        while(true) {
			System.out.print("수도 검색 >>");
			String str = sc.next();
			if(str.equals("그만")) {
				break;
			}
			 if (nations.containsKey(str)) {
	                System.out.println(str + "의 수도는 " + nations.get(str) + "입니다.");
	            } else {
	                System.out.println(str + "는 나라는 없습니다.");
	            }
	        }
        }
    }



//		2. “그만”이 입력될 때까지 나라의 이름과 수도를 입력받아 저장하고 다시 나라의 이름을 입력하면 
//		수도를 출력하는 프로그램을 작성하시오. 다음의 해시맵을 이용하라. 
//		HashMap<String, String> nations = new HashMap<String, String>(); 
//		_____________________________________________________ 
//		나라이름과 수도를 입력하세요. (예 : Korea 서울) 
//		나라 이름, 수도>> Korea 서울 
//		나라 이름, 수도>> USA 워싱턴 
//		나라 이름, 수도>> England 런던 
//		나라 이름, 수도>> France 파리 
//		나라 이름, 수도>> 그만 
//		수도 검색 >> France 
//		France의 수도는 파리 
//		수도 검색 >> 스위스 
//		스위스 나라는 없습니다. 
//		수도 검색>>그만 
//		End 

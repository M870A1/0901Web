package Chapter23;

import java.util.Arrays;
import java.util.List;

public class Ex05_Map {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple","banana","orange");
		list.stream()
//		map(람다식): 람다식을 실행하여 결과물을 변환
		.map(s -> s.toUpperCase())
		.forEach(n->System.out.print(n+"\t")); // 하나씩 출력하는 문구
		
		System.out.println();
		
		List<String> list2 = Arrays.asList("ApPlE","baNaNa","OrAnGe");
		list2.stream()
		.map(s -> s.toLowerCase())
		.forEach(n->System.out.print(n+"\t"));
		
		System.out.println();
		
		list.stream()
		.map(s -> s.length())
		.forEach(n->System.out.print(n+"\t"));
	
		System.out.println();
	
	list.stream()
		.map(s ->{
			int length = s.length();
		return s.toUpperCase() + "입니다. "
				+ "글자수 : "+ length
				+ "소문자 : "+ s.toLowerCase() ;
		}) // .map(s -> {} 중갈호 실행시 안에 출력문을 여러게 넣을 수 있음
		.forEach(n->System.out.println(n));
	}

}

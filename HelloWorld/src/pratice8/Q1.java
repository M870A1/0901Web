package pratice8;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. 학점(‘A’, ‘B’, ‘C’, ‘D’, ‘F’)을 컬렉션에 저장하라.
//		그러고 나서 컬렉션을 검색하여 학점을 점수 (A=4.0, B=3.0, C=2.0, D=1.0, F=0.0)로 
//		변환하여 출력하는 프로그램을 작성하라. 
//		1) Vector 컬렉션을 이용 

//		2) HashMap 컬렉션을 이용

		Vector<String> grade = new Vector<>();
		grade.add("A");
		grade.add("B");
		grade.add("C");
		grade.add("D");
		grade.add("F");

		for (String grade1 : grade) {
	double score = 0.0;

	switch (grade1) {
	case "A": score = 4.0;
	break;
	case "B": score = 3.0;
	break;
	case "C": score = 2.0;
	break;
	case "D": score = 1.0;
	break;
	case "F": score = 0.0;
	break;
	}
System.out.println("학점 : "+ grade1 + "점수: "+score);
		}

		HashMap<String, Double> map = new HashMap<>();
	
		
		
		map.put("A", 4.0);
		map.put("B", 3.0);
		map.put("C", 2.0);
		map.put("D", 1.0);
		map.put("F", 0.0);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A~F사이의 점수를 입력해주세요");
		String data = sc.next();
		System.out.println(data + "="+map.get(data)+ "입니다.");
		
		System.out.println("A : " + map.get("A"));
		System.out.println("B : " + map.get("B"));
		System.out.println("C : " + map.get("C"));
		System.out.println("D : " + map.get("D"));
		System.out.println("F : " + map.get("F"));
		for (String grade1 : map.keySet()) {
			Double score = map.get(grade1);
			System.out.println("학점 : " + grade1 + "점수 : " + score);

		}
	}

}

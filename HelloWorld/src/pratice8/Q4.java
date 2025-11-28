package pratice8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
	private String name;
	private String major;
	private String studentId;
	private double grade;

	public Student(String name, String major, String studentId, double grade) {
		this.name = name;
		this.major = major;
		this.studentId = studentId;
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름: " + name + "\t학과: " + major + "\t학번: " + studentId + "\t학점: " + grade;
	};

	public String getName() {
		return name;
	}
}

public class Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		System.out.println("학생 5명의 정보를 입력하시오");

		for (int i = 0; i < 5; i++) {
			System.out.println("\n[" + (i + 1) + "번째 학생]");

			System.out.print("이름: ");
			String name = sc.next();

			System.out.print("학과: ");
			String major = sc.next();

			System.out.print("학번: ");
			String studentId = sc.next();

			System.out.println("학점: ");
			double grade = sc.nextDouble();
			students.add(new Student(name, major, studentId, grade));
		}
		while (true) {
			System.out.println("학생 이름 >>");
			String name = sc.next();
			if (name.equals("그만")) {
				break;
			}
			for (Student s : students) {
				if (name.equals(s.getName())) {
					System.out.println(s.toString());
				}
			}
		}
//
//		Map<String, Student> studentsMap = new HashMap<>();
//		for (int i = 0; i < 5; i++) {
//			System.out.println(">>");
//			String name = sc.next();
//			String dept = sc.next();
//			int sno = sc.nextInt();
//			double score = sc.nextDouble();
//		}
//		System.out.println("해당하는 학생이 없습니다.");
//		4. 학생정보를 나타내는 Student클래스에 이름name, 학과major, 학번studentId, 학점 grade을 저장하는 필드를 작성하라.

//		(1) 학생 객체를 생성하고 5명을 학생정보를 ArrayList<Student>컬렉션에 저장한 후에, 

//		ArrayList<Student>의 모든학생(5명) 정보를 출력하고 학생의 이름을 입력받아,
//		해당 학생의 학생정보를 출력하는 프로그램을 작성하라. 

//		(2) ArrayList<Student> 대신, HashMap<String, Student> 해시맵을 이용하여 다시 작성하라. 
//		해시맵의 키(key)는 학생이름으로 한다. 

//------------결과 -----------------		
//		학생이름, 학과, 학번, 학점을 입력하세요.  
//		>> 홍길동 모바일 1 4.1  
//		>> 이재문 안드로이드 2 3.9 
//		>> 김남윤 웹공학 3 3.5 
//		>> 최찬미 빅데이터 4 4.25 
//		>> 정영웅 컴퓨터공학 5 3.0 ---------------------------------------- 
//		이름 : 홍길동 
//		학과 : 모바일 
//		학번 : 1 
//		학점 : 4.1 ----------------------------- 
//		이름 : 이재문 
//		학과 : 안드로이드  
//		학번 : 2  
//		학점 : 3.9 ------------------------------ 
//		이름 : 김남윤 
//		학과 : 웹공학 
//		학번 : 3 
//		학점 : 3.5 ---------------------------- 
//		이름 : 최찬미 
//		학과 : 빅데이터 
//		학번 : 4 
//		학점 : 4.25 ---------------------------- 
//		이름 : 정영웅 
//		학과 : 컴퓨터공학 
//		학번 : 5 
//		학점 : 3.0 ---------------------------- 
//		학생 이름 >> 최찬미 
//		최찬미, 빅데이터, 4, 4.25 
//		학생 이름 >> 이재문 
//		이재문, 안드로이드, 2, 3.9 
//		학생 이름 >> 그만

	}

}

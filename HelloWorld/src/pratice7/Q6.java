package pratice7;

class Student2 {
	public String Name;
	public int Number;
	public String Department;
	public int Grade;
	public int Credits;

	Student2(String Name, int Number, String Department, int Grade, int Credits) {
		this.Name = Name;
		this.Number = Number;
		this.Department = Department;
		this.Grade = Grade;
		this.Credits = Credits;
	}

	public String getName() {
		return Name;
	}

	public int getNumber() {
		return Number;
	}

	public String getDepartment() {
		return Department;
	}

	public int getGrade() {
		return Grade;
	}

	public int getCredits() {
		return Credits;
	}

	void setName(String Name) {
		this.Name = Name;
	}

	void setNumber(int Number) {
		this.Number = Number;
	}

	void setDepartment(String Department) {
		this.Department = Department;
	}

	void setGrade(int Grade) {
		this.Grade = Grade;
	}

	void setCredits(int Credits) {
		this.Credits = Credits;
	}

	void printIn() {
		System.out.println("이름 : " + Name);
		System.out.println("학번 : " + Number);
		System.out.println("학과 : " + Department);
		System.out.println("학년 : " + Grade);
		System.out.println("이수 학점 : " + Credits);
	}
}

class UnderGraduate extends Student2 {
	private String club;

	public UnderGraduate(String Name, int Number, String Department, int Grade, int Credits, String club) {
		super(Name, Number, Department, Grade, Credits);
		this.club = club;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public void printIn() {
		super.printIn();
		System.out.println("소속 동아리 : " + club);
	}
}

class Graduate extends Student2 {
	private String Assistant;
	private boolean scholarship;

	Graduate(String Name, int Number, String Department, int Grade, int Credits, String Assistant,
			boolean scholarship) {
		super(Name, Number, Department, Grade, Credits);
		this.Assistant = Assistant;
		this.scholarship = scholarship;
	}

	public String getAssistant() {
		return Assistant;
	}

	public void setAssistant(String assistant) {
		this.Assistant = assistant;
	}

	public String getscholarship() {
		return scholarship ? "받음" : "못받음";
	}

	public void setscholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}

	@Override
	public void printIn() {
		super.printIn();
		System.out.println("조교 유형 : " + Assistant);
		System.out.println("장학금 여부 : " + getscholarship());
	}
}

public class Q6 {

	public static void main(String[] args) {
		UnderGraduate uStudent = new UnderGraduate("갑", 1000, "컴공", 3, 84, "날자날어");
		Graduate gStudent = new Graduate("을", 100, "전자공학", 2, 51, "교육 조교", false);

		System.out.println("=== 학부생 정보 ===");
		uStudent.printIn();

		System.out.println("\n=== 대학원생 정보 ===");
		gStudent.printIn();
	}

}
//6. 다음 그림에 해당하는 클래스를 작성하여 보자.
//모든 학생은 이름, 학번, 소속 학과, 학년, 이수 학점 수를 가진다.
//추가적으로 학부생은 소속 동아리명을 가지고 있고 대학원생은 조교 유형과 장학금 비율을 가진다.
//조교 유형에는 교육 조교와 연구 조교가 있으며장학금 비율은 0과 1사이의 값이다.
//각 클래스는 적절한 생성자 메소드, 접근자 메소드, 변경자 메소드를 가진다.
//이러한 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라

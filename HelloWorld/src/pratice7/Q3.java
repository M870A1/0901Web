package pratice7;

class Book {
	public String title;
	public int page;
	public String author;

	Book(String title, int page, String author) {
		this.title = title;
		this.page = page;
		this.author = author;
	}

	public String gettitle() {
		return title;
	}

	public int getpage() {
		return page;
	}

	public String getauthor() {
		return author;
	}

	void setTitle(String title) {
		this.title = title;
	}

	void setpage(int page) {
		this.page = page;
	}

	void setauthor(String author) {
		this.author = author;
	}

	void printIn() {
		System.out.println("제목: " + title);
		System.out.println("페이지 수: " + page);
		System.out.println("저자: " + author);
	}
}

class Magazine extends Book {
	String issueDate;

	Magazine(String title, int pages, String author, String issueDate) {
		super(title, pages, author);
		this.issueDate = issueDate;
	}

	public String getissueDate() {
		return issueDate;
	}

	void setissueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public void printIn() {
		super.printIn();
		System.out.println("발매일: " + issueDate);
	}
}

public class Q3 {

	public static void main(String[] args) {

		Book book = new Book("커피 그것은...", 470, "사향고양이");
		book.printIn();

		System.out.println("------------");

		Magazine magazine = new Magazine("커피의정석", 100, "핸드드립", "2025-10");
		magazine.printIn();
	}
}
//		3. 일반적인 책을 나타내는 Book 클래스를 상속받아서 잡지를 나타내는 Magazine 클래스
//		를 작성하여 보자.
//		Book 클래스는 제목, 페이지수, 저자 등의 정보를 가진다.
//		Magazine 클래스는 추가로 발매일 정보를 가진다.
//		생성자, 접근자, 설정자를 포함하여서 각각의 클래스를 작성한다.
//		이들 클래스들의 객체를 만들고 각 객체의 모든 정보를 출력하는 테스트 클래스를 작성하라. 

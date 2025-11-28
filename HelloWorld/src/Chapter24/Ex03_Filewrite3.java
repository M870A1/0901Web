package Chapter24;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_Filewrite3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try ~ with ~ resource 문
//		try 괄호안에서 선언한 클래스는 자동으로 close()를 실행 해주는 문법
		try (FileOutputStream out = new FileOutputStream("data2.txt")) {
			out.write(65);
			out.write(66);
			out.write(67);
			out.write(68);
			out.write(69);
			out.write(70);
			out.write(126);
//		파일관련 예외는IOException으로 대부분 처리 가능
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}

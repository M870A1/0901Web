package chater2;

public class Ex01 {

	public static void main(String[] args) {
		byte b = 127;
//		-128~127 까지 저장 가능
		short s = 32767;
//		-32768~32767
		int i = 1234567890;
// 숫자를 저장할때 가장 많이 사용하는 자료형 		
//		-21억~+21억 까지 저장 가능
//		 -2147483648~2147483647
		long l = 1234567890123456789L;
//		-9223372036854775808 ~ 9223372036854775807
//		21억이 넘는 값의 경우 대문자 L 을 붙여서 사용해야 한다.
System.out.println(b);
System.out.println(s);
System.out.println(i);
System.out.println(l);

//	실수(소수점) 자료형 float(4바이트), double(8바이트)
double num1 = 1.0000001;
System.out.println(num1);
double num2 = 2.0000001;
System.out.println(num2);
// 자바의 부동 소수점 방식은 소수점 숫자 계산이 정확하지 않다
double result = num1 + num2;
System.out.println(result);
// float 자료형은 뒤에 f 를 붙여야 한다.
float f = 1.001f;
	}
}
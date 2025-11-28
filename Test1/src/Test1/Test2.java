package Test1;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        while (true) {
            System.out.println("내용을 입력해주세요. : ");
            System.out.println("종료하려면 exit 입력");
            
            String input = sc.nextLine(); 
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다...");
                break;
            }
            if (input.trim().isEmpty()) {
                continue;
            }
            String[] words = input.split(",");

            System.out.println("어절의 개수는 " + words.length);
        }
    }
}

//		,(콤마)로 분리된 어절이 몇 개인지 출력을 반복하는 프로그램을 작성하시오.
//		“exit”이 입력되면 종료한다.
//		apple, orange, banana, strawberry
//		어절 개수는 4
//		사과, 오렌지, 바나나
//		어절 개수는 3
//		exit
//		종료합니다...
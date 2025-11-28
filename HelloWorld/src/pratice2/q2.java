package pratice2;

import java.util.Scanner;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		
//	 5. 반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요 +2 씩표기하기 , 1 3 5 7
//		     *
//		    ***
//         *****
//		  *******

		int space = 3;
		int star = 1;
		// 4줄을 출력하는 반복문
		for (int i = 1; i <= 4; i++) {
			// 공백을 출력하는 반복문 3,2,1,0
			for (int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			space--;
			// 별을 출력하는 반복문 1,3,5,7
			for (int k = 1; k <= star; k++) {
				System.out.print("*");
			}
			star += 2;
			System.out.println();
		}
// ----------------------------------------------------
		for (int i = 0; i < 7; i += 2) {
			for (int z = 7; z > i; z -= 2) {
				System.out.print(" ");
			}
			for (int z = 0; z <= i; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

//	 6. 반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요 1 3 5 7 역순 
//		  *******
//		   *****
//		    ***
//		     *
//
//		{System.out.println();
//
//	
//	int space = 0;
//	int star = 7;for(
//	int i = 1;i<=4;i++)
//	{
//		for (int j = 1; j <= space; j++) {
//			System.out.print(" ");
//		}
//		space++;
//		for (int k = 1; k <= star; k++) {
//			System.out.print("*");
//		}
//		star -= 2;
//		System.out.println();
//	}

// -------------------------------------------------------
	for(
	int x = 7;x>=1;x-=2)
	{
		for (int y = 8; y > x; y -= 2) {
			System.out.print(" ");
		}
		for (int y = 0; y < x; y++) {
			System.out.print("*");
		}
		System.out.println();
	}

//	 7.반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요
//		    *
//		   ***
//		  *****
//	     *******
//		  *****
//		   ***
//		    *

	for(
	int i = 0;i<7;i+=2)
	{
		for (int z = 7; z > i; z -= 2) {
			System.out.print(" ");
		}
		for (int z = 0; z <= i; z++) {
			System.out.print("*");
		}
		System.out.println();
	}for(
	int x = 5;x>=1;x-=2)
	{
		for (int y = 8; y > x; y -= 2) {
			System.out.print(" ");
		}
		for (int y = 0; y < x; y++) {
			System.out.print("*");
		}
		System.out.println();
	}

//		
//	8.조건문과 반복문을 이용하여 가위바위보 게임을 만들어 보세요 .
//	5번을 이겼을 경우 게임이 끝나게 되며 한번 가위바위보를 실행할 떄마다 
//	사람과 컴퓨터의 가위바위보 내용,승패,승리횟수,패배횟수,를 출력합니다
//	----------------
//	가위(1) 바위(2) 보(3) 중에 선택해주세요 >> 1
//	플레이어 가위 바위 컴퓨터 패배
//	승리 : 0/5 패배 : 1
//	가위 바위 보 중에 선택해주세요 >> 바위
//	플레이어 바위 vs 가위 컴퓨터: 승리
//	승리:1/5 , 패배: 1
//		

	Scanner sc = new Scanner(System.in);
	int win = 0;
	int lose = 0;
	int tie = 0;
//arr[0]: arr[0]:가위, arr[1]: 바위, arr[2]:보
	String[] arr = { "가위", "바위", "보" };while(true)
	{
		System.out.print("가위(1),바위(2),보(3) 종료(4) 중에 입력해주세요>> ");
		int player = sc.nextInt();
//  math.random() : 0~1 사이의 소수점 숫자 출력하는 함수
//	0.1*3(int) = 0.3=0, 0.5*3 =(int) 1.5=1 ,0.9*3=(int)2.7=2
//	(int)(math.candom()*3) = 0~2 사이의 숫자
//	(int)(math.candom()*5) = 0~4 사이의 숫자
//	computer변수에 1~3 사이의 랜덤한 숫자가 저장됨
		int computer = (int) (Math.random() * 3 + 1);
		if (player == 4) {
			System.out.println("가위바위보 게임을 종료했습니다.");
			break;
		} else if (player == computer) {
			tie++;
			System.out.println("플레이어: " + arr[player - 1] + " vs " + arr[computer - 1] + " 컴퓨터와 비겼습니다");
			
		} else if ((player == 1 && computer == 3)
				|| (player == 2 && computer == 1)
				|| (player == 3 && computer == 2)) {
			System.out.println("플레이어: " + arr[player - 1] + " vs " + arr[computer - 1] + " 플레이어가 이겼습니다.");
			win++;
			System.out.println("승리:" + win + "/5 패배:" + lose+ "무승부: "+tie);
			
			if (win >= 5) {
				System.out.println("5번 승리하여 게임을 종료합니다.");
				break;
			}
			
			} else { if ((player == 1 && computer == 2)
					|| (player == 2 && computer == 3)
					|| (player == 3 && computer == 1)) {
				System.out.println("플레이어: " + arr[player - 1] + " vs " + arr[computer - 1] + " 플레이어가 졌습니다.");
				lose++;
				System.out.println("승리 : " + win + "/5  패배 : " + lose+ "무승부: "+tie);
			}
			}
		}
	}
	
	}

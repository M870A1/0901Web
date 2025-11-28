package Test2;

public class StudentScore {

	public static void main(String[] args) {

		int[][] scores = { 
				{ 80, 60, 70 },
				{ 90, 95, 80 },
				{ 75, 80, 100 },
				{ 80, 70, 95 },
				{ 100, 65, 80 } 
				};
		System.out.println(" 학생번호   국어   영어  수학  총점   평균");
		System.out.println("==========================================");
		for (int i = 0; i < scores.length; i++) {
			int sum = 0;
			for (int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
			}
			int avg = sum / 3;
			System.out.printf("%d번 학생:  %3d  %3d  %3d  %3d  %5.1f\n",
					i + 1, scores[i][0], scores[i][1], scores[i][2],
					sum,(double)avg);
			}
		}
	}


//[문제4] 작성할 클래스명: StudentScore 클래스

//학생별 교과목 점수와 총점, 평균을 구해서 아래와 같이 출력하는 프로그램을 만들어 봅니다.
//		                          
//학생번호   국어   영어   수학    총점    평균
//=============================================
//1번 학생:   80     60     70     210     70.0
//2번 학생:   90     95     80     265     88.0
//3번 학생:   75     80    100     255     85.0
//4번 학생:   80     70     95     245     81.0
//5번 학생:  100     65     80     245     81.0

//학생 다섯명에 대한 국어, 영어, 수학 세 과목별 점수는 아래의 2차원 배열로 준비합니다.
//int[][] scores = {
//  {80,60,70},
//	{90,95,80},
//	{75,80,100},
//	{80,70,95},
//	{100,65,80}
//};

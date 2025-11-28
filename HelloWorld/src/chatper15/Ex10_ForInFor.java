package chatper15;

public class Ex10_ForInFor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2차원 배열
		int[][] arr = new int[3][3];
		int num = 1;
// new int[3][3]으로 만들었을 때의 배열 인덱스
// [0][0],[0][1],[0][2],
// [1][0],[1][1],[1][2],
// [2][0],[2][1],[2][2],
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = num;
				num++;
			}
		}
		// 2차원 배열을 반복할때 배열안의 배열의 개수를 출력하려면 length를 사용해야 한다.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

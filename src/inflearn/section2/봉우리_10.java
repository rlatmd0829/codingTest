package inflearn.section2;

import java.util.Scanner;

public class 봉우리_10 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n+2][n+2];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int check = 0;
				for (int k = 0; k < 4; k++) {
					if (arr[i][j] <= arr[i+dx[k]][j+dy[k]]) {
						break;
					}
					check += 1;
				}
				if (check == 4) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}

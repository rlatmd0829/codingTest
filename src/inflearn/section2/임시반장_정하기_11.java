package inflearn.section2;

import java.util.Scanner;

public class 임시반장_정하기_11 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		int maxx = 0;
		int answer = 0;

		for (int k = 0; k < N; k++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (k == i) {
					continue;
				}
				for (int j = 0; j < 5; j++) {
					if (arr[k][j] == arr[i][j]) {
						cnt++;
						break;
					}
				}
			}
			int temp = maxx;
			maxx = Math.max(maxx, cnt);
			if (maxx != temp) {
				answer = k+1;
			}
		}
		if (answer == 0) {
			System.out.println(1);
		} else {
			System.out.println(answer);
		}
	}
}

package inflearn.section2;

import java.util.Scanner;

public class 격자판_최대합_9 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		int oneDiagonalSum = 0;
		int twoDiagonalSum = 0;
		int maxRowSum = 0;
		int maxColumnSum = 0;
		int maxDiagonalSum = 0;

		for (int i = 0; i < n; i++) {
			int rowSum = 0;
			for (int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
				rowSum += arr[i][j];
			}
			maxRowSum = Math.max(maxRowSum, rowSum);
		}

		for (int i = 0; i < n; i++) {
			int columnSum = 0;
			for (int j = 0; j < n; j++) {
				columnSum += arr[j][i];
			}
			maxColumnSum = Math.max(maxColumnSum, columnSum);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					oneDiagonalSum += arr[i][j];
				}
				if (i + j == n - 1) {
					twoDiagonalSum += arr[i][j];
				}
			}
		}
		maxDiagonalSum = Math.max(oneDiagonalSum, twoDiagonalSum);

		System.out.println(Math.max(Math.max(maxColumnSum, maxRowSum), maxDiagonalSum));

	}
}

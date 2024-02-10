package inflearn.section6;

import java.util.Scanner;

public class 삽입_정렬_3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 1; i < N; i++) {
			int tmp = arr[i];
			int j;
			for (j = i-1; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = tmp;
		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

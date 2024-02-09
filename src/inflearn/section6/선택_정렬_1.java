package inflearn.section6;

import java.util.Scanner;

public class 선택_정렬_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int idx = i;
			for (int j = i+1; j < N; j++) {
				if (arr[idx] > arr[j]) {
					idx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

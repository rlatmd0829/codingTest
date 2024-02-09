package inflearn.section6;

import java.util.Scanner;

public class 버블_정렬_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

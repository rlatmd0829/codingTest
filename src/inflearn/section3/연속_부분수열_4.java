package inflearn.section3;

import java.util.Scanner;

public class 연속_부분수열_4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		int sum = 0;
		int p1 = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum == M) {
				answer += 1;
			} else if (sum > M) {
				while (sum > M) {
					sum -= arr[p1++];
					if (sum == M) {
						answer += 1;
					}
				}
			}
		}
		System.out.println(answer);
	}
}

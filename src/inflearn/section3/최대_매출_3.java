package inflearn.section3;

import java.util.Scanner;

public class 최대_매출_3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] arr = new int[N];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		answer = sum;

		for (int i = K; i < N; i++) {
			int temp = sum - arr[i-K];
			temp += arr[i];
			sum = temp;
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}

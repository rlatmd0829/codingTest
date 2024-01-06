package inflearn.section3;

import java.util.Scanner;

public class 최대_길이_연속부분수열_6_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int answer = 0;
		int[] arr = new int[N];
		int lt = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		for (int rt = 0; rt < N; rt++) {
			if (arr[rt] == 0) {
				cnt++;
			}

			while (cnt > K) {
				if (arr[lt] == 0) {
					cnt--;
				}
				lt++;
			}
			answer = Math.max(answer, rt - lt + 1);
		}
		System.out.println(answer);
	}

}

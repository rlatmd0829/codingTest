package inflearn.section3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최대_길이_연속부분수열_6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int answer = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		int temp = K;
		int distance = 0;
		int l1 = 0;
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) {
				q.add(l1 + 1);
				l1 = 0;
				if (temp > 0) {
					temp -= 1;
					distance++;
				} else {
					answer = Math.max(answer, distance);
					distance = distance - q.poll();
					distance++;
				}
			} else {
				l1++;
				distance++;
			}
		}
		System.out.println(answer);
	}
}

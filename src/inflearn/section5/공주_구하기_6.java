package inflearn.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주_구하기_6 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();

		int answer = 0;

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			queue.poll();
			if (queue.size() == 1) {
				answer = queue.poll();
			}
		}

		System.out.println(answer);
	}
}

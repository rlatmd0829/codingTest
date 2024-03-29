package inflearn.section5;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 응급실_8 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < N; i++) {
			int num = in.nextInt();
			queue.add(num);
			priorityQueue.add(num);
		}

		int answer = 0;

		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (num == priorityQueue.peek()) {
				if (M == 0) {
					answer++;
					break;
				} else {
					answer++;
					priorityQueue.poll();
					M--;
				}
			} else {
				queue.add(num);
				if (M == 0) {
					M = queue.size() - 1;
				} else {
					M--;
				}
			}
		}

		System.out.println(answer);

	}
}

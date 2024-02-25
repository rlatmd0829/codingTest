package N_2024.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 과제_진행하기 {
	public static void main(String[] args) {
		String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
		List<String> result = solution(plans);
		System.out.println(Arrays.toString(result.toArray()));
	}

	public static List<String> solution(String[][] plans) {
		ArrayList<String> answer = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		PriorityQueue<Node> queue1 = new PriorityQueue<>();

		Arrays.sort(plans, Comparator.comparing(plan -> plan[1]));
		System.out.println(Arrays.deepToString(plans));

		for (int i = 0; i < plans.length - 1; i++) {
			String[] prev = plans[i+1][1].split(":");
			int a = Integer.parseInt(prev[0]) * 60 + Integer.parseInt(prev[1]);

			String[] now = plans[i][1].split(":");
			int b = Integer.parseInt(now[0]) * 60 + Integer.parseInt(now[1]);

			int temp = a - b;

			if (Integer.parseInt(plans[i][2]) > temp) {
				queue.add(new Node(plans[i][0], Integer.parseInt(plans[i][2]) - temp));
			} else {
				Node node = queue.poll();
				answer.add(plans[i][0]);
			}
		}

		return answer;
	}

	public static class Node{
		String name;
		int time;

		public Node(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}
}

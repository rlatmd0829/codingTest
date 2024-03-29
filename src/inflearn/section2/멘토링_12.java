package inflearn.section2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class 멘토링_12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		Map<Node, Integer> map = new HashMap<>();
		int answer = 0;

		for (int k = 0; k < M; k++) {
			for (int i = 0; i < arr[0].length - 1; i++) {
				for (int j = i + 1; j < arr[0].length; j++) {
					map.put(new Node(arr[k][i], arr[k][j]), 0);
				}
			}
		}

		for (Node node : map.keySet()) {
			if (map.get(new Node(node.y, node.x)) == null) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static class Node {
		public int x;
		public int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}

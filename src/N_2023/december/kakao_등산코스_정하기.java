package N_2023.december;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_등산코스_정하기 {
	public static void main(String[] args) {
		int n = 6;
		int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
		int[] gates = {1, 3};
		int[] summits = {5};
		int[] answer = solution(n, paths, gates, summits);
	}

	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] answer = {};

		int[][] arr = new int[n+1][n+1];
		boolean[] visited = new boolean[n+1];

		for (int i = 0; i < paths.length; i++) {
			int a = paths[i][0];
			int b = paths[i][1];
			int c = paths[i][2];
			arr[a][b] = arr[b][a] = c;
		}

		for (int gate : gates) {
			for (int summit : summits) {
				bfs(arr, n, gates, summits, gate, summit);
			}
		}

		return answer;
	}

	public static void bfs(int[][] arr, int n, int[] gates, int[] summits, int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int now = queue.remove();
			for (int i = 1; i <= n; i++) {
				if (arr[now][i] > 0) {

				}
			}
		}
	}
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public static final int[] dx = {-1, 1, 0, 0};
	public static final int[] dy = {0, 0 , -1, 1};
	public static final Map<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(int[][] arr) {
		int[] answer = new int[2];
		int length = arr.length;
		map.put(0, 0);
		map.put(1, 0);
		boolean[][] visited = new boolean[arr.length][arr.length];

		// while (length > 1) {
		// 	boolean oneQuadrant = bfs(arr, 0, 0, length/2, length/2);
		// 	boolean twoQuadrant = bfs(arr, 0, length/2, length/2, length);
		// 	boolean threeQuadrant = bfs(arr, length/2, 0, length, length/2);
		// 	boolean fourQuadrant = bfs(arr, length/2, length/2, length, length);
		// 	length = length/2;
		// }
		recursive(arr, 0, 0, length, length, length, visited);

		answer[0] = map.get(0);
		answer[1] = map.get(1);

		return answer;
	}

	public void recursive(int[][] arr, int x1, int y1, int x2, int y2, int length, boolean[][] visited) {
		if (length == 1) {
			if (!visited[x1][y1] && arr[x1][y1] == 1) {
				map.put(1, map.get(1) + 1);
			} else if (!visited[x1][y1] && arr[x1][y1] == 0) {
				map.put(0, map.get(0) + 1);
			}
			// if (!visited[x1+1][y1] && arr[x1+1][y1] == 1) {
			// 	map.put(1, map.get(1) + 1);
			// } else if (!visited[x1+1][y1] && arr[x1+1][y1] == 0) {
			// 	map.put(0, map.get(0) + 1);
			// }
			// if (!visited[x1][y1+1] && arr[x1][y1+1] == 1) {
			// 	map.put(1, map.get(1) + 1);
			// } else if (!visited[x1][y1+1] && arr[x1][y1+1] == 0){
			// 	map.put(0, map.get(0) + 1);
			// }
			// if (!visited[x1+1][y1+1] && arr[x1+1][y1+1] == 1) {
			// 	map.put(1, map.get(1) + 1);
			// } else if (!visited[x1+1][y1+1] && arr[x1+1][y1+1] == 0){
			// 	map.put(0, map.get(0) + 1);
			// }
			visited[x1][y1] = true;
			// visited[x1+1][y1] = true;
			// visited[x1][y1+1] = true;
			// visited[x1+1][y1+1] = true;
			return;
		}

		boolean check = bfs(arr, x1, y1, x2, y2);
		if (check) {
			map.put(arr[x1][y1], map.get(arr[x1][y1]) + 1);

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					visited[i][j] = true;
				}
			}

			return;
		}

		recursive(arr, x1, y1, x1 + length/2, y1 + length/2, length/2, visited);
		recursive(arr, x1, y1 + length/2, x1 + length/2, y2, length/2, visited);
		recursive(arr, x1 + length/2, y1, x2, y1 + length/2, length/2, visited);
		recursive(arr, x1 + length/2, y1 + length/2, x2, y2, length/2, visited);
	}

	public boolean bfs(int[][] arr, int x1, int y1, int x2, int y2) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x1, y1));
		boolean[][] bfsVisited = new boolean[arr.length][arr.length];
		int key = arr[x1][y1];
		bfsVisited[x1][y1] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int qx = node.x;
			int qy = node.y;
			for (int i = 0; i <4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (nx >= x1 && ny >= y1 && nx < x2 && ny < y2) {
					if (!bfsVisited[nx][ny]) {
						bfsVisited[nx][ny] = true;
						if (key == arr[nx][ny]) {
							queue.add(new Node(nx, ny));
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
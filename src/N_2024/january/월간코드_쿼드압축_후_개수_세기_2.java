package N_2024.january;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 월간코드_쿼드압축_후_개수_세기_2 {
	public static final int[] dx = {-1, 1, 0, 0};
	public static final int[] dy = {0, 0 , -1, 1};
	public static final Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		solution(arr);
	}

	public static int[] solution(int[][] arr) {
		int[] answer = {};
		int length = arr.length;
		map.put(0, 0);
		map.put(1, 0);
		boolean[][] visited = new boolean[arr.length][arr.length];
		boolean oneCheck = false;
		boolean twoCheck = false;
		boolean threeCheck = false;
		boolean fourCheck = false;


		while (length > 1) {
			if (!oneCheck) {
				oneCheck = bfs(arr, 0, 0, length/2, length/2);
			} else {
				map.put(arr[0][0], map.get(arr[0][0]) + 1);
			}
			if (!twoCheck) {
				twoCheck = bfs(arr, 0, length/2, length/2, length);
			} else {
				map.put(arr[0][length/2], map.get(arr[0][length/2]) + 1);
			}
			if (!threeCheck) {
				threeCheck = bfs(arr, length/2, 0, length, length/2);
			} else {
				map.put(arr[length/2][0], map.get(arr[length/2][0]) + 1);
			}
			if (!fourCheck) {
				fourCheck = bfs(arr, length/2, length/2, length, length);
			} else {
				map.put(arr[length/2][length/2], map.get(arr[length/2][length/2]) + 1);
			}
			length = length/2;
		}

		System.out.println(map.get(0));
		System.out.println(map.get(1));

		return answer;
	}
	public static boolean bfs(int[][] arr, int x1, int y1, int x2, int y2) {
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

	public static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

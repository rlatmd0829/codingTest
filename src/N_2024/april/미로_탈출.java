package N_2024.april;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {
	public static void main(String[] args) {
		String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
		int result = solution(maps);
		System.out.println(result);
	}

	public static int solution(String[] maps) {
		String[][] map = new String[maps.length][maps[0].length()];
		for (int i = 0; i < maps.length; i++) {
			map[i] = maps[i].split("");
		}

		Node startNode = null;
		Node leverNode = null;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j].equals("S")) {
					startNode = new Node(i, j, 0);
				}
				if (map[i][j].equals("L")) {
					leverNode = new Node(i, j, 0);
				}
			}
		}

		int result1 = bfs(map, startNode, "L");
		int result2 = bfs(map, leverNode, "E");

		if (result1 == -1 || result2 == -1) {
			return -1;
		}

		return result1 + result2;
	}

	public static int bfs(String[][] map, Node newNode, String target) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		queue.add(newNode);
		visited[newNode.x][newNode.y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
					continue;
				}

				if (map[nx][ny].equals(target)) {
					return node.count + 1;
				}

				if (!map[nx][ny].equals("X") && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, node.count + 1));
				}
			}
		}
		return -1;
	}

	public static class Node{
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}

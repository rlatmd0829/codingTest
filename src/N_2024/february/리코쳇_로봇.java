package N_2024.february;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class 리코쳇_로봇 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static String[][] str;
	public static boolean[][] visited;
	public static int[][] distance;

	public static void main(String[] args) {
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		// String[] board = {".D.R", "....", ".G..", "...D"};
		int result = solution(board);
		System.out.println(result);
	}

	public static int solution(String[] board) {
		int answer = 0;
		str = new String[board.length][board[0].length()];
		visited = new boolean[board.length][board[0].length()];
		distance = new int[board.length][board[0].length()];

		for (int i = 0; i < board.length; i++) {
			str[i] = board[i].split("");
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (Objects.equals(str[i][j], "R")) {
					answer = bfs(i,j);
				}
			}
		}




		return answer;
	}

	public static int bfs(int a, int b) {
		Queue<Node> queue = new LinkedList();
		queue.add(new Node(a,b));
		visited[a][b] = true;
		int count = 0;
		boolean check = false;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			for (int i = 0; i < 4; i++) {
				int nx = x;
				int ny = y;

				while (nx > 0 && ny > 0 && nx < str.length -1 && ny < str[0].length - 1 && !Objects.equals(str[nx][ny], "D")) {
					nx += dx[i];
					ny += dy[i];
				}

				// if (nx >= 0 && ny >= 0 && nx < str.length && ny < str[0].length) {
				if (!visited[nx][ny] && Objects.equals(str[nx][ny], ".")) {
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
					// distance[nx][ny] =
					count++;
				} else if (Objects.equals(str[nx][ny], "G")) {
					check = true;
					count++;
					return count;
				}
				// }
			}
		}
		if (!check) {
			return -1;
		} else {
			return count;
		}
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

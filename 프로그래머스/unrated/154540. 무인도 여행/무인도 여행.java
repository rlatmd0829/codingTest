import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public char[][] graph;
	public boolean[][] visited;
	public int[] dx = {-1, 1, 0, 0}; // 상하좌우
	public int[] dy = {0, 0, -1, 1};
	public int N;
	public int M;
    public List<Integer> solution(String[] maps) {
		List<Integer> answer = new ArrayList<>();
		N = maps.length;
		M = maps[0].length();
		graph = new char[N][M];

		for (int i = 0; i < maps.length; i++) {
			graph[i] = maps[i].toCharArray();
		}
		visited = new boolean[N][M];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] != 'X' && !visited[i][j]) {
					answer.add(bfs(i, j));
				}
			}
		}
		if (answer.size() == 0) {
			answer.add(-1);
		}
		Collections.sort(answer);
		return answer;
	}

	public int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		int count = Character.getNumericValue(graph[x][y]);

		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int qx = q[0];
			int qy = q[1];

			for (int i = 0; i < 4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (visited[nx][ny] || graph[nx][ny] == 'X') {
					continue;
				}

				queue.add(new int[] {nx, ny});
				count += Character.getNumericValue(graph[nx][ny]);
				visited[nx][ny] = true;
			}
		}
		return count;
	}
}
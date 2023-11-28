import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
		// 아래, 왼, 오, 위
		int[] dx = {1,0,0,-1};
		int[] dy = {0,-1,1,0};
		String[] dc = {"d", "l", "r", "u"}; // 사전순으로 돌아보기 위함
		List<String> resultList = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, ""));

		int move = 0;
		while (!queue.isEmpty()) {
			move++;
			Node node = queue.remove();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				int remainDistance = Math.abs(nx - r) + Math.abs(ny - c); // 두점 사이의 가로 세로 거리 합
				if (0 < nx && 0 < ny && nx <= n && ny <= m) {
					// 모든 경우를 돌아보는게 아니라 의미있는 경우만 진행한다.
					// 1. k에서 이동한값을 뺐을때 남은거리보다 크거나 같을경우에만 진행한다.
					// 2. k에서 이동한값을 빼고 남은거리를 뺐을때 짝수일때 진행한다. -> 짝수여야만 돌아올수 있으므로
					if (k - move >= remainDistance && (k - move - remainDistance) % 2 == 0) {
						String result = node.result + dc[i];
						if (node.result.length() < k) {
							queue.add(new Node(nx, ny, result));
						}
						if (nx == r && ny == c && k == result.length()) {
							resultList.add(result);
						}
						break; // d, l, r, u 사전순으로 진행하여 해당값이 넣어질경우 나머지는 안봐도된다.
					}
				}
			}
		}
		if (resultList.isEmpty()) {
			return "impossible";
		}
		Collections.sort(resultList);
		return resultList.get(0);
	}

	public class Node {
		int x;
		int y;
		String result;

		public Node(int x, int y, String result) {
			this.x = x;
			this.y = y;
			this.result = result;
		}
	}
}
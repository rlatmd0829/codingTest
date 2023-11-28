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
		String[] dc = {"d", "l", "r", "u"};
		List<String> resultList = new ArrayList<>();



		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, ""));

		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			Node node = queue.remove();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				int d = Math.abs(nx - r) + Math.abs(ny - c);
				if (0 < nx && 0 < ny && nx <= n && ny <= m) {
					if (k - cnt >= d && (k - cnt - d) % 2 == 0) {
						if (node.result.length() < k) {
							queue.add(new Node(nx, ny, node.result + dc[i]));
						}
						if (nx == r && ny == c) {
							String result = node.result + dc[i];
							if ((result).length() == k) {
								resultList.add(result);
							}
							// break;
						}
						break;
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